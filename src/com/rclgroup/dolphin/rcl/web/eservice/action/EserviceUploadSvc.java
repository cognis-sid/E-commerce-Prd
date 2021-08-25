/*
-------------------------------------------------------------------------------------------------------------
 EserviceUploadSvc.java
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------  
Author Pratya Thanuchaisak 08/08/2014
- Change Log ------------------------------------------------------------------------------------------------
## DD/MM/YY      -User-          -TaskRef-         -ShortDescription-
-------------------------------------------------------------------------------------------------------------
*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import com.niit.control.web.action.BaseAction;

import java.io.File;

import java.io.FileOutputStream;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceUploadUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceUploadMod;

import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;

import java.io.PrintWriter;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;


public class EserviceUploadSvc extends BaseAction {

    private static final long serialVersionUID = 1L;
    
    private static final String SUBMIT              = "onSubmit";
    private static final String GET_DATA            = "getData";
    private static final String SEND_FILE_TO_TEMP   = "sendFileToTemp";
    private static final String DELETE              = "onDelete";
    
    private HttpServletRequest          request;
    private HttpServletResponse         response;
    private EserviceNewWebBookingDao    newWebObjDao;
    private EserviceUploadUim           form = null;
        
    public EserviceUploadSvc() {
        
    }

    private String getForwardPage(ActionMapping mapping, ActionForm actionForm, EserviceUploadUim form1, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String pageAction   = null;
        String forwardPage  = null;
        
        try{
            pageAction = form1.getCurrPageAction();
            
            this.request            = request;
            this.response           = response;
            this.newWebObjDao       = getDao();
            this.form               = form1;
        
            if (ONLOAD.equals(pageAction)) {             
                this.form.setUserId(getUserID(request));
                forwardPage = this.onLoad();
            }else if(SUBMIT.equals(pageAction)) {             
                forwardPage = this.onSubmit();
            }else if(GET_DATA.equals(pageAction)) {             
                forwardPage = this.onGetData();
            }else if(SEND_FILE_TO_TEMP.equals(pageAction)) {             
                forwardPage = this.sendFileToTemp();
            }else if(DELETE.equals(pageAction)) {             
                forwardPage = this.onDelete();
            }
            
        } catch(Exception ex){
            throw ex;
        }
        return forwardPage;
    }

    /**
     *
     * Called from Action Servlet
     *
     * @param mapping ActionMapping
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception{
        EserviceUploadUim               form1           = null;
        String                          pageAction      = null;
        String                          errorMsg        = null;
        String                          forwardPage     = null;
        try{
            pageAction = getPageAction(mapping);

            form1 = getForm(actionForm, pageAction);
            form1.setCurrPageAction(pageAction);
            forwardPage = getForwardPage(mapping, actionForm, form1, request, response);
        } catch(Exception ex){
            ex.printStackTrace();
            errorMsg = ex.getMessage();
            form1.setErrMsg(errorMsg);

            forwardPage = FAILURE;
        }
        return mapping.findForward(forwardPage);
    }

    private EserviceUploadUim getForm(ActionForm actionForm, String pageAction) throws Exception{
        EserviceUploadUim form1 = null;
        try{
            form1 = (EserviceUploadUim) actionForm;
            if (form1 == null){
                form1 = new EserviceUploadUim();
            }else if(ONLOAD.equals(pageAction)){
                form1.resetForm();
            }
        } catch(Exception ex){
            throw ex;
        }

        return form1;
    }

    private String getPageAction(ActionMapping mapping) throws Exception{
        String pageAction = null;
        try{
            pageAction = mapping.getParameter();
        } catch(Exception ex){
            pageAction = "";
        }

        return pageAction;
    }

    private EserviceNewWebBookingDao getDao() throws Exception{
        EserviceNewWebBookingDao dao = null;
        try{
            dao = (EserviceNewWebBookingDao) getDao(EserviceNewWebBookingDao.DAO_NAME);
        } catch(Exception ex){
            throw ex;
        }
        return dao;
    }
    /**
     * This method called when screen loads
     * @return
     * @throws Exception
     */
    public String onLoad() throws Exception {
        System.out.println("[EserviceUploadSvc][onLoad][Begin]");
        
        String                      forwardPage                     = FAILURE;
        String                      filePathConf                    = null;
        
        try{
            forwardPage                 = SUCCESS;
            filePathConf                = this.newWebObjDao.getConfigPath();
            
            System.out.println("[EserviceUploadSvc][onLoad] filePathConf :: " + filePathConf);
            
            //For test
//            filePathConf = "D:/uploads";
            
            this.form.setFilePathConf(filePathConf);
            
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceUploadSvc][onLoad][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
     /**
      * This method called when screen onSubmit
      * @return
      * @throws Exception
      */
     public String onSubmit() throws Exception {
         System.out.println("[EserviceUploadSvc][onSubmit][Begin]");
         
         EserviceNewWebBookingUim       eserviceNewWebBookingUim        = null;
         EserviceUploadUim              eserviceUploadUim               = null;
         int                            size                            = 0;
         
         try{
             eserviceNewWebBookingUim       = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
             eserviceUploadUim              = this.form;
             size                           = eserviceUploadUim.getList().size();
             
             if(size > 0){
                eserviceNewWebBookingUim.setUploadFlag("Y");
             }else{
                 eserviceNewWebBookingUim.setUploadFlag("N");
             }
             
             eserviceNewWebBookingUim.setEserviceUploadUim(eserviceUploadUim);
             
             System.out.println("[EserviceUploadSvc][onSubmit] UploadFlag :: " + eserviceNewWebBookingUim.getUploadFlag());
             
             this.writeMSG("OK::" + eserviceNewWebBookingUim.getUploadFlag());
             
         }catch(Exception e){
             e.printStackTrace();
             this.writeMSG("ERROR::" + e.getMessage());
         }finally{
             System.out.println("[EserviceUploadSvc][onSubmit][End]");
         }
         return null;

     }
     
    public String onDelete() throws Exception {
        System.out.println("[EserviceUploadSvc][onDelete][Begin]");
        
        EserviceNewWebBookingUim        eserviceNewWebBookingUim        = null;
        EserviceUploadUim               eserviceUploadUim               = null;
        String                          seq                             = null;
        int                             listSize                        = 0;
        List                            list                            = null;
        EserviceUploadMod               eserviceUploadMod               = null;
        int                             totalSize                       = 0;
        
        try{
            eserviceNewWebBookingUim        = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
            eserviceUploadUim               = this.form;
            seq                             = this.nullToSpace(this.request.getParameter("seq"));
            list                            = eserviceUploadUim.getList();
            
            for(int i=0;i<list.size();i++){
                eserviceUploadMod = (EserviceUploadMod)list.get(i);
                if(eserviceUploadMod.getSeq().equals(seq)){
                    
                    totalSize = eserviceUploadUim.getTotalSize() - eserviceUploadMod.getSize();
                    
                    if(eserviceUploadMod.getStatus().equals(EserviceNewWebBookingDao.ADD_OPERATION)){
                        list.remove(i);
                    }else{
                        eserviceUploadMod.setStatus(EserviceNewWebBookingDao.DEL_OPERATION);
                    }
                    break;
                }
            }
            
            for(int i=0;i<list.size();i++){
                if(!eserviceUploadMod.getStatus().equals(EserviceNewWebBookingDao.DEL_OPERATION)){
                    listSize++;
                    break;
                }
            }
            
            if(listSize > 0) eserviceNewWebBookingUim.setUploadFlag("N");
            
            eserviceUploadUim.setTotalSize(totalSize);
            this.request.getSession().setAttribute("feserv23", eserviceUploadUim);
            
            this.writeMSG("OK");
            
        }catch(Exception e){
            e.printStackTrace();
            this.writeMSG("ERROR::" + e.getMessage());
        }finally{
            System.out.println("[EserviceUploadSvc][onDelete][End]");
        }
        return null;

    }
     
    public String sendFileToTemp() throws Exception {
        System.out.println("[EserviceUploadSvc][sendFileToTemp][Begin]");
        
        boolean                         isMultipart                     = ServletFileUpload.isMultipartContent(this.request);
        String                          fileName                        = null;
        String                          newFileName                     = null;
        String[]                        fileTypeS                       = null;
        String                          fileType                        = null;
        int                             size                            = 0;
        long                            curr                            = System.currentTimeMillis();
        EserviceUploadMod               eserviceUploadMod               = null;
        int                             totalSize                       = 0;
        int                             limitSize                       = 2048000;//2 MB
        EserviceUploadUim               eserviceUploadUim               = null;
        int                             newSeq                          = 0;
        FormFile                        dataFile                        = null;
        String                          sizeDisplay                     = null;
        
        
        try{        
            System.out.println("[EserviceUploadSvc][sendFileToTemp] isMultipart :: " + isMultipart);
                                    
            if (isMultipart) {
                eserviceUploadUim               = this.form;
                newSeq                          = Integer.parseInt(eserviceUploadUim.getMaxSeq());
                dataFile                        = eserviceUploadUim.getDataFile();

                System.out.println("[EserviceUploadSvc][sendFileToTemp] this.request :: " + this.request);
                System.out.println("[EserviceUploadSvc][sendFileToTemp] dataFile :: " + dataFile);

                if(dataFile!=null){
                    eserviceUploadMod               = new EserviceUploadMod();
                    fileName                        = new File(dataFile.getFileName()).getName();
                    fileTypeS                       = fileName.split("\\.");
                    fileType                        = fileTypeS[(fileTypeS.length - 1)];
                    newFileName                     = String.valueOf(curr) + "." + fileType;
                    size                            = dataFile.getFileSize();
                    totalSize                       = size + eserviceUploadUim.getTotalSize();
                    sizeDisplay                     = String.valueOf(Math.round(size/1000));
                    
                    newSeq++;
                    
                    System.out.println("FileUploadSvc][sendFileToTemp] fileName :: " + fileName);
                    System.out.println("FileUploadSvc][sendFileToTemp] fileType :: " + fileType);
                    System.out.println("FileUploadSvc][sendFileToTemp] size :: " + size);
                    System.out.println("FileUploadSvc][sendFileToTemp] sizeDisplay :: " + sizeDisplay);
                    System.out.println("FileUploadSvc][sendFileToTemp] totalSize :: " + totalSize);
                    System.out.println("FileUploadSvc][sendFileToTemp] newFileName :: " + newFileName);
                    System.out.println("FileUploadSvc][sendFileToTemp] seq :: " + newSeq);
                    
                    if(totalSize > limitSize){
                        throw new CustomDataAccessException("Total size limit 2 MB");
                    }
                    
                    eserviceUploadMod.setSeq(String.valueOf(newSeq));
                    eserviceUploadMod.setFileName(fileName);
                    eserviceUploadMod.setFileType(fileType);
                    eserviceUploadMod.setNewFileName(newFileName);
                    eserviceUploadMod.setSize(size);
                    eserviceUploadMod.setSizeDisplay(sizeDisplay);
                    eserviceUploadMod.setDataFile(dataFile);
                    eserviceUploadMod.setStatus(EserviceNewWebBookingDao.ADD_OPERATION);
                    
                    eserviceUploadUim.getList().add(eserviceUploadMod);

                }
                
                eserviceUploadUim.setMaxSeq(String.valueOf(newSeq));
                eserviceUploadUim.setTotalSize(totalSize);
                this.request.getSession().setAttribute("feserv23", eserviceUploadUim);
            }
            this.writeMSG("OK::" + fileName + "||" + newSeq + "||" + EserviceNewWebBookingDao.ADD_OPERATION + "||" + sizeDisplay);
            
        }catch(CustomDataAccessException e){
            e.printStackTrace();
            this.writeMSG("ERROR::" + e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            this.writeMSG("ERROR::" + e.getMessage());
        }finally{
            System.out.println("[EserviceUploadSvc][sendFileToTemp][End]");
        }
        return null;

    }
     
     public String nullToSpace(String av_obj){
         String lv_str = "";
         
         try{
             if(av_obj!=null){
                 lv_str = av_obj;
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         return lv_str;
     }
     
    public String nullToSpaceForCheckbox(String av_obj){
        String lv_str = "N";
        
        try{
            if(av_obj!=null){
                lv_str = av_obj;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return lv_str;
    }
     
    /**
     * This method called when screen loads
     * @return
     * @throws Exception
     */
    public String onGetData() throws Exception {
        System.out.println("[EserviceUploadSvc][onGetData][Begin]");
        
        String                      forwardPage                     = FAILURE;
        EserviceNewWebBookingUim    eserviceNewWebBookingUim        = null;
        String                      filePathConf                    = null;
        String                      newFileName                     = null;
//        String                      link                            = null;
        EserviceUploadUim           eserviceUploadUim               = null;
        List                        list                            = null;
        EserviceUploadMod           eserviceUploadMod               = null;
        String                      disBtn                          = null;
        File                        newFile                         = null;
        int                         size                            = 0;
        String                      sizeDisplay                     = null;
        
        try{
            eserviceNewWebBookingUim    = (EserviceNewWebBookingUim)this.request.getSession().getAttribute("feserv01");
            filePathConf                = this.newWebObjDao.getConfigPath();
            
            //For test
//            filePathConf                = "D:/uploads";
            
            forwardPage                 = SUCCESS;
            eserviceUploadUim           = eserviceNewWebBookingUim.getEserviceUploadUim();
            list                        = eserviceUploadUim.getList();
            disBtn                      = this.request.getParameter("disBtn");
            
            for(int i=0;i<list.size();i++){
                eserviceUploadMod   = (EserviceUploadMod)list.get(i);
                newFileName         = eserviceUploadMod.getNewFileName();
//                link                = this.sanitizeURLString(filePathConf + "/" + newFileName);
                newFile             = new File(filePathConf, newFileName);
                size                = (int)newFile.length();
                
//                System.out.println("[EserviceUploadSvc][onGetData] link :: " + link);
                System.out.println("[EserviceUploadSvc][onGetData] file size :: " + size);
                
                if(size > 0){
                    eserviceUploadMod.setSize(size);
                    
                    sizeDisplay     = String.valueOf(Math.round(size/1000));
                    eserviceUploadMod.setSizeDisplay(sizeDisplay);
                }
//                eserviceUploadMod.setLink(link);
            }
            
            System.out.println("[EserviceUploadSvc][onGetData] disBtn :: " + disBtn);
            if(disBtn!=null && !disBtn.equals("")){
                eserviceUploadUim.setDisBtn(disBtn);
            }
            
            this.request.getSession().setAttribute("feserv23", eserviceUploadUim);
      
        }catch(Exception ex){
            ex.printStackTrace();   
        }finally{
            System.out.println("[EserviceUploadSvc][onGetData][End]");

        }
        return forwardPage;

    } // end of onLoad method
    
//     public static String sanitizeURLString(String av_val){
//             
//         System.out.println("[EserviceUploadSvc][sanitizeURLString][Begin]");
//         String[]    la_symbol   = {"%" , "<" , ">" , "#" , "{" , "}" , "|" , "\\" , "^" , "~" , "[" , "]" , "`" , ";" , "/" , "?" , ":" , "@" , "=" , "&" , "$"};
//         String[]    la_replace  = {"%25", "%3C", "%3E", "%23", "%7B", "%7D", "%7C", "%5C", "%5E", "%7E", "%5B", "%5D", "%60", "%3B", "%2F", "%3F", "%3A", "%40", "%3D", "%26", "%24"};
//         String      lv_return   = null;
//         
//         try{
//             
//                 lv_return = av_val;
//                 
//             for(int i=0;i<la_symbol.length;i++){
//                 if(av_val.indexOf(la_symbol[i]) > -1){
//                         
//                     lv_return = lv_return.replaceAll("\\" + la_symbol[i], la_replace[i]);
//                 }
//             }
//                         
//         }catch(Exception e){
//             e.printStackTrace();
//         }finally{
//             System.out.println("[EserviceUploadSvc][sanitizeURLString][End]");
//         }
//         
//         return lv_return;
//     }

    private void writeMSG(String msg){
         PrintWriter            print                   = null;
         try{
            response.setContentType("text/html");
            print = response.getWriter();
            print.write(msg);
         }catch (Exception e) {
                e.printStackTrace();
         }
    }
}

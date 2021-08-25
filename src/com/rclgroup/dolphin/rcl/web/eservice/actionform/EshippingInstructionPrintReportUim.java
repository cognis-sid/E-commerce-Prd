package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.BaseActionForm;

import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionPrintDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EReportServerConfigMod;

import java.util.Vector;

public class EshippingInstructionPrintReportUim  extends PaginationForm {

    //   Start Search Criteria 
        private String service;
        private String vessel;
        private String voyage;
        private String direction;
        
        private short serviceOk;
        private short vesselOk;
        private short voyageOk;
        
        private String bl;
        private String office;
        private String cocSoc;
        private String createOffice;
        
        private short blOk;
        private short createOfficeOk;
       
        private String print;
        private String dateTo;
        private String dateFrom;
        private String dateToC;
        private String dateFromC;
        private String shipStatus;

         private String thirdLocation;
         private String includeCharge;
         private String printBL;
        //   End Search Criteria

        private String fsc;
        private String reportUrl;
        private String sessionID; 
        private String userCode;
        private String pageAction;
        private String reportName;
        private String reportFormat;
        private String vesselName;

        private Vector listBlPrint;
        
        private EshippingInstructionPrintDao eshippingInstructionPrintDao;
        
        public static final String REPORT_FORMAT_PDF = "PDF";
        
        
    protected String level;
    protected String lineCodeOfUser;
    protected String regionCodeOfUser;
    protected String agentCodeOfUser;
    protected String fscCodeOfUser;
    protected String prsnLogIdOfUser;
    protected String fscFromLogin;    
    protected int noOfResultRec;
    protected int rutPageVersion;
    protected boolean isControlFsc;
    private String errMsg;

        public EshippingInstructionPrintReportUim() {
        
            this.service = "";
            this.vessel = "";
            this.voyage = "";
            this.direction = "";
            
          
            
            this.bl = "";
            this.office = "";        
            this.cocSoc = "";  
            this.createOffice = "";        
            
         

            this.print = "";
            this.dateTo = "";
            this.dateFrom = "";
            this.dateToC = "";
            this.dateFromC = "";
            this.shipStatus = "";
            
            this.thirdLocation = "";
            //   End Search Criteria         
            
          

            this.fsc = "";
            this.reportUrl = "";
            this.sessionID = "";
            this.userCode = "";
            this.pageAction = "";
            this.reportName = "";
            this.reportFormat = REPORT_FORMAT_PDF;
            this.vesselName = "";
            

        }

        public void setService(String service) {
            this.service = service.toUpperCase();
          
        }

      

        public String getVessel() {
            return vessel;
        }


        
        public boolean isServiceOk(){
            if(!service.equals("")){
                if(serviceOk == 1){
                        return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }

        public String getService() {
            return service;
        }

        public void setVessel(String vessel) {
            this.vessel = vessel.toUpperCase();
         
        }
    
      

        public String getVoyage() {
            return voyage;
        }
        public void setVoyage(String voyage) {
            this.voyage = voyage.toUpperCase();
        
        }
        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }

        public void setCocSoc(String cocSoc) {
            this.cocSoc = cocSoc;
        }

        public String getCocSoc() {
            return cocSoc;
        }

       
        public void setFsc(String fsc) {
            this.fsc = fsc;
        }

        public String getFsc() {
            return fsc;
        }

        public void setReportFormat(String reportFormat) {
            this.reportFormat = reportFormat;
        }

        public String getReportFormat() {
            return reportFormat;
        }

   

        public void setPageAction(String pageAction) {
            this.pageAction = pageAction;
        }

        public String getPageAction() {
            return pageAction;
        }
    
        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setReportName(String reportName) {
            this.reportName = reportName;
        }

        public String getReportName() {
            return reportName;
        }

       public void setOffice(String office) {
           this.office = office;
       }

       public String getOffice() {
           return office;
       }
       
       

       public void setReportUrl(String reportUrl) {
           this.reportUrl = reportUrl;
       }

       public String getReportUrl() {
           return reportUrl;
       }

     

       public String getBl() {
           return bl;
       }

        public void setBl(String bl) {
            if(bl!=null){
            this.bl = bl.toUpperCase();
            }else{
                this.bl = bl;
            }
        }
        
       public void generateListBlPrint( EshippingInstructionPrintDao objDao){
           String sessionId = " ";
           Vector blPrint = null;
           this.listBlPrint = null;

           try{
               sessionId = objDao.getSessionId(
                                                                         this.service  ,          this. vessel,            this. voyage,         this.direction, 
                                                                         this.createOffice ,  this.bl,                      this.cocSoc,          this.print,
                                                                         this.shipStatus,      this.dateFromC,    this.dateToC,        this.thirdLocation,
                                                                         this.fsc,                    this.userCode,        "",                            this.lineCodeOfUser,
                                                                         this.regionCodeOfUser,                         this.agentCodeOfUser,            this.fscFromLogin 
                                                                         );
               blPrint = objDao.getListBLPrint( sessionId,this.userCode);
               setSessionID(sessionId);
               System.out.println(" sessionId >>>>>>>>>>>>  " + sessionId);
               System.out.println(" userCode >>>>>>>>  " +this.userCode);
               this.setListBlPrint(blPrint);
               this.sessionID = sessionId;
               System.out.println(" blPrint size >>>>>>>>  " +blPrint.size());
           }catch (Exception e){
               blPrint = null;
               e.printStackTrace();
               System.out.println("error >>>>>>>>>>>>> "+e.getMessage());
           }
           
       }
       
       
       // teerakan add generateReport BookingNumber 
       
        public void generateListBKGPrint( EshippingInstructionPrintDao objDao,String blnumber){
        
        
            Vector blPrint = null;
            this.listBlPrint = null;

            try{
            
                blPrint = objDao.getListBKGPrint(blnumber);
            
                this.setListBlPrint(blPrint);
           //     System.out.println(" blPrint size >>>>>>>>  " +blPrint.size());
            }catch (Exception e){
                blPrint = null;
                e.printStackTrace();
                System.out.println("error >>>>>>>>>>>>> "+e.getMessage());
            }
            
            }
       
       
       
    public String getReportUrlConstant(EshippingInstructionPrintDao objDao) {
        EReportServerConfigMod reportServerConfigMod = objDao.getDefaultReportServerConfigMod();
        String reportUrlConstant = "http://"+reportServerConfigMod.getServerName()+":"+reportServerConfigMod.getPortNumber()+"/reports/rwservlet?rclrepenv&report=";
        return reportUrlConstant;
    }
    

       public void setListBlPrint(Vector listBlPrint) {
           this.listBlPrint = listBlPrint;
       }

       public Vector getListBlPrint() {
           return listBlPrint;
       }
    
       public void setSessionID(String sessionID) {
           this.sessionID = sessionID;
       }

       public String getSessionID() {
           return sessionID;
       }
    
  

       public void setDateFrom(String dateFrom) {
           this.dateFrom = dateFrom;
           
           // Convert date from 01/01/2011 >>>>> 20110101
           if(!dateFrom.equals("")){
               this.dateFromC = dateFrom.substring(6)+dateFrom.substring(3,5)+dateFrom.substring(0,2);
           }else{
               this.dateFromC = "";
           }
           
       }

       public String getDateFrom() {
           return dateFrom;
       }

       public void setDateTo(String dateTo) {
           this.dateTo = dateTo;
           
           // Convert date from 01/01/2011 >>>>> 20110101
           if(!dateTo.equals("")){
               this.dateToC = dateTo.substring(6)+dateTo.substring(3,5)+dateTo.substring(0,2);
           }else{
               this.dateToC = "";
           }
           
       }

       public String getDateTo() {
           return dateTo;
       }

      

       public String getCreateOffice() {
           return createOffice;
       }

       public void setPrint(String print) {
           this.print = print;
       }

       public String getPrint() {
           return print;
       }

       public void setShipStatus(String shipStatus) {
           this.shipStatus = shipStatus;
       }

       public String getShipStatus() {
           return shipStatus;
       }

       public void setThirdLocation(String thirdLocation) {
           this.thirdLocation = thirdLocation;
       }

       public String getThirdLocation() {
           return thirdLocation;
       }

    
       public void setIncludeCharge(String includeCharge) {
           this.includeCharge = includeCharge;
       }

       public String getIncludeCharge() {
       
           if (this.includeCharge.equalsIgnoreCase("true")){
               return "T";
           }else{
               return "F";         
           }

       }

       public void setPrintBL(String printBL) {
           this.printBL = printBL;
       }

       public String getPrintBL() {
           return printBL;
       }
       
        public void setCreateOffice(String createOffice) {
            this.createOffice = createOffice.toUpperCase();
           
        }


    public void setEshippingInstructionPrintDao(EshippingInstructionPrintDao eshippingInstructionPrintDao) {
        this.eshippingInstructionPrintDao = eshippingInstructionPrintDao;
    }

    public EshippingInstructionPrintDao getEshippingInstructionPrintDao() {
        return eshippingInstructionPrintDao;
    }


    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLineCodeOfUser(String lineCodeOfUser) {
        this.lineCodeOfUser = lineCodeOfUser;
    }

    public String getLineCodeOfUser() {
        return lineCodeOfUser;
    }

    public void setRegionCodeOfUser(String regionCodeOfUser) {
        this.regionCodeOfUser = regionCodeOfUser;
    }

    public String getRegionCodeOfUser() {
        return regionCodeOfUser;
    }

    public void setAgentCodeOfUser(String agentCodeOfUser) {
        this.agentCodeOfUser = agentCodeOfUser;
    }

    public String getAgentCodeOfUser() {
        return agentCodeOfUser;
    }

    public void setFscCodeOfUser(String fscCodeOfUser) {
        this.fscCodeOfUser = fscCodeOfUser;
    }

    public String getFscCodeOfUser() {
        return fscCodeOfUser;
    }

    public void setPrsnLogIdOfUser(String prsnLogIdOfUser) {
        this.prsnLogIdOfUser = prsnLogIdOfUser;
    }

    public String getPrsnLogIdOfUser() {
        return prsnLogIdOfUser;
    }

    public void setFscFromLogin(String fscFromLogin) {
        this.fscFromLogin = fscFromLogin;
    }

    public String getFscFromLogin() {
        return fscFromLogin;
    }

    public void setNoOfResultRec(int noOfResultRec) {
        this.noOfResultRec = noOfResultRec;
    }

    public int getNoOfResultRec() {
        return noOfResultRec;
    }

    public void setRutPageVersion(int rutPageVersion) {
        this.rutPageVersion = rutPageVersion;
    }

    public int getRutPageVersion() {
        return rutPageVersion;
    }

    public void setIsControlFsc(boolean isControlFsc) {
        this.isControlFsc = isControlFsc;
    }

    public boolean isIsControlFsc() {
        return isControlFsc;
    }


    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }
}

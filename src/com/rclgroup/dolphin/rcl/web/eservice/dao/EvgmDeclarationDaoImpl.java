package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;

import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.common.FormatUtil;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationDetailMod;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationHeaderMod;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvgmDeclarationDaoImpl  extends AncestorJdbcDao implements EvgmDeclarationDao{
  
    protected void initDao() throws Exception {
        super.initDao();
//        insertStoreProcedure = new InsertStoreProcedure(getJdbcTemplate());
    }
    
 public String submitEnotice(String bookingId,String userId){
     System.out.println("[EvgmDeclarationDaoImpl][submitEnotice][Begin]");

     Map                    resultMap                = null;
     JdbcStoredProcedure    storedProcedure          = null;
     String                 error             = null;
     
     try{
         
         String[][]   array          = {
                                         { P_I_V.BOOKING_NO      , BLANK+ORACLE_VARCHAR  , PARAM_IN, bookingId },
                                         { P_I_V.USER_ID      , BLANK+ORACLE_VARCHAR  , PARAM_IN, userId },
                                         { P_O_V.ERROR       , BLANK+ORACLE_VARCHAR  , PARAM_OUT, BLANK }
                                       };
         storedProcedure = getStoreProcedure( PCR_ESV_VGM.PRR_VGM_SUBMISSION_ENOTICE
                                             , null
                                             , array
                                            );
                                            
         if(storedProcedure != null){
              resultMap = storedProcedure.execute();
              if(resultMap != null && !resultMap.isEmpty()){
                  error     = FormatUtil.nullToBlank( (String) resultMap.get(P_O_V.ERROR));
              }
         }
         
 //            System.out.println("companyName >>>>>>>>>>>>>>>> "+companyName);
     }catch(Exception e){
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][submitEnotice][End]");
     }
     return error;
 }    

    
 public String getOrgType(String userId){
     System.out.println("[EvgmDeclarationDaoImpl][getOrgType][Begin]");

     Map                    resultMap                = null;
     JdbcStoredProcedure    storedProcedure          = null;
     String                 orgType             = null;
     
     try{
         
         String[][]   array          = {
                                         { P_O_V.ORG_TYPE      , BLANK+ORACLE_VARCHAR  , PARAM_OUT, BLANK },
                                         { P_I_V.USER_ID       , BLANK+ORACLE_VARCHAR  , PARAM_IN, userId }
                                       };
         storedProcedure = getStoreProcedure( PCR_ESV_VGM.PRR_VGM_GET_ORG_TYPE
                                             , null
                                             , array
                                            );
                                            
         if(storedProcedure != null){
              resultMap = storedProcedure.execute();
              if(resultMap != null && !resultMap.isEmpty()){
                  orgType     = (String) resultMap.get(P_O_V.ORG_TYPE);
              }
         }
         
 //            System.out.println("companyName >>>>>>>>>>>>>>>> "+companyName);
     }catch(Exception e){
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][getOrgType][End]");
     }
     return orgType;
 }
    
    
 public boolean checkContainer(String container){
     System.out.println("[EvgmDeclarationDaoImpl][checkContainer][Begin]");
     
     Map                     resultMap                       = null;
     JdbcStoredProcedure     storeProcedure                  = null;
     String[][]              arrParams                       = null;
     String resultMsg = "";
     boolean result = false;
     try{
         arrParams = new String[][]{
                                     { P_I_V.EQUIPMENT_NO              , BLANK + ORACLE_VARCHAR, PARAM_IN  , container},
                                     { P_O_V.MSG              , BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK  }
                                    };
         storeProcedure = getStoreProcedure(PCR_ESV_SI_MAIN.PRR_ESI_CHECK_EXIST_CNTR, null, arrParams);
         if(storeProcedure != null){
             resultMap = storeProcedure.execute();
             if(resultMap != null && !resultMap.isEmpty()){
                 resultMsg = (String) resultMap.get(P_O_V.MSG);
//                 System.out.println("resultMsg "+resultMsg);
             }
             
         }
         if(resultMsg.trim().equals("")){
             result = true;
         }
//         System.out.println("result :"+result);
     }catch(Exception e){
         resultMsg = "";
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][checkContainer][End]");
     }
     return result;
 }
 public boolean deleteContainer(String dtlSeq , String hdrSeq,String containerNo){
     System.out.println("[EvgmDeclarationDaoImpl][deleteContainer][Begin]");

     Map                    resultMap                = null;
     JdbcStoredProcedure    storedProcedure          = null;
     String                 companyName             = null;
     boolean result = false;
     try{
         
         String[][]   array          = { 
                                         { P_I_V.HDR_SEQ      , BLANK+ORACLE_VARCHAR  , PARAM_IN, hdrSeq },
                                         { P_I_V.DTL_SEQ      , BLANK+ORACLE_VARCHAR  , PARAM_IN, dtlSeq },
                                         { P_I_V.EQUIPMENT_NO       , BLANK+ORACLE_VARCHAR  , PARAM_IN, containerNo }
                                       };
         storedProcedure = getStoreProcedure( PCR_ESV_VGM.PRR_VGM_DEL_DTL
                                             , null
                                             , array
                                            );
                                            
         if(storedProcedure != null){
              resultMap = storedProcedure.execute();
              if(resultMap != null && !resultMap.isEmpty()){
                  if(resultMap.size() > 0){
                      result = true;
                  }
              }
         }
         
 //            System.out.println("companyName >>>>>>>>>>>>>>>> "+companyName);
     }catch(Exception e){
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][deleteContainer][End]");
     }
     return result;
 }
 
 public Map checkExcelBookingAvailable(String booking,String userId){
     System.out.println("[EvgmDeclarationDaoImpl][checkExcelBookingAvailable][Begin]");
     Map                     resultMap                       = null;
     JdbcStoredProcedure     storeProcedure                  = null;
     String[][]              arrParams                       = null;
     Map                     result                       = null;
     String msg = "";
     try{
         arrParams = new String[][]{
                                     { P_O_V.MSG              , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK },
                                     { P_I_V.BOOKING_NO     , BLANK + ORACLE_VARCHAR, PARAM_IN  , booking},
                                     { P_I_V.USER_ID     , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId}
                                    };
                                    
                                    
         storeProcedure = getStoreProcedure(PCR_ESV_VGM.PRR_VGM_CHECK_BOOKING, null, arrParams);
         if(storeProcedure != null){
             resultMap = storeProcedure.execute();
             if(resultMap != null && !resultMap.isEmpty()){
                 result = new HashMap();
                 msg = (String) resultMap.get(P_O_V.MSG);
//                 System.out.println("msg "+ FormatUtil.nullToBlank(msg));
                 result.put(MSG_ERROR,FormatUtil.nullToBlank(msg));
             }
             
         }
     }catch(Exception e){
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][checkExcelBookingAvailable][End]");
     }
     return result;
 }
    
 public Map checkBookingAvailable(String booking,String userId){
     System.out.println("[EvgmDeclarationDaoImpl][checkBookingAvailable][Begin]");
     Map                     resultMap                       = null;
     JdbcStoredProcedure     storeProcedure                  = null;
     String[][]              arrParams                       = null;
     Map                     result                       = null;
     try{
         arrParams = new String[][]{
                                     { P_O_V.MSG              , BLANK + ORACLE_VARCHAR, PARAM_OUT , BLANK },
                                     { P_O_V.RESULT_HDR              , BLANK + ORACLE_CURSOR, PARAM_OUT , BLANK },
                                     { P_I_V.BOOKING_NO     , BLANK + ORACLE_VARCHAR, PARAM_IN  , booking},
                                     { P_I_V.USER_ID     , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId}
                                    };
                                    
                                    
         storeProcedure = getStoreProcedure(PCR_ESV_VGM.PRR_VGM_FIND_BOOKING, new VgmHeaderRowMapper(), arrParams);
         if(storeProcedure != null){
             resultMap = storeProcedure.execute();
             if(resultMap != null && !resultMap.isEmpty()){
                 result = new HashMap();
                 result.put(MSG_ERROR,FormatUtil.nullToBlank((String) resultMap.get(P_O_V.MSG)));
                 result.put(RESULT,(List) resultMap.get(P_O_V.RESULT_HDR));
             }
             
         }
     }catch(Exception e){
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][checkBookingAvailable][End]");
     }
     return result;
 }
 
    public String updateVGMDtl(EvgmDeclarationDetailMod mod,String userId,String hdrSeq){
        System.out.println("[EvgmDeclarationDaoImpl][updateVGMDtl][Begin]");
        
        Map                     resultMap                       = null;
        JdbcStoredProcedure     storeProcedure                  = null;
        String[][]              arrParams                       = null;
        String resultMsg = "";
        try{
            arrParams = new String[][]{
                                        { P_I_V.HDR_SEQ              , BLANK + ORACLE_VARCHAR, PARAM_IN  , hdrSeq},
                                        { P_I_V.DTL_SEQ              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getDtlSeq()},
                                        { P_I_V.USER_ID              , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId},
                                        { P_I_V.METHOD              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getWeightMethod()},
                                        { P_I_V.VGM              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getVerGrossMass().replaceAll(",","").equals("")?null:mod.getVerGrossMass().replaceAll(",","")},
                                        { P_I_V.GROSS_CARGO_WEIGHT              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getGrossCargo().replaceAll(",","").equals("")?null:mod.getGrossCargo().replaceAll(",","")},
                                        { P_I_V.TARE_WEIGHT              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getTareWeight().replaceAll(",","").equals("")?null:mod.getTareWeight().replaceAll(",","") },
                                        { P_I_V.EQUIPMENT_NO     , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getContainer()}
                                       };
            storeProcedure = getStoreProcedure(PCR_ESV_VGM.PRR_VGM_UPD_DTL, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    resultMsg = "";
                }
                
            }
        }catch(Exception e){
            resultMsg = e.getMessage();
            e.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationDaoImpl][updateVGMDtl][End]");
        }
        return resultMsg;
    }
    
 public String insertVGMDtl(EvgmDeclarationDetailMod mod,String userId,String hdrSeq){
     System.out.println("[EvgmDeclarationDaoImpl][insertVGMDtl][Begin]");
     
     Map                     resultMap                       = null;
     JdbcStoredProcedure     storeProcedure                  = null;
     String[][]              arrParams                       = null;
     String resultMsg = "";
     try{
         arrParams = new String[][]{
                                     { P_I_V.HDR_SEQ              , BLANK + ORACLE_VARCHAR, PARAM_IN  , hdrSeq},
                                     { P_I_V.EQUIPMENT_NO              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getContainer()},
                                     { P_I_V.METHOD              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getWeightMethod()},
                                     { P_I_V.VGM              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getVerGrossMass().replaceAll(",","").equals("")?null:mod.getVerGrossMass().replaceAll(",","")},
                                     { P_I_V.GROSS_CARGO_WEIGHT              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getGrossCargo().replaceAll(",","").equals("")?null:mod.getGrossCargo().replaceAll(",","")},
                                     { P_I_V.TARE_WEIGHT              , BLANK + ORACLE_VARCHAR, PARAM_IN  , mod.getTareWeight().replaceAll(",","").equals("")?null:mod.getTareWeight().replaceAll(",","")},
                                     { P_I_V.USER_ID     , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId}
                                    };
         storeProcedure = getStoreProcedure(PCR_ESV_VGM.PRR_VGM_INSERT_DTL, null, arrParams);
         if(storeProcedure != null){
             resultMap = storeProcedure.execute();
             if(resultMap != null && !resultMap.isEmpty()){
                 resultMsg = "";
             }
             
         }
     }catch(Exception e){
         resultMsg = e.getMessage();
         e.printStackTrace();
     }finally{
         System.out.println("[EvgmDeclarationDaoImpl][insertVGMDtl][End]");
     }
     return resultMsg;
 }
 
    public String insertVGMHdr(String booking,String shipperName,String repName,String authPerson,String userId){
        System.out.println("[EvgmDeclarationDaoImpl][insertVGMHdr][Begin]");
        
        Map                     resultMap                       = null;
        JdbcStoredProcedure     storeProcedure                  = null;
        String[][]              arrParams                       = null;
        String resultMsg = "";
        try{
            arrParams = new String[][]{{ P_O_V.HDR_SEQ              , BLANK + ORACLE_VARCHAR, PARAM_OUT, BLANK  },
                                        { P_I_V.BOOKING_NO              , BLANK + ORACLE_VARCHAR, PARAM_IN  , booking},
                                        { P_I_V.SHIPPER_NAME              , BLANK + ORACLE_VARCHAR, PARAM_IN  , shipperName},
                                        { P_I_V.REP_NAME              , BLANK + ORACLE_VARCHAR, PARAM_IN  , repName},
                                        { P_I_V.AUTHORIZE_PERSON              , BLANK + ORACLE_VARCHAR, PARAM_IN  , authPerson},
                                        { P_I_V.USER_ID     , BLANK + ORACLE_VARCHAR, PARAM_IN  , userId}
                                       };
            storeProcedure = getStoreProcedure(PCR_ESV_VGM.PRR_VGM_INSERT_HDR, null, arrParams);
            if(storeProcedure != null){
                resultMap = storeProcedure.execute();
                if(resultMap != null && !resultMap.isEmpty()){
                    resultMsg = (String) resultMap.get(P_O_V.HDR_SEQ);
                }
                
            }
        }catch(Exception e){
            resultMsg = "";
            e.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationDaoImpl][insertVGMHdr][End]");
        }
        return resultMsg;
    }
    
    public List getContainerList(String userId,String bookingNo,String userFsc){
         System.out.println("[EvgmDeclarationDaoImpl][getContainerList][Begin]");
        
         Map                    resultMap                = null;
         JdbcStoredProcedure    storedProcedure          = null;   
        List result = new ArrayList(); 
         try{
             
             String[][]   array          = {
                                             { P_O_V.RESULT      , BLANK+ORACLE_CURSOR  , PARAM_OUT, BLANK },
                                             { P_I_V.BOOKING_NO      , BLANK+ORACLE_VARCHAR  , PARAM_IN, bookingNo },
                                             { P_I_V.USER_ID       , BLANK+ORACLE_VARCHAR  , PARAM_IN, userId },
                                             { P_I_V.USER_FSC      , BLANK+ORACLE_VARCHAR  , PARAM_IN, userFsc }
                                           };
             storedProcedure = getStoreProcedure( PCR_ESV_VGM.PRR_VGM_GET_CONTAINER
                                                 , new VgmDetailRowMapper()
                                                 , array
                                                );
              
             if(storedProcedure != null){
                  resultMap = storedProcedure.execute();
                  if(resultMap != null && !resultMap.isEmpty()){
                      result     = (List) resultMap.get(P_O_V.RESULT);
                  }
             }
             
//             System.out.println("result >>>>>>>>>>>>>>>> "+result);
             
//             resultMap.put(CONTAINER_LIST,result);
         }catch(Exception e){
             e.printStackTrace();
         }finally{
             System.out.println("[EvgmDeclarationDaoImpl][getContainerList][End]");
         }
         return result;
    }
    
    public String getCompanyName(String userId){
        System.out.println("[EvgmDeclarationDaoImpl][getCompanyName][Begin]");

        Map                    resultMap                = null;
        JdbcStoredProcedure    storedProcedure          = null;
        String                 companyName             = null;
        
        try{
            
            String[][]   array          = {
                                            { P_O_V.COMPANY_NAME      , BLANK+ORACLE_VARCHAR  , PARAM_OUT, BLANK },
                                            { P_I_V.USER_ID       , BLANK+ORACLE_VARCHAR  , PARAM_IN, userId }
                                          };
            storedProcedure = getStoreProcedure( PCR_ESV_VGM.PRR_VGM_GET_COM_NAME
                                                , null
                                                , array
                                               );
                                               
            if(storedProcedure != null){
                 resultMap = storedProcedure.execute();
                 if(resultMap != null && !resultMap.isEmpty()){
                     companyName     = (String) resultMap.get(P_O_V.COMPANY_NAME);
                 }
            }
            
//            System.out.println("companyName >>>>>>>>>>>>>>>> "+companyName);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EvgmDeclarationDaoImpl][getCompanyName][End]");
        }
        return companyName;
    }
    
    private JdbcStoredProcedure getStoreProcedure(String procName, JdbcRowMapper rowMapper, String[][] arrParam){
        JdbcStoredProcedure storeProcedure = null;
        try{
            if(rowMapper!=null){
                if(arrParam!=null){
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper, arrParam);
                } else {
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, rowMapper);
                }
            } else {
                if(arrParam!=null){
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName, arrParam);
                } else {
                    storeProcedure = new JdbcStoredProcedure(getDataSource(), procName);
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return storeProcedure;
    }
    
 class VgmDetailRowMapper extends JdbcRowMapper{

     public Object mapRow(ResultSet rs, int row) throws SQLException{
         EvgmDeclarationDetailMod        mod             = new EvgmDeclarationDetailMod();
         
//         mod.setContainer(FormatUtil.nullToBlank(rs.getString("FK_BOOKING_NO")));
         mod.setVesselVoy(FormatUtil.nullToBlank(rs.getString("VSL_VOY")));
         mod.setContainer(FormatUtil.nullToBlank(rs.getString("FK_EQUIPMENT_NO")));
         mod.setWeightMethod(FormatUtil.nullToBlank(rs.getString("VGM_METHOD")));
         
         String verGross = FormatUtil.nullToBlank(rs.getString("VGM"));
         String grossCargo = FormatUtil.nullToBlank(rs.getString("GROSS_CARGO_WEIGHT"));
         String tareWeight = FormatUtil.nullToBlank(rs.getString("TARE_WEIGHT"));
         
         String status = FormatUtil.nullToBlank(rs.getString("SUBMIT_STATUS"));
         
         if(!status.equals("")){
             mod.setVgmStatus(status.substring(0,1));
             mod.setVgmStatusDesc(status.substring(2));
         }else{
             mod.setVgmStatus("");
             mod.setVgmStatusDesc("");
         }
            
         mod.setVerGrossMass(FormatUtil.getDecimalFormat(verGross,"#,###.##"));
         mod.setGrossCargo(FormatUtil.getDecimalFormat(grossCargo,"#,###.##"));
         mod.setTareWeight(FormatUtil.getDecimalFormat(tareWeight,"#,###.##"));
         
         mod.setRecordStatus(FormatUtil.nullToBlank(rs.getString("RECORD_STATUS")));
         mod.setSubmitDate(FormatUtil.nullToBlank(rs.getString("SUBMISSION_DATE")));
         
         mod.setDtlSeq(FormatUtil.nullToBlank(rs.getString("CNTR_SEQ")));

//         uim.setTemperature(rs.getString("REEFER_FROM"));
//         uim.setVentilation(rs.getString("VENTILATION"));
//         uim.setRemark(rs.getString("REEFER_REMARKS"));
//         uim.setHumidity(rs.getString("HUMIDITY"));
//         uim.setControlledAtmosphere(rs.getString("CONTROLLED_ATM"));
//         uim.setNitrogen(rs.getString("NITROGEN"));
//         uim.setOxygent(rs.getString("OXYGEN"));
//         uim.setCo2(rs.getString("CO2"));
//         uim.setRefMode(rs.getString("RFR_MODE"));
//         uim.setPreCooled(rs.getString("PRE_COOLED"));

         return mod;
     }
 }
 
 class VgmHeaderRowMapper extends JdbcRowMapper{

        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EvgmDeclarationHeaderMod        mod             = new EvgmDeclarationHeaderMod();
            
    //         mod.setContainer(FormatUtil.nullToBlank(rs.getString("FK_BOOKING_NO")));
            
            mod.setHdrSeq(FormatUtil.nullToBlank(rs.getString("PK_SEQ")));
            mod.setBookingNo(FormatUtil.nullToBlank(rs.getString("BOOKING_NO")));
//            mod.setVessel(FormatUtil.nullToBlank(rs.getString("VGM_METHOD")));
//            mod.setVoyage(FormatUtil.nullToBlank(rs.getString("VGM_METHOD")));
            mod.setVesselVoy(FormatUtil.nullToBlank(rs.getString("VSL_VOY")));
            mod.setShipperName(FormatUtil.nullToBlank(rs.getString("SHIPPER_NAME")));
            mod.setRespresentName(FormatUtil.nullToBlank(rs.getString("REP_NAME")));
            mod.setAuthName(FormatUtil.nullToBlank(rs.getString("AUTHORIZE_PERSON")));
            mod.setSubmissionDate(FormatUtil.nullToBlank(rs.getString("SUBMISSION_DATE")));
            

            return mod;
        }
    }
    
}

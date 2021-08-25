package com.rclgroup.dolphin.rcl.web.common;

import com.niit.control.common.ComboVO;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComboBoxESVUtil extends ComboBoxUtil implements ComboBoxESVConstants{
    public ComboBoxESVUtil(){
    }
//==============================================================================
// ESV DROPDOWNLIST
//==============================================================================
    public static List<ComboVO> getESVComboBox(Map mapParams, Object objDao, String comboBoxType) throws Exception {         
         List<ComboVO> list = null;
         List<ComboVO> listDao = null;
         
         Map mapResult = null;
         try{ 
            list = getBlankComboList();
            
            if(objDao != null){
                if(COMBO_BOX_TYPE.COUNTRY.equals(comboBoxType)){
                    mapResult = ((EserviceRegistrationDao) objDao).getCountryList();
                    if(mapResult != null){
                        listDao = (List<ComboVO>) mapResult.get(EserviceRegistrationDao.P_O_V.COUNTRY_DATA);
                        if(listDao != null && !listDao.isEmpty()){
                            list.addAll(listDao);
                        }
                    }
                }
            }
         }catch(Exception ex){
            ex.printStackTrace();
            throw ex;
         }
         return list;
    }
     /**
      * 
      * This method for combobox column(criteria search) in customer popoup.
      * 
      * @return List of combobox column(criteria search) in customer popoup
      */ 
     public static List<ComboVO> getCustomerColumnDDList(){
         List<ComboVO> list = null;
         
         Object[] comboBoxEnum = null;
         
         String code = null;
         String value = null;
         try{
             list = getBlankComboList();
             
              comboBoxEnum = CUSTOMER.class.getEnumConstants();
              if(comboBoxEnum != null){
                  for(Object object: comboBoxEnum){
                      code = ((CUSTOMER) object).getCode();
                      value = ((CUSTOMER) object).getValue();
                  
                      list.add(new ComboVO(code, value));
                  }
              }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return list;
     }  
    /**
     * 
     * This method for combobox column(criteria search) in screen.
     * 
     * @return List of combobox column(criteria search) in screen
     */ 
    public static List<ComboVO> getCustomerTypeColumnDDList(){
        List<ComboVO> list = null;
        
        Object[] comboBoxEnum = null;
        
        String code = null;
        String value = null;
        try{
            list = getBlankComboList();
            
             comboBoxEnum = CUSTOMER_TYPE.class.getEnumConstants();
             if(comboBoxEnum != null){
                 for(Object object: comboBoxEnum){
                     code = ((CUSTOMER_TYPE) object).getCode();
                     value = ((CUSTOMER_TYPE) object).getValue();
                 
                     list.add(new ComboVO(code, value));
                 }
             }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
     public static List<ComboVO> getPolPodDDList(){
         List<ComboVO> list = null;
         
         Object[] comboBoxEnum = null;
         
         String code = null;
         String value = null;
         try{
             list = new ArrayList<ComboVO>();
             
              comboBoxEnum = POL_POD.class.getEnumConstants();
              if(comboBoxEnum != null){
                  for(Object object: comboBoxEnum){
                      code = ((POL_POD) object).getCode();
                      value = ((POL_POD) object).getValue();
                  
                      list.add(new ComboVO(code, value));
                  }
              }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return list;
     }
     
     public static List<ComboVO> getPolPodStatusDDList(){
         List<ComboVO> list = null;
         
         Object[] comboBoxEnum = null;
         
         String code = null;
         String value = null;
         try{
             list = new ArrayList<ComboVO>();
             
              comboBoxEnum = POL_POD_STATUS.class.getEnumConstants();
              if(comboBoxEnum != null){
                  for(Object object: comboBoxEnum){
                      code = ((POL_POD_STATUS) object).getCode();
                      value = ((POL_POD_STATUS) object).getValue();
                  
                      list.add(new ComboVO(code, value));
                  }
              }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return list;
     }
     
     public static List<ComboVO> getQuotationNoDDList(Map quotationMap) throws Exception {
         List<EserviceNewWebBookingMod> quotationNoList = null;
         List<ComboVO> quotationNOComboList = null;
         
         ComboVO comboV0 = null;
         
         String quotationExistStatus = null;
         String quotationNo = null;
         
         boolean hasQuotationList = false;
         try{
            quotationNOComboList = getBlankComboList();
         
             if(quotationMap != null && !quotationMap.isEmpty()){
                 if(quotationMap.containsKey(EserviceNewWebBookingDao.P_O_V.QTN_EXISTS)){
                    quotationExistStatus = (String) quotationMap.get(EserviceNewWebBookingDao.P_O_V.QTN_EXISTS);
                    System.out.println("P_O_V_QTN_EXISTS = "+quotationExistStatus);
//                    if(quotationExistStatus != null && "Y".equals(quotationExistStatus)){ //Comment By Pound P' Nim tell show qoutation list all flag
                        if(quotationExistStatus != null){
                        if(quotationMap.containsKey(EserviceNewWebBookingDao.P_O_V.QTN_DATA)){
                            quotationNoList = (ArrayList<EserviceNewWebBookingMod>) quotationMap.get(EserviceNewWebBookingDao.P_O_V.QTN_DATA);
                            if(quotationNoList != null && !quotationNoList.isEmpty()){
                                hasQuotationList = true;
                            }
                        }
                    }
                 }
             }
             
             if(hasQuotationList){
                 for(EserviceNewWebBookingMod mod: quotationNoList){
                    quotationNo = mod.getQuotationNo();
                    comboV0 = new ComboVO(quotationNo, quotationNo);
                    quotationNOComboList.add(comboV0);
                 }
             }
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return quotationNOComboList;
     }
    
    /**
     * 
     * This method for combobox column(criteria search) in screen.
     * 
     * @return List of combobox column(criteria search) in screen
     */ 
    public static List<ComboVO> getCommodityDDList(){
        List<ComboVO> list = null;
        
        Object[] comboBoxEnum = null;
        
        String code = null;
        String value = null;
        try{
            list = ComboBoxUtil.getBlankComboList();
            
             comboBoxEnum = COMMODITY.class.getEnumConstants();
             if(comboBoxEnum != null){
                 for(Object object: comboBoxEnum){
                     code = ((COMMODITY) object).getCode();
                     value = ((COMMODITY) object).getValue();
                 
                     list.add(new ComboVO(code, value));
                 }
             }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}

package com.rclgroup.dolphin.rcl.web.common;

import com.niit.control.common.ComboVO;

import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingCommodityPopupDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComboBoxESIUtil extends ComboBoxUtil implements ComboBoxESIConstants{
    public ComboBoxESIUtil(){
    }
//==============================================================================
// ESI DROPDOWNLIST
//==============================================================================
    public static List<ComboVO> getESIComboBox(Map mapParams, Object objDao, String comboBoxType) throws Exception {         
         List<ComboVO> list = null;
         List<ComboVO> listDao = null;
         
         Map mapResult = null;
         
         String bookingNo = null;
//         String blNo = null;
         String status = null;
         try{ 
            list = getBlankComboList();
            
            if(objDao != null){
                if(COMBO_BOX_TYPE.CONTAINER_TYPE.equals(comboBoxType)){   
                    if(mapParams != null && mapParams.containsKey(EshippingInstructionDao.P_I_V.BOOKING_NO)){
                        bookingNo = (String) mapParams.get(EshippingInstructionDao.P_I_V.BOOKING_NO);
                        if(bookingNo != null && mapParams.containsKey(EshippingInstructionDao.P_I_V.STATUS)){
                            status = (String) mapParams.get(EshippingInstructionDao.P_I_V.STATUS);
                            if(status != null){
                                mapResult = ((EshippingInstructionDao) objDao).getContainerTypes(mapParams);
                            }
                        }
                    }
                }else if(COMBO_BOX_TYPE.COMMODITY.equals(comboBoxType)){
                    mapResult = ((EshippingCommodityPopupDao) objDao).getComboCommodityGroup();
                }
                if(mapResult != null){
                    listDao = (List<ComboVO>) mapResult.get(EshippingInstructionDao.P_O_V.REF_CURSOR_DTL_DATA);
                    if(listDao != null && !listDao.isEmpty()){
                        list.addAll(listDao);
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
     * This method for combobox of BL type in screen.
     * 
     * @return List of BL type for combobox in screen
     */ 
    public static List<ComboVO> getBLTypeDDList() {
       List<ComboVO> list = null;
       
       Object[] comboBoxEnum = null;
       
       String code = null;
       String value = null;
       try{
            list = getBlankComboList();
           
            comboBoxEnum = BL_TYPE.class.getEnumConstants();
            if(comboBoxEnum != null){
                for(Object object: comboBoxEnum){
                    code = ((BL_TYPE) object).getCode();
                    value = ((BL_TYPE) object).getValue();
                
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
     * This method for combobox of laden M/T in screen.
     * 
     * @return List of laden M/T for combobox in screen
     */ 
    public static List<ComboVO> getLadenMtDDList(){
        List<ComboVO> list = null;
        
        Object[] comboBoxEnum = null;
        
        String code = null;
        String value = null;
        try{
            list = getBlankComboList();
            
             comboBoxEnum = LADEN.class.getEnumConstants();
             if(comboBoxEnum != null){
                 for(Object object: comboBoxEnum){
                     code = ((LADEN) object).getCode();
                     value = ((LADEN) object).getValue();
                 
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
    public static List<ComboVO> getBookingColumnDDList(){
        List<ComboVO> list = null;
        
        Object[] comboBoxEnum = null;
        
        String code = null;
        String value = null;
        try{
            list = getBlankComboList();
            
             comboBoxEnum = BOOKING.class.getEnumConstants();
             if(comboBoxEnum != null){
                 for(Object object: comboBoxEnum){
                     code = ((BOOKING) object).getCode();
                     value = ((BOOKING) object).getValue();
                 
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
      * This method for combobox ESI status(criteria search) in screen.
      * 
      * @return List of combobox ESI status(criteria search) in screen
      */ 
     public static List<ComboVO> getESIStatusDDList() {
         List<ComboVO> list = null;
         
         Object[] comboBoxEnum = null;
         
         String code = null;
         String value = null;
         try{
             list = getBlankComboList();
             
              comboBoxEnum = ESI_STATUS.class.getEnumConstants();
              if(comboBoxEnum != null){
                  for(Object object: comboBoxEnum){
                      code = ((ESI_STATUS) object).getCode();
                      value = ((ESI_STATUS) object).getValue();
                  
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
      * This method for combobox column(criteria search) in package kind popoup.
      * 
      * @return List of combobox column(criteria search) in package kind popoup
      */ 
     public static List<ComboVO> getPackageColumnDDList()
     {
         List<ComboVO> list = null;
         
         Object[] comboBoxEnum = null;
         
         String code = null;
         String value = null;
         try{
             list = getBlankComboList();
             
              comboBoxEnum = PACKAGE.class.getEnumConstants();
              if(comboBoxEnum != null){
                  for(Object object: comboBoxEnum){
                      code = ((PACKAGE) object).getCode();
                      value = ((PACKAGE) object).getValue();
                  
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
     
     public static List<ComboVO> getColumnDDList() {
         List<ComboVO> list = null;
         
         ComboVO comboVo = null;
         try{
             list = getBlankComboList();
             
             comboVo = new ComboVO("description", "Description"); 
             list.add(comboVo);
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

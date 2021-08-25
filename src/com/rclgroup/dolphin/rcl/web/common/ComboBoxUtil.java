package com.rclgroup.dolphin.rcl.web.common;

import com.niit.control.common.ComboVO;

import com.niit.control.common.GlobalConstants;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceRegistrationDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingCommodityPopupDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboBoxUtil implements ComboBoxConstants{
//    public static String DAO_BEAN_ID = "EshippingInstructionDao";
//    public static String DAO_BEAN_ID_COMMODITY = "EshippingCommodityPopupDao";
    
     public static List<ComboVO> getBlankComboList() {
         List<ComboVO> comboBoxList = null;
         try{
            comboBoxList = new ArrayList<ComboVO>();
            comboBoxList.add(new ComboVO(BLANK, SELECT_ONE));
         }catch(Exception ex){
             ex.printStackTrace();
         }
         return comboBoxList;
     }
    
    public static List<ComboVO> getDropDownListFromMap(Map map, String dropDownKey) throws Exception{
        List<ComboVO> dropDownList = null;
        try{
            if(map != null && !map.isEmpty()){
                if(map.containsKey(dropDownKey)){
                    dropDownList = (List<ComboVO>) map.get(dropDownKey);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(dropDownList == null){
                dropDownList = getBlankComboList();   
            }
        }
        return dropDownList;
    }
    
    public static boolean checkValueExistFormDropDownList(List dropDownList, String valueSearch) throws Exception{
        ComboVO comboVo = null;    
        
        boolean isValueExist = false;
        try{
            if(dropDownList != null && !dropDownList.isEmpty()){
                for(int countIndex=0, ddlSize=dropDownList.size(); countIndex<ddlSize; countIndex++ ){
                    comboVo = (ComboVO) dropDownList.get(countIndex);
                    if(comboVo.getCode().equals(valueSearch)){
                        isValueExist = true;
                        break;
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return isValueExist;
    }
    
    /**
     * 
     * This method for combobox order by(criteria search) in screen.
     * 
     * @return List of combobox order by(criteria search) in screen
     */ 
    public static List<ComboVO> getOrderByDDList()
    {
        List<ComboVO> list = null;
        
        Object[] comboBoxEnum = null;
        
        String code = null;
        String value = null;
        try{
             list = new ArrayList<ComboVO>();
            
             comboBoxEnum = ORDER_BY.class.getEnumConstants();
             if(comboBoxEnum != null){
                 for(Object object: comboBoxEnum){
                     code = ((ORDER_BY) object).getCode();
                     value = ((ORDER_BY) object).getValue();
                 
                     list.add(new ComboVO(code, value));
                 }
             }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}

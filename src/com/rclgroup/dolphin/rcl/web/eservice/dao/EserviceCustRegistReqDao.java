/* -----------------------------------------------------------------------------
System  : RCLEAPPS
Module  : Common
Prog ID : ESER008 - EserviceCommodityPopupDao.java
Name    : New Web Booking
Purpose : DAO Class for EserviceCommodityPopupDao Interface
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Vikas         24/04/2013      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;

/** 
 * Interface for DAO
 * @class EdlBulkUpdate
 * @author NTL) Vikas
 * @version v1.00 2013/04/26
 * @see
 */
public interface EserviceCustRegistReqDao {
    public static final String DAO_NAME = "EserviceCustRegistReqDao";    
    
    public static final String EXCEPTION = "EXCEPTION";

    public interface PCR_ESV_REGISTER{
        public String PACKAGE_NAME = "PCR_ESV_REGISTER";
        public String PRR_ESV_GET_CUST_REGIST_REQ = PACKAGE_NAME+".PRR_ESV_GET_CUST_REGIST_REQ";
    }
    
    public interface P_I_V{
        public String FSC = "P_I_V_FSC";
    }
    
    public interface P_O_V{
        public String LIST_CUST_REQ_DATA = "P_O_V_LIST_CUST_REQ_DATA";
        public String ERR_CD = "P_O_V_ERR_CD";
        public String ERR_DESC = "P_O_V_ERR_DESC";
    }

    public Map findCustRegistReq(String fscCode) throws BusinessException, DataAccessException;
}

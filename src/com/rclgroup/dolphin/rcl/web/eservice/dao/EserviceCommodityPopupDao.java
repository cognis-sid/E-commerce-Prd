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
public interface EserviceCommodityPopupDao {

    //----------------- constants declaration.
    public static final String KEY_CRITERIA_TEXT_FIND = "TEXT";
    public static final String KEY_CRITERIA_COLUMN = "COLUMN";
    public static final String KEY_CRITERIA_SORTBY = "SORTBY";
    public static final String KEY_CRITERIA_ORDER = "ORDER";
    public static final String KEY_CRITERIA_WILDCARD = "WILDCARD";
    public static final String KEY_DATA = "DATA";
    public static final String KEY_COLUMN_COMM_CODE = "COMMODITY_GROUP_CODE";


    //----------------- method declaration.
    public Map onLoad(Map amapParam) throws BusinessException, 
                                            DataAccessException;

    public Map getList(Map amap) throws BusinessException, DataAccessException;
}

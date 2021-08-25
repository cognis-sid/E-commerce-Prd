/* -----------------------------------------------------------------------------
System  : RCL-EZL
Module  : Common
Prog ID : ECM002 - EcmMasterLookupDao.java
Name    : Master Lookup
Purpose : DAO Interface for Common Lookup Popup Screen
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Ankit     15/01/2011      <Initial version>
----------------------------------------------------------------------------- */

package com.rclgroup.dolphin.ezl.web.ecm.dao;


import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;

/** 
 * Interface for DAO
 * @class EcmMasterlookupDao
 * @author NTL) Ankit
 * @version v1.00 15/01/2011
 * @see
 */
public interface EcmMasterLookupDao {

    /* Parameter Names of DAO to be passed to SQL(SP) */
    public static final String KEY_REF_RESULT_LIST = 
        "p_o_ref_MasterResultData";
    public static final String KEY_SCREEN_TITLE = "p_o_v_master_name";
    public static final String KEY_GRID_VIEW_TITLE = "p_o_v_list_name";
    public static final String KEY_FIND_IN_CD = "p_o_findin_field_cd";
    public static final String KEY_FIND_IN_DESC = "p_o_findin_field_desc";
    public static final String KEY_SORT_BY_CD = "p_o_sortby_field_cd";
    public static final String KEY_SORT_BY_DESC = "p_o_sortby_field_desc";
    public static final String KEY_NO_OF_COLUMN = "p_o_no_column";
    public static final String KEY_COLUMN_HEADER = "p_o_column_name";

    public static final String KEY_MASTER_ID = "p_i_v_master_cd";
    public static final String KEY_PRE_CRITERIA = "p_i_v_pre_criteria_val";
    public static final String KEY_ORDER_BY = "p_i_v_order_by";
    public static final String KEY_ASC_DESC = "p_i_v_asc_desc";


    /** getMasterConfig: Gets Result of Master Lookup
     * @param Map
     * @return Map
     * @throws BusinessException
     * @throws DataAccessException
     */
    public Map getMasterConfig(Map amapParam) throws BusinessException, 
                                                     DataAccessException;

    /** getResultList : get the list of records based on filter criteria
     * @param Map
     * @return Map
     * @throws BusinessException
     * @throws DataAccessException
     */
    public Map getResultList(Map amapParam) throws BusinessException, 
                                                   DataAccessException;
}

/* -----------------------------------------------------------------------------
System  : RCLEAPPS
Module  : Common
Prog ID : ESER008 - EservicePreviewUploadedDocDao.java
Name    : Web Booking - Preview uploaded document
Purpose : DAO Class for EservicePreviewUploadedDocDao Interface
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
Pratya         29/08/2014      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import org.springframework.dao.DataAccessException;

import com.niit.control.common.exception.BusinessException;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePreviewUploadedDocUim;

/** 
 * Interface for DAO
 * @class EdlBulkUpdate
 * @author NTL) Vikas
 * @version v1.00 2014/08/29
 * @see
 */
public interface EservicePreviewUploadedDocDao 
{

    public static final String KEY_MAPPER_CLASS                 = "KEY_MAPPER_CLASS";
    public static final String KEY_PROC_NAME                    = "KEY_PROC_NAME";
    public static final String KEY_PROC_PARAMS                  = "KEY_PROC_PARAMS";
    public static final String KEY_PROCE_EXCECTION_RESULT_MAP   = "KEY_PROCE_EXCECTION_RESULT_MAP";
    public static final String NEWLINE                          = "\n";


    public void setUploadListDetail(EservicePreviewUploadedDocUim form)  throws BusinessException, DataAccessException;

}

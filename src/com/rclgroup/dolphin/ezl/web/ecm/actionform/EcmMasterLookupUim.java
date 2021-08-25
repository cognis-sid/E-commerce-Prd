/* -----------------------------------------------------------------------------
System  : RCL-EZL
Module  : Common
Prog ID : ECM002 - EcmMasterLookupUim.java
Name    : Lookup Screen
Purpose : Form Bean for Lookup Screen
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
NTL)Ankit     15/01/2011      <Initial version>
--Change Log--------------------------------------------------------------------
##  DD/MM/YY    –User-  -Task/CR No-    -Short Description-
01  07/10/14    Pratya  @01             PD_CR_20140826_ESV [Contract Party for registeration]
----------------------------------------------------------------------------- */

package com.rclgroup.dolphin.ezl.web.ecm.actionform;

import com.niit.control.web.actionform.PaginationForm;

import com.rclgroup.dolphin.ezl.web.ecm.vo.EcmMasterLookupMod;

import java.util.ArrayList;
import java.util.List;


/**
 * Transfer Object for Master Lookup List Result
 * @class EcmMasterLookupUim
 * @author NTL) Ankit
 * @version v1.00 15/01/2011
 */
public class EcmMasterLookupUim extends PaginationForm {

    /* Start - Parameter Fields */
    private String prmMasterId      = null;
    private String prmFormName      = null;
    private String prmValues        = null;
    private String prmRowId         = null;
    /*Begin @01*/
    private String prmRowIndex      = null;
    /*End @01*/
    
    /* End - Parameter Fields */

    private String orderBy          = null;
    private String ascDesc          = null;

    /*Strat - Hidden parameters */
    private String screenTitle      = null;
    private String sectionTitle     = null;
    private String findInCode       = null;
    private String findInDesc       = null;
    private String sortByCode       = null;
    private String sortByDesc       = null;
    private String noOfColumn       = null;
    private String colNames         = null;
    private String preCriteria      = null;
    /* End - Hidden Parameters */

    private List   columnHeader     = new ArrayList();


    /*
     * This List will hold the array of Transfer objects(VO).
     * Used by JSP in <logic:iterate> tag of Search Result
     */
    private List marlTableData_1 = new ArrayList();


    /**  
     * This is the getter for table data
     * @return marlTableData List - Table Data value
     */
    public List getValues() {
        return this.marlTableData_1;
    }

    /** 
     * This is the setter for table data 
     * @param aarlTableData List - Table Data value
     */
    public void setValues(List aarlTableData) {
        this.marlTableData_1 = aarlTableData;
    }

    /**
     * This function is called by the Struts to fetch a particular Transfer
     * object in the List. If not present, then a new Transfer object is created.
     * 
     * @param aintIndex int - Index value of Table Data
     * @return EcmMasterLookupMod DTO at given index
     */
    public EcmMasterLookupMod getValue(int aintIndex) {
        if (aintIndex > marlTableData_1.size() - 1) {
            for (int i = marlTableData_1.size(); i <= aintIndex; i++) {
                //Create blank dto
                EcmMasterLookupMod dtoData = new EcmMasterLookupMod();
                marlTableData_1.add(dtoData);
            } //for loop ends
        } //if ends
        return (EcmMasterLookupMod)marlTableData_1.get(aintIndex);
    }

    /**
     * This function is called by the Struts to fetch a Column Header
     * 
     * 
     * @param aintIndex int - Index value of Table Data
     * @return String value at given index
     */
    public String getColName(int aintIndex) {
        return (String)columnHeader.get(aintIndex);
    }

    /**This is parent class method, must over-write the value 
     * @param formName
     */
    public void setFormName(String formName) {
        super.setFormName("fecm002");
    }

    public void setPrmMasterId(String prmMasterId) {
        this.prmMasterId = prmMasterId;
    }

    public String getPrmMasterId() {
        return prmMasterId;
    }

    public void setPrmFormName(String prmFormName) {
        this.prmFormName = prmFormName;
    }

    public String getPrmFormName() {
        return prmFormName;
    }

    public void setPrmValues(String prmValues) {
        this.prmValues = prmValues;
    }

    public String getPrmValues() {
        return prmValues;
    }

    public void setScreenTitle(String screenTitle) {
        this.screenTitle = screenTitle;
    }

    public String getScreenTitle() {
        return screenTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setColumnHeader(List columnHeader) {
        this.columnHeader = columnHeader;
    }

    public List getColumnHeader() {
        return columnHeader;
    }

    public void setNoOfColumn(String noOfColumn) {
        this.noOfColumn = noOfColumn;
    }

    public String getNoOfColumn() {
        return noOfColumn;
    }

    public void resetFields() {
        /* call super class's reset fields */
        super.resetFields();

        /* reset field values of specific this form bean */
        screenTitle         = null;
        sectionTitle        = null;
        findInCode          = null;
        findInDesc          = null;
        sortByCode          = null;
        sortByDesc          = null;
        noOfColumn          = null;
        colNames            = null;
        preCriteria         = null;
        wildCard            = WILD_CARD_ALL;
        orderBy             = null;
        ascDesc             = null;
        /* reset table result list */
        marlTableData_1     = new ArrayList();
        
        /*Begin @01*/
        this.prmRowIndex    = "";
        /*End @01*/

    }

    public void setFindInCode(String findInCode) {
        this.findInCode = findInCode;
    }

    public String getFindInCode() {
        return findInCode;
    }

    public void setFindInDesc(String findInDesc) {
        this.findInDesc = findInDesc;
    }

    public String getFindInDesc() {
        return findInDesc;
    }

    public void setSortByCode(String sortByCode) {
        this.sortByCode = sortByCode;
    }

    public String getSortByCode() {
        return sortByCode;
    }

    public void setSortByDesc(String sortByDesc) {
        this.sortByDesc = sortByDesc;
    }

    public String getSortByDesc() {
        return sortByDesc;
    }

    public void setColNames(String colNames) {
        this.colNames = colNames;
    }

    public String getColNames() {
        return colNames;
    }

    public void setPreCriteria(String preCriteria) {
        this.preCriteria = preCriteria;
    }

    public String getPreCriteria() {
        return preCriteria;
    }

    public void setPrmRowId(String prmRowId) {
        this.prmRowId = prmRowId;
    }

    public String getPrmRowId() {
        return prmRowId;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc;
    }

    public String getAscDesc() {
        return ascDesc;
    }

    public void setPrmRowIndex(String prmRowIndex) {
        this.prmRowIndex = prmRowIndex;
    }

    public String getPrmRowIndex() {
        return prmRowIndex;
    }
} //end of class


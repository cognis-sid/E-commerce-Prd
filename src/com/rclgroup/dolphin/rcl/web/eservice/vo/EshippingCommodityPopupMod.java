/* -----------------------------------------------------------------------------
System  : RCLEAPPS
Module  : Common
Prog ID : ESER008 - EserviceCommodityPopupMod.java
Name    : New Web Booking
Purpose : DAO Class for EserviceNewWebBookingDao Interface
--------------------------------------------------------------------------------
History : None
--------------------------------------------------------------------------------
Author          Date            What
--------------- --------------- ------------------------------------------------
YOSSUN1         22/08/2013      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.vo;
import com.niit.control.common.BaseVO;

public class EshippingCommodityPopupMod extends BaseVO{
    private String BLANK = "";

    //---------------------------variable declaration
    private String commGrpDesc;
    private String commGrpCode;
    private String commDesc;
    private String commCode;
    private String commOfPackage;
    private String commPackageKindCode;
    private String commPackageKindName;
    private String commWeight;
    private String commMeasurement;
        
    //-----------------------------accessors declaration
    public EshippingCommodityPopupMod(){
            this.commGrpDesc = BLANK;
            this.commGrpCode = BLANK;
            this.commDesc = BLANK;
            this.commCode = BLANK;
            this.commOfPackage = "0";
            this.commPackageKindCode = BLANK;
            this.commPackageKindName = BLANK;
            this.commWeight = "0.000";
            this.commMeasurement = "0.0000";
    }

    public void setCommGrpDesc(String commGrpDesc) {
        this.commGrpDesc = commGrpDesc;
    }

    public String getCommGrpDesc() {
        return commGrpDesc;
    }

    public void setCommGrpCode(String commGrpCode) {
        this.commGrpCode = commGrpCode;
    }

    public String getCommGrpCode() {
        return commGrpCode;
    }

    public void setCommDesc(String commDesc) {
        this.commDesc = commDesc;
    }

    public String getCommDesc() {
        return commDesc;
    }

    public void setCommCode(String commCode) {
        this.commCode = commCode;
    }

    public String getCommCode() {
        return commCode;
    }

    public void setCommOfPackage(String commOfPackage){
        this.commOfPackage = commOfPackage;
    }

    public String getCommOfPackage(){
        return commOfPackage;
    }

    public void setCommPackageKindCode(String commPackageKindCode){
        this.commPackageKindCode = commPackageKindCode;
    }

    public String getCommPackageKindCode(){
        return commPackageKindCode;
    }

    public void setCommPackageKindName(String commPackageKindName){
        this.commPackageKindName = commPackageKindName;
    }

    public String getCommPackageKindName(){
        return commPackageKindName;
    }

    public void setCommWeight(String commWeight){
        this.commWeight = commWeight;
    }

    public String getCommWeight(){
        return commWeight;
    }

    public void setCommMeasurement(String commMeasurement){
        this.commMeasurement = commMeasurement;
    }

    public String getCommMeasurement(){
        return commMeasurement;
    }
}
/* * end of class * */

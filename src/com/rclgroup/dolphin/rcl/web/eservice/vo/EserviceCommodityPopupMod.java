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
NTL)Vikas         03/05/2013      <Initial version>
--Change Log--------------------------------------------------------------------
## DD/MM/YY –User- -Task/CR No- -Short Description-
----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.vo;
import com.niit.control.common.BaseVO;

public class EserviceCommodityPopupMod extends BaseVO{

    //---------------------------default constructor
    public EserviceCommodityPopupMod() {
    }

    //---------------------------variable declaration
    private String sosCoc;
    private String telephone;
    private String fax;
    private String email;
    private String date;
        
    //-----------------------------accessors declaration

    public void setSosCoc(String sosCoc) {
        this.sosCoc = sosCoc;
    }

    public String getSosCoc() {
        return sosCoc;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
/* * end of class * */

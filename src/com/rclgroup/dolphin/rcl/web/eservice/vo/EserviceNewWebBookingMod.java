 /* -----------------------------------------------------------------------------
 System  : RCLEAPPS
 Module  : Common
 Prog ID : ESER008 - EserviceNewWebBookingMod.java
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

 public class EserviceNewWebBookingMod extends BaseVO{

     //---------------------------default constructor
     public EserviceNewWebBookingMod() {
     }

     //---------------------------variable declaration
     private String sosCoc;
     private String telephone;
     private String fax;
     private String email;
     private String date;
     private String quotationNo;
     private String quotationDesc;
     
     private String toPicMail="";
     private String ccPicMail="";
     private String bccPicMail="";
     
     private String useName ;
         
     
     //-----------------------------accessors declaration

     
     public String getQuotationDesc() {
		return quotationDesc;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public void setQuotationDesc(String quotationDesc) {
		this.quotationDesc = quotationDesc;
	}

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

     public void setQuotationNo(String quotationNo) {
         this.quotationNo = quotationNo;
     }

     public String getQuotationNo() {
         return quotationNo;
     }

	public String getToPicMail() {
		return toPicMail;
	}

	public void setToPicMail(String toPicMail) {
		this.toPicMail = toPicMail;
	}

	public String getCcPicMail() {
		return ccPicMail;
	}

	public void setCcPicMail(String ccPicMail) {
		this.ccPicMail = ccPicMail;
	}

	public String getBccPicMail() {
		return bccPicMail;
	}

	public void setBccPicMail(String bccPicMail) {
		this.bccPicMail = bccPicMail;
	}
     
     
 }
 /* * end of class * */

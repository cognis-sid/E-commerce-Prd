package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class BlRevenueMod {

	
	private String ChargeCode;
	private String descreiptionCharegCode ;
	private String currency;
	private String	rate;
	private String basis;
	private String Amount;
	private String blNo;
	private String bookingNo;
	
	
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	public String getChargeCode() {
		return ChargeCode;
	}
	public void setChargeCode(String chargeCode) {
		ChargeCode = chargeCode;
	}
	public String getDescreiptionCharegCode() {
		return descreiptionCharegCode;
	}
	public void setDescreiptionCharegCode(String descreiptionCharegCode) {
		this.descreiptionCharegCode = descreiptionCharegCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getBasis() {
		return basis;
	}
	public void setBasis(String basis) {
		this.basis = basis;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "BlRevenueMod [ChargeCode=" + ChargeCode + ", descreiptionCharegCode=" + descreiptionCharegCode
				+ ", currency=" + currency + ", rate=" + rate + ", basis=" + basis + ", Amount=" + Amount + ", blNo="
				+ blNo + ", bookingNo=" + bookingNo + "]";
	}
	
	
}

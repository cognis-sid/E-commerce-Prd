package com.rclgroup.dolphin.rcl.web.eservice.actionform;

public class BookingConfirmationMail {

	private String bookingParty="";
	
	private String contarctParty="";
	
	private String Bookingno="";
	
	private String quotaionNo="";
	
	private String BookingDate="";
	
	private String shipmentTerm="";
	
	private String pol="";
	
	private String pod="";
	
	private String volume="";
	
	private String emptyPickupDate="";
	
	private String cargoAvailabilityDate="";
	
	private String desiredArrivalDate="";
	
	private String routingPreferrence="";
	
	private String cargoDescription="";
	
	private String specialInstruction ="";
	
	private String mailId="";
	
	private String name="";
	
	private String blNumber="";

	
	public String getBlNumber() {
		return blNumber;
	}

	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookingParty() {
		return bookingParty;
	}

	public void setBookingParty(String bookingParty) {
		this.bookingParty = bookingParty;
	}

	public String getContarctParty() {
		return contarctParty;
	}

	public void setContarctParty(String contarctParty) {
		this.contarctParty = contarctParty;
	}

	public String getBookingno() {
		return Bookingno;
	}

	public void setBookingno(String bookingno) {
		Bookingno = bookingno;
	}

	public String getQuotaionNo() {
		return quotaionNo;
	}

	public void setQuotaionNo(String quotaionNo) {
		this.quotaionNo = quotaionNo;
	}

	public String getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}

	public String getShipmentTerm() {
		return shipmentTerm;
	}

	public void setShipmentTerm(String shipmentTerm) {
		this.shipmentTerm = shipmentTerm;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getEmptyPickupDate() {
		return emptyPickupDate;
	}

	public void setEmptyPickupDate(String emptyPickupDate) {
		this.emptyPickupDate = emptyPickupDate;
	}

	public String getCargoAvailabilityDate() {
		return cargoAvailabilityDate;
	}

	public void setCargoAvailabilityDate(String cargoAvailabilityDate) {
		this.cargoAvailabilityDate = cargoAvailabilityDate;
	}

	public String getDesiredArrivalDate() {
		return desiredArrivalDate;
	}

	public void setDesiredArrivalDate(String desiredArrivalDate) {
		this.desiredArrivalDate = desiredArrivalDate;
	}

	public String getRoutingPreferrence() {
		return routingPreferrence;
	}

	public void setRoutingPreferrence(String routingPreferrence) {
		this.routingPreferrence = routingPreferrence;
	}

	public String getCargoDescription() {
		return cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "BookingConfirmationMail [bookingParty=" + bookingParty + ", contarctParty=" + contarctParty
				+ ", Bookingno=" + Bookingno + ", quotaionNo=" + quotaionNo + ", BookingDate=" + BookingDate
				+ ", shipmentTerm=" + shipmentTerm + ", pol=" + pol + ", pod=" + pod + ", volume=" + volume
				+ ", emptyPickupDate=" + emptyPickupDate + ", cargoAvailabilityDate=" + cargoAvailabilityDate
				+ ", desiredArrivalDate=" + desiredArrivalDate + ", routingPreferrence=" + routingPreferrence
				+ ", cargoDescription=" + cargoDescription + ", specialInstruction=" + specialInstruction + "]";
	}
	
}

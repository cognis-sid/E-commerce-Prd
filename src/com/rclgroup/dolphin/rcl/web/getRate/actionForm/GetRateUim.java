package com.rclgroup.dolphin.rcl.web.getRate.actionForm;

import java.util.List;

import com.niit.control.web.actionform.PaginationForm;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;

public class GetRateUim extends PaginationForm{

	private String actionType;
	private String payload;
	private String emaill;
	private String quotationNo;
	// this we will genrate
	private String quotationRef;
	private String pod;
	private String pol;
	private String shipmentTerm;
	private String cargoType;
	private String containerSize;
	private String expectedVolume;
	private String commodity;
	private String expectedLoadingPeriodFrom;

	private int containerSize20GP;
	private int containerSize40GP;
	private  int containerSize40HC;
	
	private String loadingFrom;
	private String loadingTo;
	private String usd20GP;
	private String usd40GP;
	private String usd40HC;
	
	private String portOfDeparture;
	private String portOfLoading;
	
	private String freeDays;
	
	private int numberOfContainer;
	
	private String currentDate;
	
	
	
	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public int getNumberOfContainer() {
		return numberOfContainer;
	}

	public void setNumberOfContainer(int numberOfContainer) {
		this.numberOfContainer = numberOfContainer;
	}

	private List<ContryMod> contryList;
	
	
	public List<ContryMod> getContryList() {
		return contryList;
	}

	public void setContryList(List<ContryMod> contryList) {
		this.contryList = contryList;
	}

	public String getQuotationRef() {
		return quotationRef;
	}

	public void setQuotationRef(String quotationRef) {
		this.quotationRef = quotationRef;
	}

	public String getLoadingFrom() {
		return loadingFrom;
	}

	public void setLoadingFrom(String loadingFrom) {
		this.loadingFrom = loadingFrom;
	}

	public String getLoadingTo() {
		return loadingTo;
	}

	public void setLoadingTo(String loadingTo) {
		this.loadingTo = loadingTo;
	}

	public String getFreeDays() {
		return freeDays;
	}

	public void setFreeDays(String freeDays) {
		this.freeDays = freeDays;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getEmaill() {
		return emaill;
	}

	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getShipmentTerm() {
		return shipmentTerm;
	}

	public void setShipmentTerm(String shipmentTerm) {
		this.shipmentTerm = shipmentTerm;
	}

	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	public String getContainerSize() {
		return containerSize;
	}

	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}

	public String getExpectedVolume() {
		return expectedVolume;
	}

	public void setExpectedVolume(String expectedVolume) {
		this.expectedVolume = expectedVolume;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getExpectedLoadingPeriodFrom() {
		return expectedLoadingPeriodFrom;
	}

	public void setExpectedLoadingPeriodFrom(String expectedLoadingPeriodFrom) {
		this.expectedLoadingPeriodFrom = expectedLoadingPeriodFrom;
	}

	public GetRateUim() {
		// TODO Auto-generated constructor stub
	}

	public GetRateUim(String pod, String pol, String shipmentTerm, String cargoType, String containerSize,
			String expectedVolume, String commodity, String expectedLoadingPeriodFrom) {
		super();
		this.pod = pod;
		this.pol = pol;
		this.shipmentTerm = shipmentTerm;
		this.cargoType = cargoType;
		this.containerSize = containerSize;
		this.expectedVolume = expectedVolume;
		this.commodity = commodity;
		this.expectedLoadingPeriodFrom = expectedLoadingPeriodFrom;
	}

	@Override
	public String toString() {
		return "GetRateUim [pod=" + pod + ", pol=" + pol + ", shipmentTerm=" + shipmentTerm + ", cargoType=" + cargoType
				+ ", containerSize=" + containerSize + ", expectedVolume=" + expectedVolume + ", commodity=" + commodity
				+ ", expectedLoadingPeriodFrom=" + expectedLoadingPeriodFrom + "]";
	}

	public int getContainerSize20GP() {
		return containerSize20GP;
	}

	public void setContainerSize20GP(int containerSize20GP) {
		this.containerSize20GP = containerSize20GP;
	}

	public int getContainerSize40GP() {
		return containerSize40GP;
	}

	public void setContainerSize40GP(int containerSize40GP) {
		this.containerSize40GP = containerSize40GP;
	}

	public int getContainerSize40HC() {
		return containerSize40HC;
	}

	public void setContainerSize40HC(int containerSize40HC) {
		this.containerSize40HC = containerSize40HC;
	}

	public String getUsd20GP() {
		return usd20GP;
	}

	public void setUsd20GP(String usd20gp) {
		usd20GP = usd20gp;
	}

	public String getUsd40GP() {
		return usd40GP;
	}

	public void setUsd40GP(String usd40gp) {
		usd40GP = usd40gp;
	}

	public String getUsd40HC() {
		return usd40HC;
	}

	public void setUsd40HC(String usd40hc) {
		usd40HC = usd40hc;
	}

	public String getPortOfDeparture() {
		return portOfDeparture;
	}

	public void setPortOfDeparture(String portOfDeparture) {
		this.portOfDeparture = portOfDeparture;
	}

	public String getPortOfLoading() {
		return portOfLoading;
	}

	public void setPortOfLoading(String portOfLoading) {
		this.portOfLoading = portOfLoading;
	}

 

}

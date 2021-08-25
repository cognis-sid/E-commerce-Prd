package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import java.util.ArrayList;
import java.util.List;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsNewMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsNewMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRoutingDetailsNewMod;

public class EserviceInquiryWebBookingNewUim extends EserviceNewWebBookingUim {
    
    private String sortByValue;
    
	private String orderValue;
	
	private String status;
    
    private String bookingType;
    
    private String mode;
    
    private Boolean notFound;
    
    private Integer firstCheckedCommodity;
    
    private List<EserviceRoutingDetailsNewMod> routingDetails;
    
    private List<EserviceEquipmentDetailsNewMod> equipmentDetails;
    
    private List<EserviceCommodityDetailsNewMod> commodityDetails;
    
    private List statusList;
    
    private List tableData = new ArrayList();
    
    
    public List getValues() {
        return this.tableData;
    }

    public void setValues(List aarlTableData) {
        this.tableData = aarlTableData;
    }
	public String getSortByValue() {
		return sortByValue;
	}
	public void setSortByValue(String sortByValue) {
		this.sortByValue = sortByValue;
	}
	public String getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBookingType() {
		return bookingType;
	}
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Boolean getNotFound() {
		return notFound;
	}
	public void setNotFound(Boolean notFound) {
		this.notFound = notFound;
	}
	public Integer getFirstCheckedCommodity() {
		return firstCheckedCommodity;
	}
	public void setFirstCheckedCommodity(Integer firstCheckedCommodity) {
		this.firstCheckedCommodity = firstCheckedCommodity;
	}
	public List<EserviceRoutingDetailsNewMod> getRoutingDetails() {
		return routingDetails;
	}
	public void setRoutingDetails(List<EserviceRoutingDetailsNewMod> routingDetails) {
		this.routingDetails = routingDetails;
	}
	public List<EserviceEquipmentDetailsNewMod> getEquipmentDetails() {
		return equipmentDetails;
	}
	public void setEquipmentDetails(List<EserviceEquipmentDetailsNewMod> equipmentDetails) {
		this.equipmentDetails = equipmentDetails;
	}
	public List<EserviceCommodityDetailsNewMod> getCommodityDetails() {
		return commodityDetails;
	}
	public void setCommodityDetails(List<EserviceCommodityDetailsNewMod> commodityDetails) {
		this.commodityDetails = commodityDetails;
	}
	public List getStatusList() {
		return statusList;
	}
	public void setStatusList(List statusList) {
		this.statusList = statusList;
	}
    
 }

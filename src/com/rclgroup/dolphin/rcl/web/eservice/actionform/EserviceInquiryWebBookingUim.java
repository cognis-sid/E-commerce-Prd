package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceInquiryCustomerDtlMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceRoutingDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.RoutingDtldsVo;

import java.util.List;

public class EserviceInquiryWebBookingUim extends EserviceNewWebBookingUim {
    
    private String status;
    private String bookingType;
    private String mode;
    private Boolean notFound;
    private Integer firstCheckedCommodity;
    private String sortByValue;
    private String port1="";
    private String port2="";
    private String port3="";
	private String orderValue;
    private List<EserviceRoutingDetailsMod> routingDetails;
    private List<EserviceEquipmentDetailsMod> equipmentDetails;
    private List<EserviceCommodityDetailsMod> commodityDetails;
    private EserviceInquiryCustomerDtlMod customerDtls;
    private List<RoutingDtldsVo> routingDtls;
    
    
    public List<RoutingDtldsVo> getRoutingDtls() {
		return routingDtls;
	}

	public void setRoutingDtls(List<RoutingDtldsVo> routingDtls) {
		this.routingDtls = routingDtls;
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

	public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
  
    public EserviceInquiryCustomerDtlMod getCustomerDtls() {
		return customerDtls;
	}

	public void setCustomerDtls(EserviceInquiryCustomerDtlMod customerDtls) {
		this.customerDtls = customerDtls;
	}

	public void setEquipmentDetails(List<EserviceEquipmentDetailsMod> equipmentDetails) {
        this.equipmentDetails = equipmentDetails;
    }

    public List<EserviceEquipmentDetailsMod> getEquipmentDetails() {
        return equipmentDetails;
    }

    public void setCommodityDetails(List<EserviceCommodityDetailsMod> commodityDetails) {
        this.commodityDetails = commodityDetails;
    }

    public List<EserviceCommodityDetailsMod> getCommodityDetails() {
        return commodityDetails;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setNotFound(Boolean notFound) {
        this.notFound = notFound;
    }

    public Boolean getNotFound() {
        return notFound;
    }

    public void setFirstCheckedCommodity(Integer firstCheckedCommodity) {
        this.firstCheckedCommodity = firstCheckedCommodity;
    }

    public Integer getFirstCheckedCommodity() {
        return firstCheckedCommodity;
    }

    public void setRoutingDetails(List<EserviceRoutingDetailsMod> routingDetails) {
        this.routingDetails = routingDetails;
    }

    public List<EserviceRoutingDetailsMod> getRoutingDetails() {
        return routingDetails;
    }

	public String getPort1() {
		return port1;
	}

	public void setPort1(String port1) {
		this.port1 = port1;
	}

	public String getPort2() {
		return port2;
	}

	public void setPort2(String port2) {
		this.port2 = port2;
	}

	public String getPort3() {
		return port3;
	}

	public void setPort3(String port3) {
		this.port3 = port3;
	}
    
    
}

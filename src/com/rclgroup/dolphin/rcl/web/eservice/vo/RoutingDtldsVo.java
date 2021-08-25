package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class RoutingDtldsVo {

	private String vesselName;
	private String vesselNo;
	private String voyage;
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getVesselNo() {
		return vesselNo;
	}
	public void setVesselNo(String vesselNo) {
		this.vesselNo = vesselNo;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	
	@Override
	public String toString() {
		return "RoutingDtldsVo [vesselName=" + vesselName + ", vesselNo=" + vesselNo + ", voyage=" + voyage + "]";
	}
	
}

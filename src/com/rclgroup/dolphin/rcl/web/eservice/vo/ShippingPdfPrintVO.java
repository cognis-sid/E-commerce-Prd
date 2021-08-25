package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class ShippingPdfPrintVO {
	private int rowSpan;
	private String item="";
	private String containerName="";
	private String noOfPackages="";
	private String description="";
	private String weight="";
	private String measurement="";
	
	
	public int getRowSpan() {
		return rowSpan;
	}
	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getNoOfPackages() {
		return noOfPackages;
	}
	public void setNoOfPackages(String noOfPackages) {
		this.noOfPackages = noOfPackages;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	
}

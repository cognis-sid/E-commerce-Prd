package com.rclgroup.dolphin.rcl.web.getRate.vo;

import java.util.List;

import com.rclgroup.dolphin.rcl.web.getRate.actionForm.ContainerUim;

public class QtnData {

	private String por;
	private String pol;
	private String pod;
	private String del;
	private String effectiveDate;
    private String expiryDate;
	
private List<ContainerUim>containerDtl;
	
	
	public List<ContainerUim> getContainerDtl() {
		return containerDtl;
	}
	public void setContainerDtl(List<ContainerUim> containerDtl) {
		this.containerDtl = containerDtl;
	}
    
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPor() {
		return por;
	}
	public void setPor(String por) {
		this.por = por;
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
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public QtnData() {
		// TODO Auto-generated constructor stub
	}
	public QtnData(String por, String pol, String pod, String del) {
		super();
		this.por = por;
		this.pol = pol;
		this.pod = pod;
		this.del = del;
	}
	@Override
	public String toString() {
		return "QtnData [por=" + por + ", pol=" + pol + ", pod=" + pod + ", del=" + del + "]";
	}
}

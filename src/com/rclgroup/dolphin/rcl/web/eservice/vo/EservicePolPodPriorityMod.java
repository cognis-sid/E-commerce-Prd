package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EservicePolPodPriorityMod implements Serializable {

	private String pol;
	private String pod;
	private String pot1;
		
	private String service;
	private String vessel;
	private String voyage;
	private String bsa;
	private String effDate;
    private String expDate;
    private String ts;
	
    public EservicePolPodPriorityMod() {
    	
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

	public String getPot1() {
		return pot1;
	}

	public void setPot1(String pot1) {
		this.pot1 = pot1;
	}

	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVessel() {
		return vessel;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getBsa() {
		return bsa;
	}

	public void setBsa(String bsa) {
		this.bsa = bsa;
	}

	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		return String.format("EservicePolPodPriorityUim [pol=%s, pod=%s, pot1=%s,service=%s,vessel=%s,"
				+ "voyage=%s,bsa=%s,effDate=%s,expDate=%s,ts=%s]", pol,
				pod, pot1, service,vessel,voyage,bsa,effDate,expDate,ts);
	}

}

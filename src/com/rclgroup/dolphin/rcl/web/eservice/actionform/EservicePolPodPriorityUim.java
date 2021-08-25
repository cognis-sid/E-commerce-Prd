/*------------------------------------------------------
 EservicePolPodPriorityUim.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2021
--------------------------------------------------------
Author -Joga
------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.niit.control.web.actionform.PaginationForm;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;

public class EservicePolPodPriorityUim extends PaginationForm {
	private String pol;
	private String pod;
	private String pot1;
	private String pot2;
	private String priority;
	
	private String service;
	private String vessel;
	private String voyage;
	private String bsa;
	private String effDate;
    private String expDate;
    
	private String ts;
	private String currPageAction;
	private String prevPageAction;
	private String errorMessage;
	
	private String selectAction;
	
	private boolean submitStatus=false; 
	
	private int pagePrevNo;
	
	private List displayDetailList;
	
	 private List errorList;
	
	private FormFile    dataFile;
	
	private List detailList=new ArrayList();;
	
	private List tableData = new ArrayList();
	
	private List<ContryMod> contryList;

	public EservicePolPodPriorityUim() {
		resetForm();
	}

	
	
	
	
	public List<ContryMod> getContryList() {
		return contryList;
	}





	public void setContryList(List<ContryMod> contryList) {
		this.contryList = contryList;
	}





	public String getSelectAction() {
		return selectAction;
	}


	
	



	public boolean isSubmitStatus() {
		return submitStatus;
	}



	public void setSubmitStatus(boolean submitStatus) {
		this.submitStatus = submitStatus;
	}



	public void setSelectAction(String selectAction) {
		this.selectAction = selectAction;
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

	public String getPot2() {
		return pot2;
	}

	public void setPot2(String pot2) {
		this.pot2 = pot2;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	
	 public List getValues() {
	        return this.tableData;
	    }

	    public void setValues(List aarlTableData) {
	        this.tableData = aarlTableData;
	    }
	    
	
	    
	public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
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
		
		

	public List getDetailList() {
			return detailList;
		}

		public void setDetailList(List detailList) {
			this.detailList = detailList;
		}

		public List getTableData() {
			return tableData;
		}

		public void setTableData(List tableData) {
			this.tableData = tableData;
		}

		
		
	public List getDisplayDetailList() {
			return displayDetailList;
		}

		public void setDisplayDetailList(List displayDetailList) {
			this.displayDetailList = displayDetailList;
		}
		
		

	public int getPagePrevNo() {
			return pagePrevNo;
		}

		public void setPagePrevNo(int pagePrevNo) {
			this.pagePrevNo = pagePrevNo;
		}

	public void resetForm() {
		try {
			this.pol = null;
			this.pod = null;
			this.pot1 = null;
			this.pot2 = null;
			this.priority = null;
			this.ts = null;
			this.currPageAction = null;
			this.prevPageAction = null;
			this.errorMessage=null;
			this.service=null;
			this.vessel=null;
			this.voyage=null;
			this.bsa=null;
			this.effDate=null;
			this.expDate=null;
			setSelectAction("1");
			this.submitStatus=false;
			this.errorList = new ArrayList();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public String getCurrPageAction() {
		return currPageAction;
	}

	public void setCurrPageAction(String currPageAction) {
		this.currPageAction = currPageAction;
	}

	public String getPrevPageAction() {
		return prevPageAction;
	}

	public void setPrevPageAction(String prevPageAction) {
		this.prevPageAction = prevPageAction;
	}

	
	public FormFile getDataFile() {
		return dataFile;
	}

	public void setDataFile(FormFile dataFile) {
		this.dataFile = dataFile;
	}
	
	

	public List getErrorList() {
		return errorList;
	}



	public void setErrorList(List errorList) {
		this.errorList = errorList;
	}



	@Override
	public String toString() {
		return String.format("EservicePolPodPriorityUim [pol=%s, pod=%s, pot1=%s, pot2=%s, priority=%s, ts=%s, currPageAction=%s, prevPageAction=%s,errorMessage=%s,service=%s,vessel=%s,"
				+ "voyage=%s,bsa=%s,effDate=%s,expDate=%s,submitStatus=%s]", pol,
				pod, pot1, pot2, priority, ts,currPageAction,prevPageAction,errorMessage,service,vessel,voyage,bsa,effDate,expDate,submitStatus);
	}

}

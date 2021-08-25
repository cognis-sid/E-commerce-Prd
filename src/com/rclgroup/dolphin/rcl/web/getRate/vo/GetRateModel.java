package com.rclgroup.dolphin.rcl.web.getRate.vo;

public class GetRateModel {

	private QuotationData quotationData=new QuotationData();

	public QuotationData getQuotationData() {
		return quotationData;
	}

	public void setQuotationData(QuotationData quotationData) {
		this.quotationData = quotationData;
	}

	public GetRateModel() {
		// TODO Auto-generated constructor stub
	}

	public GetRateModel(QuotationData quotationData) {
		super();
		this.quotationData = quotationData;
	}

	@Override
	public String toString() {
		return "GetRateModel [quotationData=" + quotationData + "]";
	}
	
	
}

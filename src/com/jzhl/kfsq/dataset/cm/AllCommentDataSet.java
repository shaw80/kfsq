package com.jzhl.kfsq.dataset.cm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllCommentDataSet implements Serializable{

	private static final long serialVersionUID = 661393140518740144L;
	
	protected List<?> dataList = new ArrayList<>();

	protected int dataCount = 0;

	protected int pageRowCnt = 20;
	
	protected String positiveCount;
	
	protected String negativeCount;
	
	protected String apartmentCount;
	
	protected String communityQualityCount;
	
	protected String educationCount;
	
	protected String trafficCount;
	
	protected String peripheralSupportCount;
	
	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageRowCnt() {
		return pageRowCnt;
	}

	public void setPageRowCnt(int pageRowCnt) {
		this.pageRowCnt = pageRowCnt;
	}

	public String getPositiveCount() {
		return positiveCount;
	}

	public void setPositiveCount(String positiveCount) {
		this.positiveCount = positiveCount;
	}

	public String getNegativeCount() {
		return negativeCount;
	}

	public void setNegativeCount(String negativeCount) {
		this.negativeCount = negativeCount;
	}

	public String getApartmentCount() {
		return apartmentCount;
	}

	public void setApartmentCount(String apartmentCount) {
		this.apartmentCount = apartmentCount;
	}

	public String getCommunityQualityCount() {
		return communityQualityCount;
	}

	public void setCommunityQualityCount(String communityQualityCount) {
		this.communityQualityCount = communityQualityCount;
	}

	public String getEducationCount() {
		return educationCount;
	}

	public void setEducationCount(String educationCount) {
		this.educationCount = educationCount;
	}

	public String getTrafficCount() {
		return trafficCount;
	}

	public void setTrafficCount(String trafficCount) {
		this.trafficCount = trafficCount;
	}

	public String getPeripheralSupportCount() {
		return peripheralSupportCount;
	}

	public void setPeripheralSupportCount(String peripheralSupportCount) {
		this.peripheralSupportCount = peripheralSupportCount;
	}

	public int getPageCount() {

		if (this.pageRowCnt == 0) {
			return 1;
		}

		if (dataCount % this.pageRowCnt > 0) {
			return dataCount / this.pageRowCnt + 1;
		} else {
			return dataCount / this.pageRowCnt;
		}

	}
	
}

package com.tirmizee.backend.rest.address.data;

import java.io.Serializable;

public class AddressCritiriaDTO implements Serializable{
	

	private static final long serialVersionUID = -3000797422117156864L;

	private String provinceName;
	private String districtName;
	private String subDistrictName;
	private String postCode;
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getSubDistrictName() {
		return subDistrictName;
	}
	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	

}

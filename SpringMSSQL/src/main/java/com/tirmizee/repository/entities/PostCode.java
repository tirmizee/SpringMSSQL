package com.tirmizee.repository.entities;

import org.springframework.data.domain.Persistable;

public class PostCode implements Persistable<Long>{

	private static final long serialVersionUID = 1846616516157883733L;
	
	private Long postCodeId;
    private String subDistrictCode;
    private String zipCode;

	public Long getPostCodeId() {
		return postCodeId;
	}

	public void setPostCodeId(Long postCodeId) {
		this.postCodeId = postCodeId;
	}

	public String getSubDistrictCode() {
		return subDistrictCode;
	}

	public void setSubDistrictCode(String subDistrictCode) {
		this.subDistrictCode = subDistrictCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public Long getId() {
		return postCodeId;
	}

	@Override
	public boolean isNew() {
		return postCodeId == null;
	}

}

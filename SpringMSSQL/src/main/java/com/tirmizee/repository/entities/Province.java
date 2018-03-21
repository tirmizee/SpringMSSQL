package com.tirmizee.repository.entities;

import org.springframework.data.domain.Persistable;

public class Province implements Persistable<Integer> {

	private static final long serialVersionUID = 1995983399181891934L;

	private Integer provinceId;
	private String provinceCode;
	private String provinceNameTH;
	
	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceNameTH() {
		return provinceNameTH;
	}

	public void setProvinceNameTH(String provinceNameTH) {
		this.provinceNameTH = provinceNameTH;
	}

	@Override
	public Integer getId() {
		return provinceId;
	}

	@Override
	public boolean isNew() {
		return provinceId == null;
	}

}

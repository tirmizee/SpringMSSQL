package com.tirmizee.repository.entities;

import org.springframework.data.domain.Persistable;

public class District implements Persistable<Integer> {

	private static final long serialVersionUID = 8385347264918686010L;
	
	private Integer districtId;
    private String districtCode;
    private String districtNameTH;
    private Integer fk_ProvinceId;

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}


	public String getDistrictNameTH() {
		return districtNameTH;
	}

	public void setDistrictNameTH(String districtNameTH) {
		this.districtNameTH = districtNameTH;
	}

	public Integer getFk_ProvinceId() {
		return fk_ProvinceId;
	}

	public void setFk_ProvinceId(Integer fk_ProvinceId) {
		this.fk_ProvinceId = fk_ProvinceId;
	}

	@Override
	public Integer getId() {
		return districtId;
	}

	@Override
	public boolean isNew() {
		return districtId == null;
	}

}

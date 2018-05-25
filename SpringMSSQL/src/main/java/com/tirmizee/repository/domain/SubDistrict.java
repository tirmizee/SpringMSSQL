package com.tirmizee.repository.domain;

import org.springframework.data.domain.Persistable;

public class SubDistrict implements Persistable<Long>{
	
	private static final long serialVersionUID = -4793880239475533628L;

	private Long subDistrictId;
    private String subDistrictCode;
    private String subDistrictName;
    private Integer fk_DistrictId;

	public Long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public String getSubDistrictCode() {
		return subDistrictCode;
	}

	public void setSubDistrictCode(String subDistrictCode) {
		this.subDistrictCode = subDistrictCode;
	}

	public String getSubDistrictName() {
		return subDistrictName;
	}

	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}

	public Integer getFk_DistrictId() {
		return fk_DistrictId;
	}

	public void setFk_DistrictId(Integer fk_DistrictId) {
		this.fk_DistrictId = fk_DistrictId;
	}

	@Override
	public Long getId() {
		return subDistrictId;
	}

	@Override
	public boolean isNew() {
		return subDistrictId == null;
	}

}

package com.tirmizee.backend.rest.address.data;

import java.io.Serializable;

import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.repository.DistrictRepository;
import com.tirmizee.repository.PostCodeRepository;
import com.tirmizee.repository.ProvinceRepository;
import com.tirmizee.repository.SubDistrictRepository;

public class AddressDTO implements Serializable{

	private static final long serialVersionUID = -8058123854558941373L;

	private Long subDistrictId;
	
	@SortColumn(value = ProvinceRepository.PROVINCE_NAME_TH)
	private String provinceNameTH;
	
	@SortColumn(value = ProvinceRepository.PROVINCE_NAME_EN)
	private String provinceNameEN;
	
	@SortColumn(value = DistrictRepository.DISTRICTNAME_EN)
	private String districtNameEN;
	
	@SortColumn(value = DistrictRepository.DISTRICTNAME_TH)
	private String districtNameTH;
	
	@SortColumn(value = SubDistrictRepository.SUB_DISTRICTNAME)
	private String subDistrictName;
	
	@SortColumn(value = PostCodeRepository.ZIPCODE)
	private String postcode;
	
	public String getProvinceNameTH() {
		return provinceNameTH;
	}
	public void setProvinceNameTH(String provinceNameTH) {
		this.provinceNameTH = provinceNameTH;
	}
	public String getProvinceNameEN() {
		return provinceNameEN;
	}
	public void setProvinceNameEN(String provinceNameEN) {
		this.provinceNameEN = provinceNameEN;
	}
	public String getDistrictNameEN() {
		return districtNameEN;
	}
	public void setDistrictNameEN(String districtNameEN) {
		this.districtNameEN = districtNameEN;
	}
	public String getDistrictNameTH() {
		return districtNameTH;
	}
	public void setDistrictNameTH(String districtNameTH) {
		this.districtNameTH = districtNameTH;
	}
	public Long getSubDistrictId() {
		return subDistrictId;
	}
	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}
	public String getSubDistrictName() {
		return subDistrictName;
	}
	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}

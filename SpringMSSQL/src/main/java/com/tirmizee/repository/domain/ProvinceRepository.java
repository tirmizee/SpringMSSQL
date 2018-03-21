package com.tirmizee.repository.domain;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.entities.Province;

public interface ProvinceRepository  extends JdbcRepository<Province, Integer> {

	public static final String PROVINCS = "Provinces";
	public static final String PROVINCE_ID = "ProvinceId";
	public static final String PROVINCE_CODE = "ProvinceCode";
	public static final String PROVINCE_NAME_TH = "ProvinceNameTH";
	public static final String PROVINCE_NAME_EN = "ProvinceNameEN";
	
	public static final String PROVINCES_PROVINCE_ID = PROVINCS + "." + PROVINCE_ID;
	public static final String PROVINCES_PROVINCE_CODE = PROVINCS + "." + PROVINCE_CODE;
	public static final String PROVINCES_PROVINCENAME_TH = PROVINCS + "." + PROVINCE_NAME_TH;
	public static final String PROVINCES_PROVINCENAME_EN = PROVINCS + "." + PROVINCE_NAME_EN;

}

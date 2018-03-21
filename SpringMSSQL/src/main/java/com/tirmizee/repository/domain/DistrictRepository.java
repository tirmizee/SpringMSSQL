package com.tirmizee.repository.domain;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.entities.District;

public interface DistrictRepository extends JdbcRepository<District, Integer>{

	public static final String DISTRICTS = "Districts";
	public static final String DISTRICTID = "DistrictId";
	public static final String DISTRICTCODE = "DistrictCode";
	public static final String DISTRICTNAME_TH = "DistrictNameTH";
	public static final String DISTRICTNAME_EN = "DistrictNameEN";
	public static final String FK_PROVINCEID = "Fk_ProvinceId";

	
	static final String DOT = ".";
	public static final String DISTRICTS_DISTRICTID = DISTRICTS + DOT + DISTRICTID;
	public static final String DISTRICTS_DISTRICTCODE = DISTRICTS + DOT + DISTRICTCODE;
	public static final String DISTRICTS_DISTRICTNAME_TH = DISTRICTS + DOT + DISTRICTNAME_TH;
	public static final String DISTRICTS_DISTRICTNAME_EN = DISTRICTS + DOT + DISTRICTNAME_EN;
	public static final String DISTRICTS_FK_PROVINCEID = DISTRICTS + DOT + FK_PROVINCEID;

}

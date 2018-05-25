package com.tirmizee.repository;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.domain.SubDistrict;

public interface SubDistrictRepository extends JdbcRepository<SubDistrict, Long>{

	public static final String SUBDISTRICTS = "SubDistricts";
	public static final String SUB_DISTRICTID = "SubDistrictId";
	public static final String SUB_DISTRICTCODE = "SubDistrictCode";
	public static final String SUB_DISTRICTNAME = "SubDistrictName";
	public static final String FK_DISTRICTID = "Fk_DistrictId";
	
	public static final String SUBDISTRICTS_SUBDISTRICTID = SUBDISTRICTS + "." + SUB_DISTRICTID;
	public static final String SUBDISTRICTS_SUBDISTRICTCODE = SUBDISTRICTS + "." + SUB_DISTRICTCODE;
	public static final String SUBDISTRICTS_SUBDISTRICTNAME = SUBDISTRICTS + "." + SUB_DISTRICTNAME;
	public static final String SUBDISTRICTS_FK_DISTRICTID = SUBDISTRICTS + "." + FK_DISTRICTID;

}

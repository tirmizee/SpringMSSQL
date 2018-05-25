package com.tirmizee.repository;

import com.tirmizee.jdbcrepository.JdbcRepository;
import com.tirmizee.repository.domain.PostCode;

public interface PostCodeRepository extends JdbcRepository<PostCode, Long>{
	
	public static final String POSTCODES = "PostCodes";
	public static final String POSTCODEID = "PostCodeId";
	public static final String SUBDISTRICTCODE = "SubDistrictCode";
	public static final String ZIPCODE = "ZipCode";
	
	public static final String POSTCODES_POSTCODEID = POSTCODES + "." + POSTCODEID;
	public static final String POSTCODES_SUBDISTRICTCODE = POSTCODES + "." + SUBDISTRICTCODE;
	public static final String POSTCODES_ZIPCODE = POSTCODES + "." + ZIPCODE;

}

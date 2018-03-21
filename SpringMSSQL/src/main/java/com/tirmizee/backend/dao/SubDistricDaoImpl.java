package com.tirmizee.backend.dao;

import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTS;
import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTS_DISTRICTID;
import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTS_DISTRICTNAME_EN;
import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTS_DISTRICTNAME_TH;
import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTS_FK_PROVINCEID;
import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTNAME_EN;
import static com.tirmizee.repository.domain.DistrictRepository.DISTRICTNAME_TH;
import static com.tirmizee.repository.domain.PostCodeRepository.POSTCODES;
import static com.tirmizee.repository.domain.PostCodeRepository.POSTCODES_POSTCODEID;
import static com.tirmizee.repository.domain.PostCodeRepository.POSTCODES_SUBDISTRICTCODE;
import static com.tirmizee.repository.domain.PostCodeRepository.POSTCODES_ZIPCODE;
import static com.tirmizee.repository.domain.PostCodeRepository.ZIPCODE;
import static com.tirmizee.repository.domain.ProvinceRepository.PROVINCES_PROVINCENAME_EN;
import static com.tirmizee.repository.domain.ProvinceRepository.PROVINCES_PROVINCENAME_TH;
import static com.tirmizee.repository.domain.ProvinceRepository.PROVINCES_PROVINCE_ID;
import static com.tirmizee.repository.domain.ProvinceRepository.PROVINCE_NAME_EN;
import static com.tirmizee.repository.domain.ProvinceRepository.PROVINCE_NAME_TH;
import static com.tirmizee.repository.domain.ProvinceRepository.PROVINCS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.rest.address.data.AddressCritiriaDTO;
import com.tirmizee.backend.rest.address.data.AddressDTO;
import com.tirmizee.jdbcrepository.sql.QueryBuilder;
import com.tirmizee.repository.domain.SubDistrictRepositoryImpl;

@Repository("SubDistricDao")
public class SubDistricDaoImpl extends SubDistrictRepositoryImpl implements SubDistricDao{

	private final RowMapper<AddressDTO> getAddressMapper(String lang){
		final RowMapper<AddressDTO> ROW_MAPPER_ADDRESS = new RowMapper<AddressDTO>() {
			@Override
			public AddressDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				AddressDTO addressDto = new AddressDTO();
				addressDto.setSubDistrictId(rs.getLong(SUB_DISTRICTID));
				addressDto.setSubDistrictName(rs.getString(SUB_DISTRICTNAME));
				addressDto.setPostcode(rs.getString(ZIPCODE));
				if (lang == "th") {
					addressDto.setProvinceNameTH(rs.getString(PROVINCE_NAME_TH));
					addressDto.setDistrictNameTH(rs.getString(DISTRICTNAME_TH));
				}else{
					addressDto.setProvinceNameEN(rs.getString(PROVINCE_NAME_EN));
					addressDto.setDistrictNameEN(rs.getString(DISTRICTNAME_EN));
				}
				return addressDto;
			}
		};
		return ROW_MAPPER_ADDRESS;
	} 

	@Override
	public Page<AddressDTO> findByCriteria(AddressCritiriaDTO criteria,Pageable pageable,String lang) {
		List<Object> params = new LinkedList<>();
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.SELECT()
			.COLUMN(SUBDISTRICTS_SUBDISTRICTID).COMMA()
			.COLUMN(lang == "th" ? PROVINCES_PROVINCENAME_TH : PROVINCES_PROVINCENAME_EN).COMMA()
			.COLUMN(lang == "th" ? DISTRICTS_DISTRICTNAME_TH : DISTRICTS_DISTRICTNAME_EN).COMMA()
			.COLUMN(SUBDISTRICTS_SUBDISTRICTNAME).COMMA()
			.COLUMN(POSTCODES_ZIPCODE)
		.FROM(PROVINCS)
			.INNER_JOIN(DISTRICTS)
				.ON(PROVINCES_PROVINCE_ID).EQUAL(DISTRICTS_FK_PROVINCEID)
			.INNER_JOIN(SUBDISTRICTS)
				.ON(DISTRICTS_DISTRICTID).EQUAL(SUBDISTRICTS_FK_DISTRICTID)
			.INNER_JOIN(POSTCODES)
				.ON(SUBDISTRICTS_SUBDISTRICTCODE).EQUAL(POSTCODES_SUBDISTRICTCODE)
		.WHERE(POSTCODES_POSTCODEID).IS_NOT_NULL();
		if (criteria.getProvinceName() != null) {
			queryBuilder.AND()
				.COLUMN(lang == "th" ? PROVINCES_PROVINCENAME_TH : PROVINCES_PROVINCENAME_EN)
				.LIKE_PARAM();
			params.add(StringUtils.trimToEmpty("%" + criteria.getProvinceName() + "%"));
		}
		if (criteria.getDistrictName() != null) {
			queryBuilder.AND()
				.COLUMN(lang == "th" ? DISTRICTS_DISTRICTNAME_TH : DISTRICTS_DISTRICTNAME_EN)
				.LIKE_PARAM();
			params.add(StringUtils.trimToEmpty("%" + criteria.getDistrictName() + "%"));
		}
		if (criteria.getSubDistrictName() != null) {
			queryBuilder.AND().COLUMN(SUBDISTRICTS_SUBDISTRICTNAME).LIKE_PARAM();
			params.add(StringUtils.trimToEmpty("%" + criteria.getSubDistrictName() + "%"));
		}
		if (criteria.getPostCode() != null) {
			queryBuilder.AND().COLUMN(POSTCODES_ZIPCODE).LIKE_PARAM();
			params.add(StringUtils.trimToEmpty("%" + criteria.getPostCode() + "%"));
		}
		String sqlStatement = getSqlGenerator().selectAll(getTable(), queryBuilder.toStringBuilder(), pageable);
		long total = count(queryBuilder.toString(), params.toArray());
		List<AddressDTO> content = getJdbcOps().query(sqlStatement, params.toArray(), getAddressMapper(lang));
		return new PageImpl<>(content, pageable, total);
	}

}

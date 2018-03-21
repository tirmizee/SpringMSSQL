package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.SubDistrict;


@Repository("SubDistrictRepository")
public class SubDistrictRepositoryImpl extends AbstractJdbcRepository<SubDistrict, Long> implements SubDistrictRepository{

	public SubDistrictRepositoryImpl() {
		this(SUBDISTRICTS);
	}
	
	public SubDistrictRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, SUB_DISTRICTID);
	}

	public static final RowMapper<SubDistrict> ROW_MAPPER = new RowMapper<SubDistrict>() {
		
		@Override
		public SubDistrict mapRow(ResultSet rs, int rowNum) throws SQLException {
			SubDistrict subDistrict = new SubDistrict();
			subDistrict.setSubDistrictId(rs.getLong(SUB_DISTRICTID));
			subDistrict.setSubDistrictCode(rs.getString(SUB_DISTRICTCODE));
			subDistrict.setSubDistrictName(rs.getString(SUB_DISTRICTNAME));
			subDistrict.setFk_DistrictId(rs.getInt(FK_DISTRICTID));
			return subDistrict;
		}
	};
	
	public static final RowUnmapper<SubDistrict> ROW_UNMAPPER = new RowUnmapper<SubDistrict>() {
		
		@Override
		public Map<String, Object> mapColumns(SubDistrict param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(SUB_DISTRICTID, param.getSubDistrictId());
			map.put(SUB_DISTRICTCODE, param.getSubDistrictCode());
			map.put(SUB_DISTRICTNAME, param.getSubDistrictName());
			map.put(FK_DISTRICTID, param.getFk_DistrictId());
			return map;
		}
	};

	@Override
	protected <S extends SubDistrict> S postCreate(S entity, Number generatedId) {
		entity.setSubDistrictId(generatedId.longValue());
		return entity;
	}

}

package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.District;

@Repository("DistrictRepository")
public class DistrictRepositoryImpl extends AbstractJdbcRepository<District, Integer> implements DistrictRepository{

	public DistrictRepositoryImpl() {
		this(DISTRICTS);
	}
	
	public DistrictRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, DISTRICTID);
	}
	
	public static final RowMapper<District> ROW_MAPPER = new RowMapper<District>() {
		
		@Override
		public District mapRow(ResultSet rs, int rowNum) throws SQLException {
			District district = new District();
			district.setDistrictId(rs.getInt(DISTRICTID));
			district.setDistrictCode(rs.getString(DISTRICTCODE));
			district.setDistrictNameTH(rs.getString(DISTRICTNAME_TH));
			district.setFk_ProvinceId(rs.getInt(FK_PROVINCEID));
			return district;
		}
	};
	
	public static final RowUnmapper<District> ROW_UNMAPPER = new RowUnmapper<District>() {
		
		@Override
		public Map<String, Object> mapColumns(District param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(DISTRICTID, param.getDistrictId());
			map.put(DISTRICTCODE, param.getDistrictCode());
			map.put(DISTRICTNAME_TH, param.getDistrictNameTH());
			map.put(FK_PROVINCEID, param.getFk_ProvinceId());
			return map;
		}
	};

	@Override
	protected <S extends District> S postCreate(S entity, Number generatedId) {
		entity.setDistrictId(generatedId.intValue());
		return entity;
	}
	
	

}

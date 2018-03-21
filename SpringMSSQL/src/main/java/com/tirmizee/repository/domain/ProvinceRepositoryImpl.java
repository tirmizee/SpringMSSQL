package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.Province;


@Repository("ProvinceRepository")
public class ProvinceRepositoryImpl extends AbstractJdbcRepository<Province, Integer> implements ProvinceRepository {

	public ProvinceRepositoryImpl() {
		this(PROVINCS);
	}
	
	public ProvinceRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, PROVINCE_ID);
	}
	
	
	public static final RowMapper<Province> ROW_MAPPER = new RowMapper<Province>() {
		
		@Override
		public Province mapRow(ResultSet rs, int rowNum) throws SQLException {
			Province province = new Province();
			province.setProvinceId(rs.getInt(PROVINCE_ID));
			province.setProvinceCode(rs.getString(PROVINCE_CODE));
			province.setProvinceNameTH(rs.getString(PROVINCE_NAME_TH));
			return province;
		}
	};
	
	public static final RowUnmapper<Province> ROW_UNMAPPER = new RowUnmapper<Province>() {
		
		@Override
		public Map<String, Object> mapColumns(Province param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(PROVINCE_ID, param.getProvinceId());
			map.put(PROVINCE_CODE, param.getProvinceCode());
			map.put(PROVINCE_NAME_TH, param.getProvinceNameTH());
			return map;
		}
	};

	@Override
	protected <S extends Province> S postCreate(S entity, Number generatedId) {
		entity.setProvinceId(generatedId.intValue());
		return entity;
	}

}
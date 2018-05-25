package com.tirmizee.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.domain.PostCode;


@Repository("PostCodeRepository")
public class PostCodeRepositoryImpl extends AbstractJdbcRepository<PostCode, Long> implements PostCodeRepository {

	public PostCodeRepositoryImpl() {
		this(POSTCODES);
	}
	
	public PostCodeRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, POSTCODEID);
	}
	
	public static final RowMapper<PostCode> ROW_MAPPER = new RowMapper<PostCode>() {
		
		@Override
		public PostCode mapRow(ResultSet rs, int rowNum) throws SQLException {
			PostCode postCode = new PostCode();
			postCode.setPostCodeId(rs.getLong(POSTCODEID));
			postCode.setSubDistrictCode(SUBDISTRICTCODE);
			postCode.setZipCode(rs.getString(ZIPCODE));
			return postCode;
		}
	};
	
	public static final RowUnmapper<PostCode> ROW_UNMAPPER = new RowUnmapper<PostCode>() {
		
		@Override
		public Map<String, Object> mapColumns(PostCode param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(POSTCODEID, param.getId());
			map.put(SUBDISTRICTCODE, param.getSubDistrictCode());
			map.put(ZIPCODE, param.getZipCode());
			return map;
		}
	};

	@Override
	protected <S extends PostCode> S postCreate(S entity, Number generatedId) {
		entity.setPostCodeId(generatedId.longValue());
		return entity;
	}

}

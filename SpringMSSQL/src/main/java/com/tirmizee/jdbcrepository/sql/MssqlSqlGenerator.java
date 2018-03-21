package com.tirmizee.jdbcrepository.sql;

import org.springframework.data.domain.Pageable;

import com.tirmizee.core.exception.UnsupportedMssqlException;
import com.tirmizee.jdbcrepository.TableDescription;

/**
 * @author pratya yeekhaday
 *
 */
public class MssqlSqlGenerator extends SqlGenerator {

	public static String ROW_NUM_WRAPPER = "SELECT a__.* FROM (SELECT row_number() OVER (ORDER BY %s) AS ROW_NUM,  t__.*  FROM   (%s) t__) a__ WHERE  a__.row_num BETWEEN %s AND %s";

	public MssqlSqlGenerator() {}

	public MssqlSqlGenerator(String allColumnsClause) {
		super(allColumnsClause);
	}
	
	@Override
	@Deprecated
	protected String limitClause(Pageable page) {
		throw new UnsupportedMssqlException();
	}

	@Override
	public String selectAll(TableDescription table, Pageable page) {
		return generateSelectAllWithPagination(table, page);
	}

	@Override
	@Deprecated
	public StringBuilder selectAll(StringBuilder statement, Pageable page) {
		throw new UnsupportedMssqlException();
	}
	
	@Override
	public String selectAll(TableDescription table, StringBuilder statement, Pageable page) {
		return generateSelectWithPagination(table, statement, page);
	}

	public String generateSelectAllWithPagination(TableDescription table, Pageable page) {
		final int beginOffset = getBeginOffset(page);
		final int endOffset = beginOffset + page.getPageSize() - 1;
		String orderByPart = getOrderByPart(page, table);
		String selectAllPart = selectAll(table);
		return String.format(ROW_NUM_WRAPPER, orderByPart, selectAllPart, beginOffset, endOffset);
	}
	
	public String generateSelectWithPagination(TableDescription table, StringBuilder statement ,Pageable page) {
		final int beginOffset = getBeginOffset(page);
		final int endOffset = beginOffset + page.getPageSize() - 1;
		String orderByPart = getOrderByPart(page, table);
		return String.format(ROW_NUM_WRAPPER, orderByPart, statement, beginOffset, endOffset);
	}
	
	private static int getBeginOffset(Pageable page){
		return page.getPageNumber() * page.getPageSize() + 1;
	}
	
	private static String getOrderByPart(Pageable page ,TableDescription table){
		return (page.getSort() != null) ? page.getSort().toString().replace(":", "")
				                        : table.getIdColumns().get(0);
	}
	
}

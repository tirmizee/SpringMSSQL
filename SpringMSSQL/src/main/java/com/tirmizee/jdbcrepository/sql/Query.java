package com.tirmizee.jdbcrepository.sql;


/**
 * @author pratya yeekhaday
 * 
 */
public abstract interface Query {
	
	public static final String SELECT = " SELECT ";
	public static final String ALL = " * ";
	public static final String AS = " AS ";
	public static final String FROM = " FROM ";
	public static final String WHERE = " WHERE ";
	public static final String GROUP_BY = " GROUP BY ";
	public static final String HAVING = " HAVING ";
	public static final String ORDER_BY = " ORDER BY ";
	public static final String ASC = " ASC ";
	public static final String DESC = " DESC ";
	public static final String JOIN = " JOIN ";
	public static final String INNER_JOIN = " INNER JOIN ";
	public static final String LEFT_JOIN = " LEFT JOIN ";
	public static final String RIGHT_JOIN = " RIGHT JOIN ";
	public static final String COMMA = " , ";
	public static final String EQUAL = " = ";
	public static final String ON = " ON ";
	public static final String AND = " AND ";
	public static final String IN = " IN ";
	public static final String IS_NOT_NULL = " IS NOT NULL ";
	public static final String IS_NULL = " IS NULL ";
	public static final String LIKE_PARAM = " LIKE ? ";
	public static final String PARAM = "  ? ";
	
}

package com.tirmizee.jdbcrepository.sql;

import java.io.Serializable;
import java.util.List;

/**
 * @author pratya yeekhaday
 *
 */
public class QueryBuilder implements Query{
	
	private StringBuilder statement;
	
	public QueryBuilder(){
		statement = new StringBuilder();
	}
	
	public QueryBuilder SELECT(String statement){
		this.statement.append(SELECT).append(statement);
		return this;
	}
	
	public QueryBuilder SELECT_ALL(){
		this.statement.append(SELECT).append(ALL);
		return this;
	}
	
	public QueryBuilder SELECT(){
		statement.append(SELECT);
		return this;
	}
	
	public QueryBuilder ALL(){
		statement.append(ALL);
		return this;
	}
	
	public QueryBuilder FROM(String tableName){
		statement.append(FROM).append(tableName);
		return this;
	}
	
	public QueryBuilder WHERE(String columnName){
		statement.append(WHERE).append(columnName);
		return this;
	}
	
	public QueryBuilder TABLE(String tableName){
		statement.append(tableName);
		return this;
	}
	
	public QueryBuilder COLUMN(String columnName){
		statement.append(columnName);
		return this;
	}
	
	public QueryBuilder COMMA(){
		statement.append(COMMA);
		return this;
	}
	
	public QueryBuilder IS_NOT_NULL(){
		statement.append(IS_NOT_NULL);
		return this;
	}
	
	public QueryBuilder AND(){
		statement.append(AND);
		return this;
	}
	
	public QueryBuilder LIKE_PARAM(){
		statement.append(LIKE_PARAM);
		return this;
	}
	
	public QueryBuilder JOIN(String tableName){
		statement.append(JOIN).append(tableName);
		return this;
	}
	
	public QueryBuilder INNER_JOIN(String tableName){
		statement.append(INNER_JOIN).append(tableName);
		return this;
	}
	
	public QueryBuilder LEFT_JOIN(String tableName){
		statement.append(LEFT_JOIN).append(tableName);
		return this;
	}
	
	public QueryBuilder RIGHT_JOIN(String tableName){
		statement.append(RIGHT_JOIN).append(tableName);
		return this;
	}
	
	public QueryBuilder ON(String value){
		statement.append(ON).append(value);
		return this;
	}
	
	public QueryBuilder AS(String name){
		statement.append(AS).append(name);
		return this;
	}
	
	public QueryBuilder EQUAL(String value){
		statement.append(EQUAL).append(value);
		return this;
	}
	
	public QueryBuilder ORDER_BY(String columnName){
		statement.append(ORDER_BY).append(columnName);
		return this;
	}
	
	public QueryBuilder IN(String statement){
		this.statement.append(IN).append(" ( ");
		this.statement.append(statement);
		this.statement.append(" ) ");
		return this;
	}
	
	public QueryBuilder IN(List<? extends Serializable> values){
		statement.append(IN).append(" ( ");
		if (!values.isEmpty()) { 
			statement.append(PARAM);
			for (int i = 1; i < values.size(); i++) {
				statement.append(COMMA).append(PARAM);
			}
		}
		statement.append(" ) ");
		return this;
	}
	
	public StringBuilder toStringBuilder(){
		return statement;
	}
	
	public String toString(){
		return statement.toString();
	}

}

package com.tirmizee.jdbcrepository.sql;

public class Demo {

	public static void main(String[] args) {
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.SELECT()
			.COLUMN("username").COMMA()
			.COLUMN("ssss")
		.FROM("license")
		.INNER_JOIN("adsadsa")
			.ON("a").EQUAL("a")
		.INNER_JOIN("mo");
		System.out.println(queryBuilder.toString());
	}

}

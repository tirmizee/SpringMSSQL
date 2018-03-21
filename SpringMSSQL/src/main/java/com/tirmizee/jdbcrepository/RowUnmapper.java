package com.tirmizee.jdbcrepository;

import java.util.Map;

public abstract class RowUnmapper<T> {
	public abstract Map<String, Object> mapColumns(T paramT);
}

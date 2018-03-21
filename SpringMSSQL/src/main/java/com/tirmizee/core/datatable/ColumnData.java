package com.tirmizee.core.datatable;

import java.io.Serializable;

/**
 * wrapper for datatables.js  
 * 
 * @author pratya yeekhaday
 * @see https://datatables.net/manual/server-side
 */
public class ColumnData  implements Serializable{

	private static final long serialVersionUID = 4556209539434726243L;
	
	private String data;
	private String name;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

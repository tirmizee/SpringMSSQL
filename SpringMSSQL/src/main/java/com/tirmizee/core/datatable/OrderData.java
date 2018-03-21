package com.tirmizee.core.datatable;

import java.io.Serializable;

/**
 * wrapper for datatables.js  
 * 
 * @author pratya yeekhaday
 * @see https://datatables.net/manual/server-side
 */
public class OrderData implements Serializable {

	private static final long serialVersionUID = -2701552023491998112L;
	
	private Long column;
	private String dir;
	
	public Long getColumn() {
		return column;
	}
	public void setColumn(Long column) {
		this.column = column;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	

}

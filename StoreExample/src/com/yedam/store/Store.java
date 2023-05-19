package com.yedam.store;

public class Store {
//	STORE_ID    NOT NULL NUMBER        
//	STORE_NAME           VARCHAR2(100) 
//	STORE_TEL            VARCHAR2(15)  
//	STORE_ADDR           VARCHAR2(100) 
//	STORE_SALES          NUMBER    

	private int store_id;
	private String store_name;
	private String store_tel;
	private String store_addr;
	private int sales;

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_tel() {
		return store_tel;
	}

	public void setStore_tel(String store_tel) {
		this.store_tel = store_tel;
	}

	public String getStore_addr() {
		return store_addr;
	}

	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

}

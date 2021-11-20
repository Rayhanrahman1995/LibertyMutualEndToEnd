package com.data;

public class AutoQuoteInfo {


	private int zipcode;
	private String stAddress;
	private String apt;
	
	public AutoQuoteInfo(int zipcode,String stAddress,String apt) {
		this.zipcode=zipcode;
		this.stAddress=stAddress;
		this.apt=apt;	
	}
	public int getZipCode() {
		return zipcode;
	}
	public String getStAddress() {
		return stAddress;
	}
	public String getApt() {
		return apt;
	}
		
}

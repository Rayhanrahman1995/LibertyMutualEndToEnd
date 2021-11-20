package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class AutoQuoteProperty {

	private static AutoQuoteProperty autoQuote2Prop;
	private static Properties properties;
	
	private static int zipCode;
	private static String stAddress;
	private static String apt;
	
	private static String excelPath;
	private static String sheetName;
	
	private static String configPath="configuration/autoQuoteInfo.properties";
	
	private AutoQuoteProperty() {
		
	}
	public static AutoQuoteProperty getInstanceOfAutoQuote2Prop() {
		if(autoQuote2Prop==null) {
			autoQuote2Prop=new AutoQuoteProperty();
			autoQuote2Prop.loadAutoQuoteProp();
		}
		return autoQuote2Prop;
	}
	public void loadAutoQuoteProp() {
		try {
		FileInputStream fis=new FileInputStream(configPath);
		properties=new Properties();
		properties.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
	   zipCode=Integer.parseInt(properties.getProperty("zipCode"));
	   stAddress=properties.getProperty("stAddress");
	   apt=properties.getProperty("apt");
	   excelPath=properties.getProperty("excelpath");
	   sheetName=properties.getProperty("sheetname");
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getStAddress() {
		return stAddress;
	}
	public String getApt() {
		return apt;
	}
	public String getExcelPath() {
		return excelPath;
	}
	public String getSheetName() {
		return sheetName;
	}
}

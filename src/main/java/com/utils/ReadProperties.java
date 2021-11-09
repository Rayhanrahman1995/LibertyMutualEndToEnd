package com.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	private static ReadProperties instanceProperties;
	private static Properties properties;

	private static String url;
	private static String username;
	private static String password;
	private static int pageLoadWait;
	private static int implicitWait;
	private static String excelPath;
	private static String sheetName;

	private static String configFilePath = "configuration/config.properties";

	private ReadProperties() {
	}

	public static ReadProperties instanceOfProp() {
		if (instanceProperties == null) {
			instanceProperties = new ReadProperties();
			instanceProperties.loadProperties();
		}
		return instanceProperties;
	}

	private void loadProperties() {
		BufferedReader bufferedReader;
		properties = new Properties();
		try {
			bufferedReader = new BufferedReader(new FileReader(configFilePath));
			properties.load(bufferedReader);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Not Found On The Given Location");
		}
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		pageLoadWait = Integer.parseInt(properties.getProperty("pagewait"));
		implicitWait = Integer.parseInt(properties.getProperty("implicitwait"));
		excelPath = properties.getProperty("excelpath");
		sheetName = properties.getProperty("sheetname");
	}

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getPageLoadWait() {
		return pageLoadWait;
	}

	public int getImplicitWait() {
		return implicitWait;
	}

	public String getExcelPath() {
		return excelPath;
	}

	public String getSheetName() {
		return sheetName;
	}
}

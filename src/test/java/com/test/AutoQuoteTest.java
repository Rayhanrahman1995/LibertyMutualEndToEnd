package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.commonMethods.CommonMethods;
import com.data.AutoQuoteInfo;
import com.pages.AutoQuote;
import com.pages.AutoQuote1;
import com.pages.AutoQuote2;
import com.pages.AutoQuoteFromExcel;
import com.utils.AutoQuoteProperty;
import com.utils.ExcelReader;

public class AutoQuoteTest extends Base{

	CommonMethods cm;
	AutoQuote autoQuote;
	AutoQuote1 autoQuote1;
	AutoQuote2 autoQuote2;
	AutoQuoteFromExcel autoQuoteFromExcel;
	
	@DataProvider(name = "AutoQuote1")
	public Iterator<AutoQuoteInfo> getAutoQuoteInfo(){
		ArrayList<AutoQuoteInfo> info=new ArrayList<AutoQuoteInfo>();
		info.add(new AutoQuoteInfo(10472,"1225 watson avenue", "fl-o2"));
		return info.iterator();
	}
	@DataProvider(name = "AutoQuoteExcelData")
	public Object[][] getAutoQuoteData(){
	String excelPath =System.getProperty("user.dir") +AutoQuoteProperty.getInstanceOfAutoQuote2Prop().getExcelPath();
	String sheetName =AutoQuoteProperty.getInstanceOfAutoQuote2Prop().getSheetName();
	ExcelReader excelReader=new ExcelReader(excelPath,sheetName);
		Object[][] data=excelReader.getData();
		return data;
	}
	 @DataProvider(name = "dataAutoQuote")
	   public Object[][] dataAuto(){
		   Object[][] o=new Object[1][3];
		   o[0][0]=10472;
		   o[0][1]="1252 gleason avenue";
		   o[0][2]="fl-02";
		   return o;
	   }
	@BeforeMethod
	public void initialization() {
		cm=new CommonMethods();
		autoQuote=new AutoQuote(driver);
		autoQuote1=new AutoQuote1(driver);
		autoQuote2=new AutoQuote2(driver);
		autoQuoteFromExcel=new AutoQuoteFromExcel(driver);
	}
	@Test(priority = 1, enabled = true)
	public void autoQuoteTest()  {
		autoQuote.autoQuoteSteps(cm);
	}
	@Test(priority = 2, enabled = true, dataProvider = "AutoQuote1")
	public void autoQuoteInfoTest(AutoQuoteInfo autoQuoteInfo) {
		autoQuote1.autoQuoteSteps1(cm, autoQuoteInfo);
	}
	@Test(priority = 3, enabled = true)
	public void autoQuoteInfo2Test() {
		autoQuote2.autoQuoteSteps2(cm, 
				AutoQuoteProperty.getInstanceOfAutoQuote2Prop().getZipCode(),
				AutoQuoteProperty.getInstanceOfAutoQuote2Prop().getStAddress(),
				AutoQuoteProperty.getInstanceOfAutoQuote2Prop().getApt());
	}
	@Test(priority = 4, dataProvider = "dataAutoQuote", enabled = true)
	public void autoQuoteDataProviderTest(int zipCode, String stAddress,String apt) {
		autoQuoteFromExcel.autoQuoteExcelSteps(cm, zipCode, stAddress, apt);
	}
	@Test(priority = 5, dataProvider = "AutoQuoteExcelData", enabled = true)
	public void autoQuoteFromExcelTest(String zipCode, String stAddress,String apt) {
		autoQuoteFromExcel.autoQuoteExcelSteps(cm, Integer.parseInt(zipCode), stAddress, apt);
	}
	
	
}

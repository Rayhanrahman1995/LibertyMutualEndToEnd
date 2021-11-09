package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.commonMethods.CommonMethods;
import com.data.PersonalInfo;
import com.pages.LogIn;
import com.pages.LogInByDataProvider;
import com.pages.LogInFromExcel;
import com.utils.ExcelReader;
import com.utils.ReadProperties;

public class LogInTest extends Base {

	CommonMethods commonMethods;
	LogIn logIn;
	LogInByDataProvider logInByDataProvider;
	LogInFromExcel logInFromExcel;

	@DataProvider(name = "MyInfo")
	public Iterator<PersonalInfo> getInfo() {
		ArrayList<PersonalInfo> data = new ArrayList<PersonalInfo>();
		data.add(new PersonalInfo("jahadahmed@gmail.com", "3473025745"));
		return data.iterator();
	}

	@DataProvider(name = "Excel")
	public Object[][] data() {
		String excelPath = System.getProperty("user.dir") + ReadProperties.instanceOfProp().getExcelPath();
		String sheetName = ReadProperties.instanceOfProp().getSheetName();
		ExcelReader reader = new ExcelReader(excelPath, sheetName);
		Object[][] obj = reader.getData();
		return obj;
	}

	@BeforeMethod
	public void pageInitialize() {
		commonMethods = new CommonMethods();
		logIn = new LogIn(driver);
		logInByDataProvider = new LogInByDataProvider(driver);
		logInFromExcel = new LogInFromExcel(driver);
	}

	@Test(priority = 1, enabled = true)
	public void LibertyMutualLogIn() {
		logIn.logInSteps(commonMethods, ReadProperties.instanceOfProp().getUserName(),
				ReadProperties.instanceOfProp().getPassword());
	}

	@Test(priority = 2, dataProvider = "MyInfo", enabled = true)
	public void libertyMutualLogInByDataProvider(PersonalInfo personalInfo) {
		logInByDataProvider.logInByDataProviderSteps(commonMethods, personalInfo);
	}

	@Test(priority = 3, dataProvider = "Excel", enabled = true)
	public void libertyMutualLogInFromExcel(String username, String password) {
		logInFromExcel.logInFromExcelSteps(commonMethods, username, password);
	}
}

package com.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.commonMethods.CommonMethods;
import com.pages.HomePageLogo;

public class HomePageLogoTest extends Base{

	CommonMethods cMethods;
	HomePageLogo homePageLogo;
	
	@BeforeMethod
	public void initialization() {
		cMethods=new CommonMethods();
		homePageLogo=new HomePageLogo(driver);
	}
	@Test(priority = 1,enabled = true)
	public void homePageLogoTest() {
		homePageLogo.homePageLogoSteps(cMethods);
	}
	
	
}

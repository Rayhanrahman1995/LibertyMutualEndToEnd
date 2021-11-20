package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonMethods.CommonMethods;

public class HomePageLogo {

	
	@FindBy(xpath = "(//img[@class='jsx-771609414'])[1]")
	public WebElement TruckLogo;
	
	public HomePageLogo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void homePageLogoSteps(CommonMethods cm) {
		
		cm.isElementDisplayable(TruckLogo);
	}
	
		
}

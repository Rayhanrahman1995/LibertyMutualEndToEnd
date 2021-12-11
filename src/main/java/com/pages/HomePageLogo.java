package com.pages;

import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonMethods.CommonMethods;
import com.data.LoggerClass;


public class HomePageLogo {

	
	@FindBy(xpath = "//button[text()='See the action']")
	public WebElement TruckLogo;
	
	public HomePageLogo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void homePageLogoSteps(CommonMethods cm) {
		
		if(cm.isElementDisplayable(TruckLogo)) {
			LoggerClass.logger.log(Level.INFO,"Elements is Displable");
			System.out.println("Elements is Displable");
		} else if(cm.isElementEnable(TruckLogo)) {
			LoggerClass.logger.log(Level.INFO,"Elements is Enable");
			System.out.println("Elements is Enable");
		} else if(cm.isElementSelectable(TruckLogo)) {
			LoggerClass.logger.log(Level.INFO,"Elements is Selectable");
			System.out.println("Elements is Selectable");
		} 
	}
	
		
}

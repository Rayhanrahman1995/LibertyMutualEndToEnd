package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonMethods.CommonMethods;
import com.data.AutoQuoteInfo;

public class AutoQuote1 {

	public AutoQuote1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "zipCode")
	public WebElement Auto;
	@FindBy(xpath = "//button[text()='Get my price']")
	public WebElement GetMyPrice;
	@FindBy(xpath = "//button[@class='lmig-Button lmig-Button--medium lmig-Button--primary']")
	public WebElement Ad;
	@FindBy(xpath = "//input[@name='address']")
	public WebElement StAddress;
	@FindBy(xpath = "(//input[@class='char-10'])[1]")
	public WebElement Apt;
	@FindBy(id = "nextButton-0")
	public WebElement SaveAndContinue;
	
	public void autoQuoteSteps1(CommonMethods cm,AutoQuoteInfo aqi) {
		cm.numericValue(Auto, aqi.getZipCode());
		cm.click(GetMyPrice);
		cm.click(Ad);
		cm.stringValue(StAddress, aqi.getStAddress());
		cm.stringValue(Apt, aqi.getApt());
		cm.click(SaveAndContinue);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

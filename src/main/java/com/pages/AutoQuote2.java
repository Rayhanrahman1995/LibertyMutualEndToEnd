package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonMethods.CommonMethods;


public class AutoQuote2 {

	public AutoQuote2(WebDriver driver) {
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
	
	public void autoQuoteSteps2(CommonMethods cm,int zipCode, String stAddress,String apt) {
		cm.numericValue(Auto, zipCode);
		cm.click(GetMyPrice);
		cm.click(Ad);
		cm.stringValue(StAddress, stAddress);
		cm.stringValue(Apt, apt);
		cm.click(SaveAndContinue);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonMethods.CommonMethods;
import com.data.PersonalInfo;

public class LogInByDataProvider {

	public LogInByDataProvider(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='lm-Icon-label'])[2]")
	public WebElement logIn;
	@FindBy(xpath = "//input[@name='USERNAME']")
	public WebElement UserName;
	@FindBy(xpath = "//input[@name='PASSWORD']")
	public WebElement PassWord;
	@FindBy(xpath = "//button[@class='_2kklYWffdZ_AulwLoTZ5Be']")
	public WebElement Button;

	public void logInByDataProviderSteps(CommonMethods commonMethods, PersonalInfo personalInfo) {
		commonMethods.click(logIn);
		commonMethods.stringValue(UserName, personalInfo.getUserName());
		commonMethods.stringValue(PassWord, personalInfo.getPassWord());
		commonMethods.click(Button);
	}
}

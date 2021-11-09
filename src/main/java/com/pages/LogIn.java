package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonMethods.CommonMethods;

public class LogIn {

	public LogIn(WebDriver driver) {
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

	public void logInSteps(CommonMethods commonMethods, String userName, String passWord) {
		commonMethods.click(logIn);
		commonMethods.stringValue(UserName, userName);
		commonMethods.stringValue(PassWord, passWord);
		commonMethods.click(Button);
	}
}

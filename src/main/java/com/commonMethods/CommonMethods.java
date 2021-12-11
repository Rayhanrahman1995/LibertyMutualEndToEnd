package com.commonMethods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.base.Base;

public class CommonMethods {

	public void dropDownSelectByValue(WebElement element, String value) {
		Select productSelect = new Select(element);
		productSelect.selectByValue(value);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(Base.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void stringValue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void numericValue(WebElement element, int value) {
		element.sendKeys(String.valueOf(value));
	}

	public void click(WebElement element) {
		element.click();
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public void hardAssert(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public void hoverOnly(WebElement element) {
		Actions actions = new Actions(Base.driver);
		actions.moveToElement(element).build().perform();
	}

	public void hoverAndClick(WebElement element) {
		Actions actions = new Actions(Base.driver);
		actions.moveToElement(element).click().perform();
	}

	public String getLibertyMutualTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public boolean isElementDisplayable(WebElement element) {
	return	element.isDisplayed();
	}
	public boolean isElementSelectable(WebElement element) {
	return	element.isSelected();
	}
	public boolean isElementEnable(WebElement element) {
	return	element.isEnabled();
	}
		
}

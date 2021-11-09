package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utils.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	public void loadWebDriverManager() {
		WebDriverManager.chromedriver().setup();
	}

	public void loadDriver() {
		String currentOS = System.getProperty("os.name");
		if (currentOS.startsWith("Win")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir", "/drivers/chromedriver"));
		} else if (currentOS.startsWith("Mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir", "/drivers/chromedriver"));
		}
	}

	@BeforeMethod
	public WebDriver setUpDriver() {
		loadWebDriverManager();
		driver = new ChromeDriver();
		String url = ReadProperties.instanceOfProp().getUrl();
		driver.get(url);
		driver.manage().window().maximize();
		int pageLoadTime = ReadProperties.instanceOfProp().getPageLoadWait();
		int implicitLoadTime = ReadProperties.instanceOfProp().getImplicitWait();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitLoadTime, TimeUnit.SECONDS);
		return driver;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

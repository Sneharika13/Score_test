package com.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.util.Assert;
import org.testng.Assert;
import org.testng.ITestContext;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasePage {

	public static AppiumDriver driver = null;

	private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoxNDEyNTUxMCwieHAucCI6MTQxMjU1MDksInhwLm0iOjE2NDA0MzY0NjkyMTEsImV4cCI6MTk1NTc5NjY5NSwiaXNzIjoiY29tLmV4cGVyaXRlc3QifQ.atNx1wOkOcYkyH7hXyCwsWna62KetCGsFJIIzeql61Y";

	public void openDriver(String platform) throws MalformedURLException {
		if(platform.equalsIgnoreCase("Android"))
			openAndroidDriver();
		else
			openIosDriver();
	}
	// @BeforeSuite
	public void openIosDriver() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		 caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0.1");
		 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
		 caps.setCapability("xcodeOrgId", "WWTMC7WMCD");
		 caps.setCapability("xcodeSigningId", "iphone Developer");
		 caps.setCapability(MobileCapabilityType.UDID, "89b70a8d9e72c6a0642975d633f322f5076e9b9c");
		 caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.fivemobile.thescore"); 
		 URL url = new URL("http://127.0.0.1:4723/wd/hub"); 
		 driver = new IOSDriver(url, caps);
		 
		setDriver(driver);

	}

	public void openAndroidDriver() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0.1");
		  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		  caps.setCapability(MobileCapabilityType.UDID, "0A101JEC218197");
		  caps.setCapability("appPackage","com.fivemobile.thescore"); 
		  caps.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
		 caps.setCapability(MobileCapabilityType.NO_RESET, true);
		  URL url = new URL("http://127.0.0.1:4723/wd/hub"); 
		  driver = new AndroidDriver(url, caps);
		  setDriver(driver);
		 

	}

	public void setDriver(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public AppiumDriver<?> getDriver() {
		return driver;
	}
	
	
	
	public void getContext() {
		Set<String> contexts=driver.getContextHandles();
		System.out.println("Available contexts are ::"+contexts);
	}
	// Verify element displayed
	public boolean isElementDisplayed(String element) {
		boolean flag = false;
		try {
			waitFor(2);
			if (element.startsWith("//")) {

				if (element(element).isDisplayed())
					flag = true;
			} else if (driver.findElement(By.xpath("//*[@value='" + element + "']")).isDisplayed()) {
				System.out.println(element + " is displayed Successfully");
				flag = true;
			}

			System.out.println("Element is displayed Successfully");

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isElementDisplayed(MobileElement element) {
		boolean flag = false;
		try {
			waitFor(2);

			if (element.isDisplayed()) {
				flag = true;

				System.out.println("Element is displayed Successfully");
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public WebElement element(String element) {
		return driver.findElement(By.xpath(element));
	}

	// ClickOn Element
	public void clickonElement(String element) throws InterruptedException {

		try {

			// isElementClickable(element);
			waitFor(2);
			element(element).click();
			waitFor(2);
			// System.out.println("Successfully clicked on "+element.getText());
		} catch (NoSuchElementException e1) {
			Assert.fail();
		}
	}

	public void clickonElement(MobileElement element) throws InterruptedException {

		try {

			// isElementClickable(element);
			waitFor(2);
			element.click();
			waitFor(2);
			// System.out.println("Successfully clicked on "+element.getText());
		} catch (NoSuchElementException e1) {
			Assert.fail();
		}
	}

	// enter Text
	public void enterText(String element, String text) throws InterruptedException {

		try {

			// isElementClickable(element);
			waitFor(2);
			element(element).clear();
			element(element).sendKeys(text);
			waitFor(2);
			// System.out.println("Successfully clicked on "+element.getText());
		} catch (NoSuchElementException e1) {
			Assert.fail();
		}
	}

	public void enterText(MobileElement element, String text) throws InterruptedException {

		try {

			// isElementClickable(element);
			waitFor(2);
			element.clear();
			element.sendKeys(text);
			waitFor(2);
			// System.out.println("Successfully clicked on "+element.getText());
		} catch (NoSuchElementException e1) {
			Assert.fail();
		}
	}

	public void clickOnText(String text) throws InterruptedException {
		try {

			// isElementClickable(element);
			waitFor(2);
			if (getDriver().getPlatformName().equalsIgnoreCase("Android"))
				driver.findElement(By.xpath("//*[@text='" + text + "']")).click();
			else
				driver.findElement(By.xpath("//*[@name='" + text + "']")).click();
			waitFor(2);
			// System.out.println("Successfully clicked on "+element.getText());
		} catch (NoSuchElementException e1) {
			Assert.fail();
		}
	}

	// Validate Element
	public void asserEqual(String element, String message) throws InterruptedException {
		waitFor(2);
		Assert.assertEquals(element(element).getText().trim(), (message).trim());
		System.out.println("Expected Test is :: " + element(element).getText() + " and Actual Text is :: " + message);
	}

	public void asserEqual(MobileElement element, String message) throws InterruptedException {
		try {
			waitFor(2);
			if (element.getText().trim().equalsIgnoreCase(message.trim()))
				System.out.println("Expected Test is :: " + element.getText() + " and Actual Text is :: " + message);
			else
				System.out.println(
						"Wrong------  Expected Test is :: " + element.getText() + " and Actual Text is :: " + message);

		} catch (Exception e) {
			System.out.println(
					"Wrong------  Expected Test is :: " + element.getText() + " and Actual Text is :: " + message);

		}

	}

	// Validate Element
	public void asserContains(String element, String message) throws InterruptedException {
		waitFor(2);
		if (element(element).getText().trim().contains(message.trim())) {
			Assert.assertTrue(true);
			System.out
					.println("Expected Test is :: " + element(element).getText() + " and Actual Text is :: " + message);
		}
	}

	public void asserContains(MobileElement element, String message) throws InterruptedException {
		waitFor(2);
		if (element.getText().trim().contains(message.trim())) {
			Assert.assertTrue(true);
			System.out.println("Expected Test is :: " + element.getText() + " and Actual Text is :: " + message);
		}
	}

	// Wait element to be clickable

	public void waitUntilElementDisply(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.pollingEvery(Duration.ofMillis(300L));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean isElementClickable(String element) {
		try {
			waitUntilElementDisply(element(element));
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	// Sleep the thread
	public void waitFor(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}

	public List<IOSElement> getList(String element) {
		try {
			return driver.findElements(By.xpath(element));
		} catch (Exception e) {

		}
		return null;
	}
	
	public static Object[][] readTestData(String sheetName) {

		XlsReader xls = new XlsReader(System.getProperty("user.dir") + "/src/test/resources/TestData/Scores.xls");
		ArrayList<Integer> NoofIterations = new ArrayList<Integer>();
		for (int rNum = 2; rNum <= xls.getRowCount(sheetName); rNum++) {
				NoofIterations.add(rNum);			
		}
		Object[][] data = new Object[NoofIterations.size()][1];
		for (int i = 0; i < NoofIterations.size(); i++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			for (int cols = 0; cols < 180; cols++) {
				table.put(xls.getCellData(sheetName, cols, 1), xls.getCellData(sheetName, cols, NoofIterations.get(i)));
			}
			data[i][0] = table;
		}
		System.out.println("SheetName is +++" + data);
		return data;
	}	
	// Quit driver
	public void quitDriver() {
		driver.quit();
	}

}

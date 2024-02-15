package appium_project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.Actions;
import pageObjects.Assertions;
import pageObjects.Parameters;

public class MathematicalCalculations extends Parameters {
	Actions action;
	Assertions assertion;

	@BeforeTest
	public void setup() throws MalformedURLException {
		action = new Actions();
		assertion = new Assertions();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "QA_Device");

		// Only for Mobile Application capabilities
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + File.separator + "app" + File.separator + "calculator.apk");
		var appiumServerUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);

		// Only for Mobile browsers capabilities
		// desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
		// "chrome");
		// desiredCapabilities.setCapability("chromedriverExecutable",
		// System.getProperty("user.dir") + File.separator + "drivers" + File.separator
		// + "chromedriver.exe");
	}

	@Test(description = "Subtraction of two numbers", priority = 1)
	public void subtractTestCase() throws InterruptedException {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.SUBTRACT);
		
	}

	@Test(description = "Multiplication of two numbers", priority = 2)
	public void multiplyTestCase() {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.MULTIPLY);
	}
	
	@Test(description = "Power of two numbers", priority = 3)
	public void powerTestCase() {
		action.makeOperationOnTwoNumbers(2, 3, OperationTypeForTwoNumbers.POWER);
	}

	@Test(description = "Summation of two numbers", priority = 4)
	public void addTestCase() {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.ADD);
	}
	
	@Test(description = "Division of two numbers", priority = 5)
	public void divideTestCase() {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.DIVIDE);
	}
	
	@Test(description = "Sqrt of any number", priority = 6)
	public void sqrtTestCase() {
		action.makeOpertionOnOneNumber(16, OperationTypeForOneNumber.SQRT);
	}
	
	@Test(description = "Factorial of any number", priority = 7)
	public void factorialTestCase() throws InterruptedException {
		action.makeOpertionOnOneNumber(3, OperationTypeForOneNumber.FACTORIAL);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}

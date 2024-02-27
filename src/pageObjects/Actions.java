package pageObjects;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Actions extends Parameters {
	public String idBeginningForNumber = "com.google.android.calculator:id/digit_";

	public void calculatorSetup() throws MalformedURLException {
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PixelQA");

		// Only for Mobile Application capabilities
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + File.separator + "app" + File.separator + "calculator.apk");
		var appiumServerUrl = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
		driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);
	}
	
	public int[] convertNumberToArrayOfDigits(int number) {
		// Convert the number to a string
		String numberAsString = String.valueOf(number);

		// Create an array to store each digit
		int[] digitArray = new int[numberAsString.length()];

		// Convert each character back to integer and store in the array
		for (int i = 0; i < numberAsString.length(); i++) {
			digitArray[i] = Character.getNumericValue(numberAsString.charAt(i));
		}
		return digitArray;
	}

	public void clickOnEqual() {
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
	}

	public void makeOperationOnTwoNumbers(int number1, int number2, OperationTypeForTwoNumbers operationType) {

		int[] number1DigitsArray = convertNumberToArrayOfDigits(number1);

		for (int number1Digit : number1DigitsArray) {
			driver.findElement(By.id(idBeginningForNumber + number1Digit)).click();
		}

		switch (operationType) {
		case ADD:
			driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
			break;
		case SUBTRACT:
			driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
			break;
		case MULTIPLY:
			driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
			break;
		case DIVIDE:
			driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
			break;
		case POWER:
			driver.findElement(By.id("com.google.android.calculator:id/op_pow")).click();
			break;
		}

		int[] number2DigitsArray = convertNumberToArrayOfDigits(number2);
		for (int number2Digit : number2DigitsArray) {
			driver.findElement(By.id(idBeginningForNumber + number2Digit)).click();
		}

		clickOnEqual();
	}

	public void makeOpertionOnOneNumber(int number, OperationTypeForOneNumber operationType) {

		int[] digitsOfNumberArray = convertNumberToArrayOfDigits(number);

		switch (operationType) {
		case SQRT:
			driver.findElement(By.id("com.google.android.calculator:id/op_sqrt")).click();
			for (int digit : digitsOfNumberArray) {
				driver.findElement(By.id(idBeginningForNumber + digit)).click();
			}
			break;

		case FACTORIAL:
			for (int digit : digitsOfNumberArray) {
				driver.findElement(By.id(idBeginningForNumber + digit)).click();
			}
			driver.findElement(By.id("com.google.android.calculator:id/op_fact")).click();
			break;
		}

		clickOnEqual();
	}

	public static Double factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
		}

		Double result = 1.0;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public void takeScreenshot(String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationpath = System.getProperty("user.dir") + File.separator + "screenshots" + 
		File.separator +  screenshotName + ".png";
        
        File finalDestination = new File(destinationpath); 
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void closeApp() {
		driver.closeApp();
	}
}

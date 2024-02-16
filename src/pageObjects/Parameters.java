package pageObjects;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Parameters {
	public static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	public static AndroidDriver driver;

	public enum OperationTypeForTwoNumbers {
		ADD, SUBTRACT, MULTIPLY, DIVIDE, POWER
	}

	public enum OperationTypeForOneNumber {
		SQRT, FACTORIAL
	}
}

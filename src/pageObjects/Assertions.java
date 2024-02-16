package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Assertions extends Parameters {

	public void checkResultOfTwoNumbersOpertion(int number1, int number2, OperationTypeForTwoNumbers operationType) {
		Double actualResult = Double
				.parseDouble(driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());

		Double expectedResult = 0.0;
		switch (operationType) {
		case ADD:
			expectedResult = (double) (number1 + number2);
			break;
		case SUBTRACT:
			expectedResult = (double) (number1 - number2);
			break;
		case MULTIPLY:
			expectedResult = (double) (number1 * number2);
			break;
		case DIVIDE:
			expectedResult = ((double) number1 / (double) number2);
			break;
		case POWER:
			expectedResult = Math.pow(number1, number2);
			break;
		}

		Assert.assertEquals(actualResult, expectedResult);
	}

	public void checkResultOfOneNumberOpertion(int number, OperationTypeForOneNumber operationType) {
		Double actualResult = Double
				.parseDouble(driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());

		Double expectedResult = 0.0;
		switch (operationType) {
		case SQRT:
			expectedResult = Math.sqrt(number);
			break;
		case FACTORIAL:
			expectedResult = Actions.factorial(number);
			break;
		}

		Assert.assertEquals(actualResult, expectedResult);
	}
}

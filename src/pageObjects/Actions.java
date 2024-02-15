package pageObjects;

import org.openqa.selenium.By;

public class Actions extends Parameters {
	public String idBeginningForNumber = "com.google.android.calculator:id/digit_";

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
}

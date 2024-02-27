package smokeTest;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
		action.calculatorSetup();
	}

	@Test(description = "Subtraction of two numbers", priority = 1)
	public void subtractTestCase() throws InterruptedException {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.SUBTRACT);
		action.takeScreenshot("Subtraction Result");
		assertion.checkResultOfTwoNumbersOpertion(180, 100, OperationTypeForTwoNumbers.SUBTRACT);
	}

	@Test(description = "Multiplication of two numbers", priority = 2)
	public void multiplyTestCase() {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.MULTIPLY);
		action.takeScreenshot("Multiplication Result");
		assertion.checkResultOfTwoNumbersOpertion(180, 100, OperationTypeForTwoNumbers.MULTIPLY);
	}

	@Test(description = "Sqrt of any number", priority = 3)
	public void sqrtTestCase() {
		action.makeOpertionOnOneNumber(16, OperationTypeForOneNumber.SQRT);
		action.takeScreenshot("Sqrt Result");
		assertion.checkResultOfOneNumberOpertion(16, OperationTypeForOneNumber.SQRT);
	}

	@Test(description = "Power of two numbers", priority = 4)
	public void powerTestCase() {
		action.makeOperationOnTwoNumbers(2, 3, OperationTypeForTwoNumbers.POWER);
		action.takeScreenshot("Power Result");
		assertion.checkResultOfTwoNumbersOpertion(2, 3, OperationTypeForTwoNumbers.POWER);
	}

	@Test(description = "Factorial of any number", priority = 5)
	public void factorialTestCase() throws InterruptedException {
		action.makeOpertionOnOneNumber(3, OperationTypeForOneNumber.FACTORIAL);
		action.takeScreenshot("Factorial Result");
		assertion.checkResultOfOneNumberOpertion(3, OperationTypeForOneNumber.FACTORIAL);
	}

	@Test(description = "Summation of two numbers", priority = 6)
	public void addTestCase() {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.ADD);
		action.takeScreenshot("Summation Result");
		assertion.checkResultOfTwoNumbersOpertion(180, 100, OperationTypeForTwoNumbers.ADD);
	}

	@Test(description = "Division of two numbers", priority = 7)
	public void divideTestCase() {
		action.makeOperationOnTwoNumbers(180, 100, OperationTypeForTwoNumbers.DIVIDE);
//		action.takeScreenshot("Division Result");
		assertion.checkResultOfTwoNumbersOpertion(180, 100, OperationTypeForTwoNumbers.DIVIDE);
	}

	@AfterTest
	public void afterTest() {
		action.closeApp();
	}
}

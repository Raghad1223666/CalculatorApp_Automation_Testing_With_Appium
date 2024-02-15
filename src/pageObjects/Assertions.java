package pageObjects;

import org.openqa.selenium.By;

public class Assertions extends Parameters {
	public void checkResultOfTwoNumbersOpertion(int number1, int number2, OperationTypeForTwoNumbers operationType) {

		System.out.println(driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"No formula\"]")));
	}
}

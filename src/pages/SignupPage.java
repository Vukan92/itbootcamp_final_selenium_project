package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	private WebDriver driver;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameInput() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInput() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getConfirmPasswordInput() {
		return driver.findElement(By.id("confirmPassword"));
	}

	public WebElement getSignMeUpButton() {
		return driver.findElement(By.xpath(
				"//button[contains(@class, 'v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary')]"));
	}

	public WebElement getSignUpPopUpMessageText() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-snack__content')]/ul/li"));
	}

	public void waitForSignUpPopUpMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack__content')]/ul/li")));

	}
}

package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

	@Test(priority = 10)
	public void visitLoginPage() throws InterruptedException {
		navPage.getLanguageButton().click();
		navPage.getENbutton().click();
		navPage.getLoginButton().click();
		driver.getCurrentUrl().contains("/login");
	}

	@Test(priority = 20)
	public void checkInputTypes() {
		navPage.getLoginButton().click();
		String attributeTypeEmail = loginPage.getEmailInput().getAttribute("type");
		Assert.assertTrue(attributeTypeEmail.equals("email"), "Email attribute type isn't 'mail'");

		String attributeTypePassword = loginPage.getPasswordInput().getAttribute("type");
		Assert.assertTrue(attributeTypePassword.equals("password"), "Password attribute type isn't 'password'");
	}

	@Test(priority = 30)
	public void displayErrorsWhenUserDoesNotExist() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.userDoesntExistPopUp();
		Assert.assertTrue(messagePopUpPage.getVerifyAccountExistsPopUpText().contains("User does not exists"),
				"Message doesn't contain 'User does not exist'");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Current URL doesn't contain '/login'");

	}

	@Test(priority = 40)
	public void displayErrorsWhenPasswordIsWrong() {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitWrongPasswordPopUp();
		Assert.assertTrue(messagePopUpPage.getWrongPasswordPopUpText().contains("Wrong password"),
				"Message doesn't contain 'Wrong password'");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "URL doesn't contain '/login'");

	}

	@Test(priority = 50)
	public void login() throws InterruptedException {
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"), "Current URL doesn't contain '/home'");

	}

	@Test(priority = 60)
	public void logout() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btnLogout')]")));
		navPage.getLogoutButton().click();
	}

}

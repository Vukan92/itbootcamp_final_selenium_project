package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

	@Test(priority = 10)
	public void visistTheSignUpPage() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL route doesn't contain '/signup'");

	}

	@Test(priority = 20)
	public void checkInputTypes() throws InterruptedException {
		navPage.getSignUpButton().click();
		Thread.sleep(2000);
		String emailTextAttribute = signUpPage.getEmailInput().getAttribute("type");
		Assert.assertTrue(emailTextAttribute.equals("email"), "Attribute isn't equal to 'email'");

		String passwordTextttribute = signUpPage.getPasswordInput().getAttribute("type");
		Assert.assertTrue(passwordTextttribute.equals("password"), "Password attribute type isn't 'password'");

		String confirmPasswordTextAttribute = signUpPage.getConfirmPasswordInput().getAttribute("type");
		Assert.assertTrue(confirmPasswordTextAttribute.equals("password"),
				"Confirm password attribute type isn't 'password'");
		Thread.sleep(5000);

	}

	@Test(priority = 30)
	public void displayErrorsWhenUsersAlreadyExists() throws InterruptedException {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL route doesn't contain '/signup'");
		signUpPage.getNameInput().sendKeys("Another Use");
		signUpPage.getEmailInput().sendKeys("admin@admin.com");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignMeUpButton().click();
		Thread.sleep(2000);
		String popUpText = signUpPage.getSignUpPopUpMessageText().getText();
		System.out.println(popUpText);

		Assert.assertTrue(popUpText.equals("E-mail already exists"),
				"Pop up message doesn't show 'E-mail already exists'");
		signUpPage.waitForSignUpPopUpMessage();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "URL route doesn't contain '/signup'");

	}

	@Test(priority = 40)
	public void signUp() throws InterruptedException {
		navPage.getSignUpButton().click();
		signUpPage.getNameInput().sendKeys("Vukan Djokic");
		signUpPage.getEmailInput().sendKeys("vukan.djokic@itbootcamp.rs");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignMeUpButton().click();

		navPage.getHomeButton().click();
		messagePopUpPage.waitVerifyPopUp();
		Assert.assertTrue(messagePopUpPage.getVerifyYourAccountPopUpText().contains("IMPORTANT:"),
				"Message doesn't contain 'IMPORTANT: Verify your account'");
		messagePopUpPage.getCloseButton().click();
		navPage.getLogoutButton().click();
	}

}

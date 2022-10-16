package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
	
	@Test(priority = 10)
	public void visitsTheAdminCitiesPageAndListCities() {
		navPage.getSignUpButton().click();
		navPage.getLoginButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"URL doesn't contain the route" + "/admin/cities");

	}

	@Test(priority = 20)
	public void checkInputTypesForCreateOrEditCities() {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitDialogueForEditing();
		String attributeText = citiesPage.getAttributeForCityName().getAttribute("type");
		Assert.assertTrue(attributeText.contains("text"), "Attribute type doesn't contain 'text'");

	}

	@Test(priority = 30)
	public void createNewCity() throws InterruptedException {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitDialogueForEditing();
		citiesPage.getAttributeForCityName().sendKeys("Vukan Djokic's city");
		citiesPage.getSaveButton().click();
		citiesPage.waitForSavedSuccessfully();
		String popUpText = citiesPage.savedSuccessfullyPopUp().getText();
		Assert.assertTrue(popUpText.contains("successfully"), "Pop up doesn't contain 'successfully'");
	}

	@Test(priority = 40)
	public void editCity() throws InterruptedException {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getSearchButton().click();
		citiesPage.getSearchButton().sendKeys("Vukan Djokic's city");
		WebElement searchBox = driver.findElement(By.id("search"));
		searchBox.sendKeys(Keys.ENTER);
		citiesPage.waitTableRowsToBe(1);
		citiesPage.getEditButtonForRow(1).click();
		citiesPage.getEditInput().click();
		driver.findElement(By.id("name")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		citiesPage.getEditInput().sendKeys("Vukan Djokic's city Edit");
		citiesPage.getSaveButton().click();
		citiesPage.savedSuccessfullyPopUp();
		Thread.sleep(5000);
		String popUp = citiesPage.savedSuccessfullyPopUp().getText();
		Assert.assertTrue(popUp.contains("successfully"));

	}

	@Test(priority = 50)
	public void deleteCity() throws InterruptedException {
		navPage.getAdminButton().click();
		navPage.getCitiesButton().click();
		citiesPage.getSearchButton().click();
		citiesPage.getSearchButton().sendKeys("Vukan Djokic's city Edit");
		WebElement searchBox = driver.findElement(By.id("search"));
		searchBox.sendKeys(Keys.ENTER);
		citiesPage.waitTableRowsToBe(1);
		citiesPage.getDeleteButtonForRow(1).click();
		citiesPage.waitDialogueForDeleting();
		citiesPage.getDeleteButton().click();
		messagePopUpPage.waitDeletedSuccefullyPopUp();
		String deletedSuccessfullyText = citiesPage.deletedSuccefullyPopUpText().getText();
		Assert.assertTrue(deletedSuccessfullyText.contains("Deleted"), "Pop up doesn't contain 'deleted'");

	}

}

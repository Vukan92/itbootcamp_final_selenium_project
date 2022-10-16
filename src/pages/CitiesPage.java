package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	
	public CitiesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
	}

	public WebElement getAttributeForCityName() {
		return driver.findElement(By.xpath("//input[contains(@id, 'name')]"));
	}

	public WebElement getSearchButton() {
		return driver.findElement(By.id("search"));
	}

	public void waitDialogueForEditing() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'v-card__title')]")));

	}

	public void waitDialogueForDeleting() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(@class, 'v-card__text body-1 text-body-1 py-3')]")));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath(
				"//button[contains(@class, 'v-btn v-btn--text theme--light v-size--default red--text text--lighten3')]"));
	}

	public void waitTableRowsToBe(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.numberOfElementsToBe(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]/table/tbody"), index));
	}

	public WebElement getTableCellFromRow(int tableRow, int tableColumn) {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]" + "/table/tbody/tr["
				+ tableRow + "]" + "/td[" + (tableColumn + 1) + "]"));
	}

	public WebElement getEditButtonForRow(int tableRow) {
		return driver.findElement(By.xpath(
				"//div[contains(@class, 'v-data-table__wrapper')]/table/tbody/tr[" + tableRow + "]/td/div/button"));
	}

	public WebElement getDeleteButtonForRow(int tableRow) {
		return driver.findElement(By.xpath(
				"//div[contains(@class, 'v-data-table__wrapper')]/table/tbody/tr[" + tableRow + "]/td/div/button[2]"));
	}

	public void waitForSavedSuccessfully() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'v-snack__wrapper v-sheet theme--dark success')]/div")));
	}

	public WebElement savedSuccessfullyPopUp() {
		return driver
				.findElement(By.xpath("//div[contains(@class, 'v-snack__wrapper v-sheet theme--dark success')]/div"));
	}

	public WebElement getEditInput() {
		return driver.findElement(By.id("name"));
	}

	public WebElement deletedSuccefullyPopUpText() {
		return driver
				.findElement(By.xpath("//div[contains(@class, 'v-snack__wrapper v-sheet theme--dark success')]/div"));
	}

}

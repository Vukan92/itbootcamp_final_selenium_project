package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {

	private WebDriver driver;

	public NavPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHomeButton() {
		return driver.findElement(By.xpath("//a[contains(@class, 'btnHome')]"));
	}

	public WebElement getAboutMeButton() {
		return driver.findElement(By.xpath("//a[contains(@class, 'btnAbout')]"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')]"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
	}

	public WebElement getMyProfileButton() {
		return driver.findElement(By.xpath("//a[contains(@class, 'btnProfile')]"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));

	}

	public WebElement getCitiesButton() {
		return driver.findElement(By.linkText("Cities"));
	}

	public WebElement getUsersButton() {
		return driver.findElement(By.linkText("Users"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
	}

	public WebElement getENbutton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'btnEN')]"));
	}

	public WebElement getESbutton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));
	}

	public WebElement getFRbutton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));
	}

	public WebElement getCNbutton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));
	}

	public WebElement getHeaderFromChangedLanguage() {
		return driver.findElement(By.xpath("//div[contains(@class, 'flex xs12 text-xs-center mt-5 mb-3')]/h1"));
	}

}

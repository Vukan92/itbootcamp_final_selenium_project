package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;
import pages.SignupPage;

public abstract class BasicTest {
	
    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected CitiesPage citiesPage;
    protected LoginPage loginPage;
    protected SignupPage signUpPage;
    protected MessagePopUpPage messagePopUpPage;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navPage = new NavPage(driver);
        citiesPage = new CitiesPage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignupPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String timestamp = new SimpleDateFormat(
                "hh_mm_ss_dd_MM_yyyy").format(new Date());

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screen = (TakesScreenshot) driver;
            File screenshot = screen.getScreenshotAs(OutputType.FILE);
            try {
                FileHandler.copy(screenshot, new File(
                        "Screenshots/TestFailure_" + timestamp + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

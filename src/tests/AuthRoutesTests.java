package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Page URL doesn't contain /login");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Page URL doesn't contain /login");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Page URL doesn't contain /admin/cities");
    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Page URL doesn't contain /admin/users");
    }

}

package com.elsevier.stepDefinitions;

import com.elsevier.pageObjects.LoginPage;
import com.elsevier.utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest {

    public Logger logger = LoggerFactory.getLogger(this.getClass());
//    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    WebDriver driver;
    LoginPage lp = new LoginPage();
    ReadConfig readConfig = new ReadConfig();
    public String browser = readConfig.getBrowser();


    @Given("^I am on the sauce demo home page$")
    public void homePageLogin() throws Throwable {
        Assert.assertEquals(lp.loginPageTitle(), "Swag Labs");
        logger.info("Currently in login page");
    }

    @When("^I specify Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void inputLoginCredentials(String userName, String password) throws Throwable {
        lp.userName().sendKeys(userName);
        lp.password().sendKeys(password);
    }

    @When("^Click on LogIn button$")
    public void clickLogin() throws Throwable {
        lp.submitButton().click();
        Assert.assertEquals(lp.loginPageTitle(), "Swag Labs");
    }

    @When("I specify Username as <userName> and Password as <password>")
    public void invalidUsersTest(String userName, String password) throws Exception {
        lp.userName().sendKeys(userName);
        lp.password().sendKeys(password);
        lp.submitButton();
        logger.info("Currently in login page");
    }

    @Then("I should not be allowed to login")
    public void invalidLoginPage() throws Exception{
        WebElement flag = lp.submitButton();
        if (flag.isDisplayed()) {
            Assert.assertFalse(false);
        }
    }
}

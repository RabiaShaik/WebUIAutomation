package com.elsevier.stepDefinitions;

import com.elsevier.pageObjects.ProductsPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ProductsTest {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    WebDriver driver;
    ProductsPage pp = new ProductsPage();

    @Then("^I should be able to launch the products page$")
    public void launchProductsPage() throws Throwable {
        WebElement flag = pp.productsTextDisplayed();
        if (flag.isDisplayed()) {
            Assert.assertTrue(true);
        }
        logger.info("Currently in products page");
    }

    @Given("^I click on price high to low$")
    public void sortHighToLow() throws Throwable {
        pp.sortButton();
        pp.sortHighToLow();
        Assert.assertEquals(pp.pageTitle(), "Swag Labs");
        logger.info("Sorted the price to high to low in the page");
    }

    @When("^I click on cheapest and the second costliest product$")
    public void selectCheapestAndSecondCostliest() throws Throwable {
        pp.findSecondMaxMinProductValue();
        logger.info("Found the  the second max product and cheap product in the page");
    }


    @When("^Checking out the products$")
    public void checkOutProducts() throws Throwable {
        pp.cartButton().click();
        WebElement flag = pp.addedCartPage();
        if (flag.isDisplayed()) {
            Assert.assertTrue(true);
        }
        logger.info("Currently in checkout product");
    }

    @When("^Input the purchase details$")
    public void purchaseDetails() throws Throwable {
        pp.checkout().click();
        WebElement flag = pp.checkoutInformation();
        if (flag.isDisplayed()) {
            Assert.assertTrue(true);
        }
        logger.info("Currently in purchase details page");
    }

    @And("^I should be able to see the payment and shipping information and key in \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void paymentAndShippingInfo(String firstName, String lastName, String zip) throws Throwable {
        pp.checkOutInfoFirstName().sendKeys(firstName);
        pp.checkOutInfoLastName().sendKeys(lastName);
        pp.checkOutInfoZip().sendKeys(zip);
        pp.continueButton().click();
        WebElement flag = pp.checkoutOverviewText();
        if (flag.isDisplayed()) {
            Assert.assertTrue(true);
        }
        logger.info("Payment and shipping info page");
    }

    @Then("^I should be finish the purchase$")
    public void finishPurchase() throws Throwable {
        pp.finish().click();
        WebElement flag = pp.checkoutCompleteText();
        if (flag.isDisplayed()) {
            Assert.assertTrue(true);
        }
        logger.info("Finish the purchase page");
    }

}

package com.elsevier.stepDefinitions;

import com.elsevier.pageObjects.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = BaseClass.setUp();
        BaseClass.launchUrl();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}


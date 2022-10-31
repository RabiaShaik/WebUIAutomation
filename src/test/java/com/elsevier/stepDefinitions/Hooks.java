package com.elsevier.stepDefinitions;

import com.elsevier.pageObjects.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void beforeScenario() throws IOException {
        driver = BaseClass.setUp();
        BaseClass.launchUrl();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}


package com.elsevier;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "classpath:Features",
        glue = {"com.elsevier.stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "timeline:target/test-output-thread/",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"
        },
        tags = "@smoke",
        dryRun = false,
        monochrome = true
)

@Test
public class RunCukesTest extends AbstractTestNGCucumberTests {

}


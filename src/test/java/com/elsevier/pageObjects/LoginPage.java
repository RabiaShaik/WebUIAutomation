package com.elsevier.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement userName() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement password() {
        return driver.findElement(By.id("password"));
    }

    public WebElement submitButton() {
        return driver.findElement(By.id("login-button"));
    }

    public String loginPageTitle() {
        return driver.getTitle();
    }
}

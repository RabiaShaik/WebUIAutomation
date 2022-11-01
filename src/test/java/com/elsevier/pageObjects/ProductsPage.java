package com.elsevier.pageObjects;

import com.elsevier.utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.*;

public class ProductsPage extends BaseClass {

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement cartButton() throws Exception {
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    }

    public WebElement sortButton() throws Exception {
        return driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    }

    public void sortHighToLow() throws Exception {
        Select selectCategory = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selectCategory.selectByValue("hilo");
        Wait.untilPageReadyState(driver, Duration.ofSeconds(45));
    }

    public WebElement productsTextDisplayed() throws Exception {
        return driver.findElement(By.xpath("//span[@class='title']"));
    }

    public void findSecondMaxMinProductValue() throws Exception {
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
        int cartSize = addToCartButtons.size();
        addToCartButtons.get(0).click();
        addToCartButtons.get(cartSize-1).click();
    }

    public void findSecondMaxValueProduct() throws Exception {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
            Map<WebElement, Double> map = new HashMap<WebElement, Double>();
            try{
                for(int i = 0; i < prices.size(); i++) {
                    if (prices.get(i).getText() != "") {
                        map.put(prices.get(i), Double.parseDouble(prices.get(i).getText().replaceAll("\\$", "")));
                    }
                }

                    for(Map.Entry m :map.entrySet()) {
                        System.out.println(m.getKey()+ " "+m.getValue());
                    }

                List<Map.Entry<WebElement, Double>> listEntry = new ArrayList<Map.Entry<WebElement,Double>>(map.entrySet());
                listEntry.sort(Map.Entry.comparingByValue());

                for(Map.Entry m : listEntry){
                    System.out.println("Max Prices....... " + m.getKey()+ " "+m.getValue());
                }

                listEntry.get(listEntry.size()-2).getKey().click();
                Thread.sleep(5000);

        } catch (NumberFormatException ex){
            System.out.println("This is the exception occurred" + ex);
        }
    }


    public void findMinValueProduct() throws Exception {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        Map<WebElement, Double> map = new HashMap<WebElement, Double>();
        try{
            for(int i = 0; i < prices.size(); i++) {
                if (prices.get(i).getText() != "") {
                    map.put(prices.get(i), Double.parseDouble(prices.get(i).getText().replaceAll("\\$", "")));
//                        map.put(prices.get(i), Integer.parseInt(prices.get(i).getText().replaceAll("\\$", "")));
                }
            }

            for(Map.Entry m :map.entrySet()) {
                System.out.println(m.getKey()+ " "+m.getValue());
            }

            List<Map.Entry<WebElement, Double>> listEntry = new ArrayList<Map.Entry<WebElement,Double>>(map.entrySet());
            listEntry.sort(Map.Entry.comparingByValue());

            for(Map.Entry m : listEntry){
                System.out.println("Min Prices....... " + m.getKey()+ " "+m.getValue());
            }

//            listEntry.get(0).getKey().click();
            WebElement testWE = listEntry.get(0).getKey();
;//            WebElement element = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[2]/div/text()[2]//following::button[@class='btn btn_primary btn_small btn_inventory']"));
            WebElement element = driver.findElement(By.xpath("listEntry.get(0)//following::button[@class='btn btn_primary btn_small btn_inventory']"));
            element.click();
            Thread.sleep(5000);

        } catch (NumberFormatException ex){
            System.out.println("This is the exception occurred" + ex);
        }
    }

    public WebElement addToCart() throws Exception {
        return driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
    }

    public WebElement checkAddCart() throws Exception {
        return driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
    }

    public WebElement addedCartPage() throws Exception {
        return driver.findElement(By.xpath("//span[@class='title']"));
    }

    public WebElement checkout() throws Exception {
        return driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button']"));
    }

    public WebElement checkoutInformation() throws Exception {
        return driver.findElement(By.xpath("//span[@class='title']"));
    }

    public WebElement checkOutInfoFirstName() throws Exception {
        return driver.findElement(By.xpath("//input[contains(@id,'first-name')]"));
    }

    public WebElement checkOutInfoLastName() throws Exception {
        return driver.findElement(By.xpath("//input[contains(@id,'last-name')]"));
    }

    public WebElement checkOutInfoZip() throws Exception {
        return driver.findElement(By.xpath("//input[contains(@id,'postal-code')]"));
    }

    public WebElement continueButton() throws Exception {
        return driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']"));
    }

    public WebElement checkoutOverviewText() throws Exception {
        return driver.findElement(By.xpath("//span[@class='title']"));
    }

    public WebElement finish() throws Exception {
        String html = driver.getPageSource();
        return driver.findElement(By.cssSelector("#finish"));
    }

    public WebElement checkoutCompleteText() throws Exception {
        return driver.findElement(By.xpath("//img[@alt='Pony Express']"));
    }

    public String pageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        return actualTitle;
    }
}

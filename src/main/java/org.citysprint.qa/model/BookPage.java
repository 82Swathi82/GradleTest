package org.citysprint.qa.model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.citysprint.qa.defaults.Defaults;
import org.citysprint.qa.locators.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage {
 WebDriver driver;

    public BookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getURL(){
        driver.get(Defaults.AppUrl);
        WebElement accept = driver.findElement(By.id(locators.acceptButton));
        accept.click();
    }

    public void typeBook(String book) throws InterruptedException {
        WebElement textBox = driver.findElement(By.id(locators.searchInput));
        textBox.sendKeys(book);
        textBox.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
    }

}

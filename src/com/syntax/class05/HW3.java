package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW3 {
    public static String url = "https://www.ebay.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement categoriesDD = driver.findElement(By.xpath("//select[contains(@aria-label, 'Select')]"));
        Select select = new Select(categoriesDD);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String optionText = option.getText();
            System.out.println(optionText);
        }
        select.selectByVisibleText("Computers/Tablets & Networking");
        WebElement search = driver.findElement(By.id("gh-btn"));
        search.click();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath("//span[@class ='b-pageheader__text']"));
        String actualHeader = header.getText();
        String expectedHeader = "Computers, Tablets & Network Hardware";
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header is correct");
        } else {
            System.out.println("Header is incorrect");
        }
        driver.quit();
    }
}

package com.syntax.review01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumReviewBasic {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drvr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
//        WebElement username = driver.findElement(By.id("userName"));
//        username.sendKeys("akbarakedabra");
//        username.clear();
//        username.sendKeys("fire");

        WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
        username.sendKeys("hellothere");


    }
}
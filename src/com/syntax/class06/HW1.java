package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {
    /**
     * Navigate to https://syntaxprojects.com/bootstrap-iframe.php
     * verify the header text Sorry, We Couldn't Find Anything For “Asksn” is displayed
     * verify enroll today button is enabled
     */
    public static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame("FrameOne");
        WebElement header = driver.findElement(By.xpath("//h1[@class ='heading-13']"));
        boolean headerDisplayed = header.isDisplayed();
        if (headerDisplayed) {
            System.out.println("Sorry, We Couldn't Find Anything For “Asksn” is displayed");
        } else {
            System.out.println("header is not displayed");
        }
        driver.switchTo().defaultContent();

        driver.switchTo().frame("FrameTwo");
        WebElement enrollButton = driver.findElement(By.xpath("//div[@class = 'text-block-2' and text() = 'Enroll today']"));
        boolean enrollButtonEnabled = enrollButton.isEnabled();
        if (enrollButtonEnabled) {
            System.out.println("Enroll today button is enabled");
        } else {
            System.out.println("Enroll today button is not enabled");
        }
        driver.quit();
    }
}








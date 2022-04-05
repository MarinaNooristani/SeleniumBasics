package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {
    /**
     * Go to https://syntaxprojects.com/javascript-alert-box-demo.php
     * click on each button and handle the alert accordingly
     */
    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@class ='btn btn-default']"));
        simpleAlertButton.click();
        Alert simpleAlert = driver.switchTo().alert();
        Thread.sleep(2000);
        simpleAlert.accept();

        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@onclick ='myConfirmFunction()']"));
        confirmAlertButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        String confirmAlertText = confirmAlert.getText();
        System.out.println(confirmAlertText);
        Thread.sleep(2000);
        confirmAlert.dismiss();

        WebElement promptAlertButton = driver.findElement(By.xpath("//button[@onclick ='myPromptFunction()']"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello");
        Thread.sleep(2000);
        promptAlert.accept();
        driver.quit();
    }
}





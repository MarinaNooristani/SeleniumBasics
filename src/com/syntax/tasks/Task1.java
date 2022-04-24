package com.syntax.tasks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Task1 {
    /**
     * TC 1: HRMS blank password validation
     * Navigate to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
     * Enter valid username and leave password field empty
     * Click on login button
     * Verify error message with text “Password cannot be empty” is displayed
     * Take a screenshot before quitting the browser
     */
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Navigate to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
        driver.get(url);
        //Enter valid username and leave password field empty
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        //Click on login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //Verify error message with text “Password cannot be empty” is displayed
        WebElement errorMSG = driver.findElement(By.xpath("//span[starts-with(text(), 'Password cannot')]"));
        String errorMSGText = errorMSG.getText();
        String actualText = "Password cannot be empty";
        if (errorMSGText.equals(actualText)) {
            System.out.println(" \"Password cannot be empty\" is diplayed");
        } else {
            System.out.println("Something went wrong");
        }
        //Take a screenshot before quitting the browser
        TakesScreenshot ts=(TakesScreenshot) driver;
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/SmartBear/syntaxtech.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

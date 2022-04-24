package com.syntax.tasks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Task3 {
    /**
     * Navigate to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
     * Enter valid username and wrong password
     * Click on login button
     * Verify error message with text “Invalid credentials” is displayed
     * Take a screenshot before quitting the browser
     */
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //Enter valid username and wrong password
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("1234");
        //Click on login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //Verify error message with text “Invalid credentials” is displayed
        WebElement errorMSG = driver.findElement(By.xpath("//span[starts-with(text(), 'Invalid')]"));
        String errorMSGText = errorMSG.getText();
        String actualText = "Invalid credentials";
        if (errorMSGText.equals(actualText)) {
            System.out.println("\"Invalid credentials\" is displayed");
        } else {
            System.out.println("Oops!!!");
        }
        //Take a screenshot before quitting the browser
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/SmartBear/syntaxtech3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

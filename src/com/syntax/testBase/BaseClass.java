package com.syntax.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    /**
     * method to open a browser
     * method to close browser
     */

    /**
     * javadoc:you're having a description about what actions this method is performing
     */

    /**
     * this method will navigate to a website by the given url --> javadoc
     *
     * @param url
     */
    public static void openWithSpecificUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * this method will quit an open browser
     */
    public static void tearDown() {
        if (driver != null) {//because sometimes it will throw a nullPointerException to avoid that exception we need an if block
            driver.quit();
        }
    }
}
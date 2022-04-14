package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /**
     * Go to https://demoqa.com/browser-windows
     * click on New Tab and print the text from new tab in the console
     * click on New Window and print the text from new window in the console
     * click on New Window Message and print the text from new window in the console
     * Verify (compare) the titles for each page
     * Print out the title of the all pages
     */
    public static String url = "https://demoqa.com/browser-windows";
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //step 1
        String mainPageHandle = driver.getWindowHandle();
        //step 2
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));
        WebElement windowMsgButton = driver.findElement(By.id("messageWindowButton"));
        //step3
        tabButton.click();
        windowButton.click();
        windowMsgButton.click();
        //step4
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {
            String handle = it.next();
            driver.switchTo().window(handle);
            if (!mainPageHandle.equals(handle)) {
                String text = driver.findElement(By.cssSelector("body")).getText();
                System.out.println(text);
            }
            String title = driver.getTitle();
            if (!title.isEmpty()) {
                System.out.println(title);
            } else {
                System.out.println("title is empty");
            }

        }
    }
}

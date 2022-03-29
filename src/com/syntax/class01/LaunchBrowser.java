package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");//built in value, path, for windows add extension .exe, you can use \\

        WebDriver driver = new ChromeDriver();//launch browser
        driver.get("https://www.google.com/");//navigate to the actual browser

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);

        driver.quit();
    }
}

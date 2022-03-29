package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        //selenium is a tool that we integrate with java we can only use selenium with the web application

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();//it will launch the browser only once

        driver.get("https://www.facebook.com/");
        driver.navigate().to("https://www.google.com/");

        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(2000);//add InterruptedException to method signature for compile time error
        //this method is not recommended just used to pause the execution (for 2 secs)
        driver.navigate().refresh();

        //there is a slight difference between close and quit
        driver.close();//will close the current/active tab
        driver.quit();//will quit the whole browser


    }
}

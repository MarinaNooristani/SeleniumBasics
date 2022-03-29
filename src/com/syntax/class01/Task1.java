package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {
        /**
         * 1. launch the browser
         * 2. navigate to amazon website
         * 3. print out the title and the url in the console
         * 4. close the browser
         */
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");//set the property

        WebDriver driver = new ChromeDriver();// launch the browser
        driver.get("https://www.amazon.com/");//navigate to amazon website

        String url = driver.getCurrentUrl();

        String title = driver.getTitle();

        System.out.println(title + " " + url);//print out the title and the url in the console

        driver.quit();//close the browser


    }
}

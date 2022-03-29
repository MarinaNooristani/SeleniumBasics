package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW2 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to fb.com
         * click on create new account
         * fill up all the textboxes
         * click on sign up button
         * close the pop up
         * close the browser
         */
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://fb.com/");
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Jimmy");
        driver.findElement(By.name("lastname")).sendKeys("Escobar");
        driver.findElement(By.name("reg_email__")).sendKeys("jimmy@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("jimmy@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("23457");
        Thread.sleep(2000);
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("img[src $='geKiQnSG-.png']")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}

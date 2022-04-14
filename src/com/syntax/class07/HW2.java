package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HW2 {
    /**
     * navigate to http://www.uitestpractice.com/Students/Contact
     * click on the link
     * get text
     * print out in the console
     */
    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement ajaxLink = driver.findElement(By.linkText("This is a Ajax link"));
        ajaxLink.click();
        WebElement ajaxText = driver.findElement(By.xpath("//div[@class = 'ContactUs']/p"));
        System.out.println(ajaxText.getText());
        driver.quit();

    }
}

package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);//by index
        WebElement textbox = driver.findElement(By.id("name"));
        textbox.sendKeys("Batch 12 Forever!!!");

        driver.switchTo().defaultContent();//switch the focus back

        WebElement alertButton = driver.findElement(By.id("alert"));
        Thread.sleep(2000);
        alertButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.switchTo().frame("iframe_a");//by id or name
        textbox.clear();
        textbox.sendKeys("we are back to frame");

        driver.switchTo().defaultContent();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
        driver.switchTo().frame(frameElement);//by WebElement
        textbox.clear();
        textbox.sendKeys("Hold your horses");
    }
}

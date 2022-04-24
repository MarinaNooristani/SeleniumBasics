package com.syntax.class11;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExecutorDemo3 {

    public static String url = "http://google.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();//focus is on driver

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.open('http://amazon.com');"); // opens a new tab and navigates to amazon
        //window.open(); -- open a blank tab

        driver.get(url);



        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("asdfasdfasfafasfasfafdaf");
        //we're visually on the amazon page but our focus is still on the Google page so that's why we can send keys to the search bar
        driver.get("https://www.facebook.com/");

    }

}

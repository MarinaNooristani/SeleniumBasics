package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClearCommand {
   public static void main(String[] args) throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
      //we store this inside a variable for reusability
      WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));//WebElement is a datatype
      username.sendKeys("Tester");
      WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
      password.sendKeys("test");
      WebElement loginButton = driver.findElement(By.name("ctl00$MainContent$login_button"));

      Thread.sleep(2000);
      username.clear();
      password.clear();
      driver.quit();
   }


}

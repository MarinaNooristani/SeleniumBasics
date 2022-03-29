package com.syntax.class02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW1 {
    public static void main(String[] args) {
        /**
         * https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
         * fill out the form
         * click on register
         * close the browser
         */
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.name("customer.lastName")).sendKeys("Yaman");
        driver.findElement(By.name("customer.address.street")).sendKeys("Street16");
        driver.findElement(By.id("customer.address.city")).sendKeys("San francisco");
        driver.findElement(By.id("customer.address.state")).sendKeys("California");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("24256");
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("112-456-6578");
        driver.findElement(By.id("customer.ssn")).sendKeys("123142425");
        driver.findElement(By.id("customer.username")).sendKeys("yaman12");
        driver.findElement(By.id("customer.password")).sendKeys("459812");
        driver.findElement(By.id("repeatedPassword")).sendKeys("459812");
        driver.findElement(By.className("button")).click();
        driver.quit();
    }
}

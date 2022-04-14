package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW2 {
    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createAccount = driver.findElement(By.xpath("//a[text() = 'Create New Account']"));
        createAccount.click();
        Thread.sleep(1000);
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("John");
        WebElement surName = driver.findElement(By.xpath("//input[@name='lastname']"));
        surName.sendKeys("Smith");
        WebElement emailOrPhone = driver.findElement(By.cssSelector("input[name = 'reg_email__']"));
        emailOrPhone.sendKeys("+905674921209");
        WebElement password = driver.findElement(By.cssSelector("input[name = 'reg_passwd__']"));
        password.sendKeys("3124");
        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        selectDay.selectByVisibleText("21");
        Thread.sleep(1000);
        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        selectMonth.selectByVisibleText("Aug");
        Thread.sleep(1000);
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        selectYear.selectByVisibleText("1989");
        Thread.sleep(1000);
        List<WebElement> gender = driver.findElements(By.xpath("//label[@class = '_58mt']"));
        for (WebElement g :
                gender) {
            String text = g.getText();
            if (text.equals("Male")) {
                g.click();
                break;
            }
        }
        Thread.sleep(2000);
        WebElement signUp = driver.findElement(By.name("websubmit"));
        signUp.click();
        Thread.sleep(2000);
        driver.quit();
    }
}

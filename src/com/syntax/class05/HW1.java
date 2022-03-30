package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW1 {
    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement createAccount = driver.findElement(By.xpath("//a[text() = 'Create New Account']"));
        createAccount.click();
        Thread.sleep(2000);
        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        List<WebElement> allOptionsMonth = selectMonth.getOptions();
        int monthSize = allOptionsMonth.size();
        if (monthSize == 12) {
            System.out.println("month dd has " + monthSize + " month options");
        } else {
            System.out.println("month dd doesn't have 12 month options");
        }
        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        List<WebElement> allOptionsDay = selectDay.getOptions();
        int daySize = allOptionsDay.size();
        if (daySize == 31) {
            System.out.println("day dd has " + daySize + " day options");
        } else {
            System.out.println("day dd doesn't have 31 day options");
        }
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> allOptionsYear = selectYear.getOptions();
        int yearSize = allOptionsYear.size();
        if (yearSize == 115) {
            System.out.println("year dd has " + yearSize + " year options");
        } else {
            System.out.println("year dd doesn't have 115 year options");
        }
        selectDay.selectByVisibleText("15");
        Thread.sleep(2000);
        selectMonth.selectByVisibleText("Mar");
        Thread.sleep(2000);
        selectYear.selectByVisibleText("2000");
        Thread.sleep(2000);
        driver.quit();

    }
}

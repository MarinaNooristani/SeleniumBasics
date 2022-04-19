package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /**
     * Go to aa.com/homePage.do
     * select depart date
     * select return date
     * select destination
     * click on search
     * quit the browser
     */
    public static String url = "https://www.aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //select depart date
        WebElement departbtn = driver.findElement(By.className("ui-datepicker-trigger"));
        departbtn.click();
        WebElement dNextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
        WebElement dMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
        String dMonthText = dMonth.getText();

        while (!dMonthText.equals("September")) {
            dNextButton.click();
            dNextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
            dMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            dMonthText = dMonth.getText();

        }
        List<WebElement> dDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));//not unique
        for (WebElement dDate : dDates) {
            String dDateText = dDate.getText();
            if (dDateText.equals("30")) {
                dDate.click();
                break;
            }
        }
        //select return date
        WebElement returnbtn = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        returnbtn.click();
        WebElement rNextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
        WebElement rMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
        String rMonthText = rMonth.getText();

        while (!rMonthText.equals("December")) {
            rNextButton.click();
            rNextButton = driver.findElement(By.xpath("//a[@data-handler='next']"));
            rMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]"));
            rMonthText = rMonth.getText();

        }
        List<WebElement> rDates = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td"));
        for (WebElement rDate : rDates) {
            String rDateText = rDate.getText();
            if (rDateText.equals("15")) {
                rDate.click();
                break;
            }
        }
        //select destination
        WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
        from.sendKeys("IST");
        WebElement to = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        to.sendKeys("LAX");
        //click on search
        WebElement searchButton = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        searchButton.click();
        //quit the browser
        driver.quit();

    }
}

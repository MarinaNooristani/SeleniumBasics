package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW1 {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        /**
         * Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
         * click on leave
         * click on leave list
         * choose from "From calendar"
         * choose from "To calendar"
         * click only on cancelled and rejected checkboxes
         * uncheck Pending Approval
         * select IT support from DD
         * click search
         * quit the browser
         */
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //log in
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //click on leave
        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();
        //click on leave list
        WebElement leaveListButton = driver.findElement(By.id("menu_leave_viewLeaveList"));
        leaveListButton.click();
        //choose from "From calendar"
        WebElement fromCalender = driver.findElement(By.id("calFromDate"));
        fromCalender.click();

        WebElement fromMonthDD = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(fromMonthDD);
        select.selectByVisibleText("Aug");

        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String fromDateText = fromDate.getText();
            if (fromDateText.equals("26")) {
                fromDate.click();
                break;
            }
        }
        //choose from "To calendar"
        WebElement toCalender = driver.findElement(By.id("calToDate"));
        toCalender.click();

        WebElement toYearDD = driver.findElement(By.className("ui-datepicker-year"));
        select = new Select(toYearDD);
        select.selectByValue("2022");

        WebElement toMonthDD = driver.findElement(By.className("ui-datepicker-month"));
        select = new Select(toMonthDD);
        select.selectByVisibleText("Sep");

        List<WebElement> toDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement toDate : toDates) {
            String toDateText = toDate.getText();
            if (toDateText.equals("7")) {
                toDate.click();
                break;
            }
        }
        //click only on cancelled and rejected checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@name ='leaveList[chkSearchFilter][]']"));
        for (WebElement checkBox : checkBoxes) {
            String checkBoxValue = checkBox.getAttribute("value");
            if (!checkBox.isSelected() && checkBoxValue.equals("-1") || checkBoxValue.equals("0")) {
                checkBox.click();
                //uncheck Pending Approval
            } else if (checkBox.isSelected() && checkBoxValue.equals("1")) {
                checkBox.click();
            }
        }
        //select IT support from DD
        WebElement subUnitDD = driver.findElement(By.id("leaveList_cmbSubunit"));
        select = new Select(subUnitDD);
        select.selectByVisibleText("IT Support");

        //click search
        WebElement searchButton = driver.findElement(By.id("btnSearch"));
        searchButton.click();

        //quit the browser
        driver.quit();

    }
}

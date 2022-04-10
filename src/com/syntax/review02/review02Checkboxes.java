package com.syntax.review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class review02Checkboxes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/basic-checkbox-demo.php");

//        check the check box
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#isAgeSelected"));
        System.out.println("the checkbox is selected " + checkbox1.isSelected());
//        select the checkbox
        checkbox1.click();
        Thread.sleep(3000);
        //task:get the message after checking the checkbox and display it on console
        WebElement textElement = driver.findElement(By.xpath("//div[text()=\"Success - Check box is checked\"]"));
        System.out.println(textElement.getText());
        //        deselect the checkbox
        checkbox1.click();

//        get all the available options
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for (WebElement checkbox : checkBoxes) {
            checkbox.click();
        }
        Thread.sleep(2000);
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
        }


    }
}






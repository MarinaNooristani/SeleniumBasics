package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW1 {
    /**
     * go to https://the-internet.herokuapp.com/dynamic_controls
     * click on checkbox and click on remove
     * verify the text
     * click on enable verify the textbox is enabled
     * enter text and click disable
     * verify the textbox is disabled
     */
    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //click on checkbox
        WebElement checkBox = driver.findElement(By.xpath("//input[@type = 'checkbox']"));
        checkBox.click();
        //and click on remove
        WebElement removeButton = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeButton.click();
        //verify the text
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));
        WebElement textRemove = driver.findElement(By.xpath("//p[@id = 'message']"));
        String getTextRemove = textRemove.getText();
        if (getTextRemove.equals("It's gone!")) {
            System.out.println("The text is correct-->It's gone!");
        } else {
            System.out.println("The text is not correct");
        }
        //click on enable
        WebElement enableButton = driver.findElement(By.xpath("//button[text() ='Enable']"));
        enableButton.click();

        //verify the textbox is enabled
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));
        WebElement textEnable = driver.findElement(By.xpath("//p[@id = 'message']"));
        String getTextEnable = textEnable.getText();
        if (getTextEnable.equals("It's enabled!")) {
            System.out.println("The text is correct-->It's enabled!");
        } else {
            System.out.println("The text is not correct");
        }
        //enter text
        WebElement textBox = driver.findElement(By.xpath("//input[@type = 'text']"));
        textBox.sendKeys("Hey!!!");

        //and click disable
        WebElement disableButton = driver.findElement(By.xpath("//button[text() = 'Disable']"));
        disableButton.click();

        //verify the textbox is disabled
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id = 'message']")));
        WebElement textDisable = driver.findElement(By.xpath("//p[@id = 'message']"));
        String getTextDisable = textDisable.getText();
        if (getTextDisable.equals("It's disabled!")) {
            System.out.println("The text is correct-->It's disabled!");
        } else {
            System.out.println("The text is not correct");
        }

        driver.quit();
    }
}

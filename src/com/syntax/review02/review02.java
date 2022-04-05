package com.syntax.review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class review02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //input[@value='Female' and @name='optradio' and @type='radio']
        //we can use or as well
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
        //check if the radio button female is enabled
        System.out.println("The female radio button is enabled " + femaleButton.isEnabled());
        //check if the radio button female is displayed
        System.out.println("The female radio button is displayed " + femaleButton.isDisplayed());
        //check if the radio button female is selected
        System.out.println("The female radio button is selected " + femaleButton.isSelected());

        if (!femaleButton.isSelected()) {
            femaleButton.click();
        }

        System.out.println("The female radio button is selected " + femaleButton.isSelected());

        //to get all the links in the current webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));//there are more than one web element-->findElements
        for (WebElement link : links) {
            String name = link.getText();
            if (!name.isEmpty()) {
                System.out.println(name);
            }
        }
    }
}

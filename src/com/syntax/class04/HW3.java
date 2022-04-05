package com.syntax.class04;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW3 {
    public static void main(String[] args) {
        /**
         * HRMS Application Negative Login:
         * Open Chrome browser
         * Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
         * Enter valid username
         * Leave password field empty
         * Click on login button
         * Verify error message with text “Password cannot be empty” is displayed.
         */

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        username.sendKeys("Admin");
        WebElement login = driver.findElement(By.cssSelector("input#btnLogin"));
        login.click();

        WebElement errorMessage = driver.findElement(By.xpath("//span[text() = 'Password cannot be empty']"));
        boolean errorMessageIsDisplayed = errorMessage.isDisplayed();

        if (errorMessageIsDisplayed) {
            System.out.println("This error message is displayed --> Password cannot be empty");
        } else {
            System.out.println("Error message is not displayed");
        }
        driver.quit();
    }
}

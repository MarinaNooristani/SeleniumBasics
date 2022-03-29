package com.syntax.class04;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement login = driver.findElement(By.cssSelector("input#btnLogin"));
        login.click();
        WebElement syntaxLogo = driver.findElement(By.cssSelector("img[src $='syntax.png']"));
        boolean syntaxLogoIsDisplayed = syntaxLogo.isDisplayed();
        if (syntaxLogoIsDisplayed) {
            System.out.println("displayed");
        } else {
            System.out.println("not displayed");
        }
        driver.quit();
    }
}


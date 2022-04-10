package com.syntax.class08;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5)) // look for an element every 5 seconds
                .ignoring(NoSuchElementException.class); // ignores the exception mentioned in the given time
        //ignores the NoSuchElementException, and it will not show it in the console
        //these methods are optional
        //this exception will not occur inside that 20 secs and if it passes that 20 secs it will throw this exception if it exists
        //NoSuchElementException-->when the locator is incorrect
    }
}
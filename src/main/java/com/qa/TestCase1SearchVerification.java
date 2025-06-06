package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class TestCase1SearchVerification {

    public static void main(String[] args) {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.amazon.in/");

            // Search for "Laptop"
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("Laptop");
            searchBox.submit();

            // Use explicit wait instead of Thread.sleep
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")
            ));

            // Collect product titles
            List<WebElement> searchResults = driver.findElements(
                By.cssSelector("span.a-size-medium.a-color-base.a-text-normal")
            );

            if (searchResults.size() > 0) {
                System.out.println("Search results appeared: PASS");
            } else {
                System.out.println("Search results did not appear: FAIL");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3AppleFormValidation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.apple.com/shop/buy-iphone");

           
            Thread.sleep(3000);

            driver.findElement(By.xpath("//span[text()='iPhone 15']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//span[contains(text(),'Blue')]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//span[contains(text(),'128GB')]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//label[contains(.,'No trade-in')]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
            Thread.sleep(3000);

            boolean isZipVisible = driver.findElement(By.id("zipcode")).isDisplayed();

            if (isZipVisible) {
                System.out.println("Pin code input is visible.");
            } else {
                System.out.println("Pin code input is NOT visible.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework3Tests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssTest() {
        //1.
        driver.findElement(By.cssSelector("#bar-notification"));
        //2.
        driver.findElement(By.cssSelector(".header-logo"));
        //3.
        driver.findElement(By.cssSelector("[href=\"/computers\"]"));
        //4.
        driver.findElement(By.cssSelector("[href*='ish']"));
        //5.
        driver.findElement(By.cssSelector("[href^='/wish']"));
        //6.
        driver.findElement(By.cssSelector("[href$='list']"));
        //7.
        driver.findElement(By.cssSelector("[style='width: 50%']"));
        //8.  title="Show details for Simple Computer"
        driver.findElement(By.cssSelector("[title*='details']"));
        //9.
        driver.findElement(By.cssSelector("[title^='/Show']"));
        //10.
        driver.findElement(By.cssSelector("[title$='Computer']"));
    }

    @Test
    public void findElementByXpath() {
        //1.
        driver.findElement(By.xpath("//div[@id='bar-notification']"));
        //2.
        driver.findElement(By.xpath("//div[@class='header-logo']"));
        //3.
        driver.findElement(By.xpath("//*[@href='/computers']"));
        //4. [href*='ish']
        driver.findElement(By.xpath("//*[contains(@href, 'ish')]"));
        //5. [href^='/wish']
        driver.findElement(By.xpath("//*[starts-with(@href, '/wish')]"));
        //6. [href$='list']
        driver.findElement(By.xpath("//*[substring(@href, string-length(@href) - string-length('list') + 1) = 'list']"));
        //7. [style='width: 50%']
        driver.findElement(By.xpath("//*[@style='width: 50%']"));
        //8. [title="Show details for Simple Computer"]
        driver.findElement(By.xpath("//*[@title='Show details for Simple Computer']"));
        //9. Don't work
        driver.findElement(By.cssSelector("[title^='/Show']"));
        //10. Don't work
        driver.findElement(By.cssSelector("[title$='Computer']"));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
}

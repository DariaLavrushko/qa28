package com.ait.qa28;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/register']"))) {
            driver.findElement(By.cssSelector("[href='/logout']")).click();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        driver.findElement(By.cssSelector("[href='/register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Daria");
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Lavrushko");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("dary@gmail.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Newpas1234$");
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Newpas1234$");
        driver.findElement(By.id("register-button")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}

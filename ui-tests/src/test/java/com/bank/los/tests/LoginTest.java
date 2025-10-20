package com.bank.los.tests;

import com.bank.los.core.ui.DriverFactory;
import com.bank.los.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


@Listeners({ io.qameta.allure.testng.AllureTestNg.class, com.bank.los.listeners.TestListener.class })

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    @Description("Verify that valid user can login successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Functionality")
    public void validLoginTest() {
        new LoginPage(driver).login("tomsmith", "SuperSecretPassword!");
        boolean loggedIn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.id("flash"), "You logged into a secure area!"));
        Assert.assertTrue(loggedIn, "Login failed!");
    }

    @Test
    @Description("Force a test failure to validate screenshot attachment")
    public void failForScreenshot() {
        DriverFactory.getDriver().get("https://www.google.com");
        Assert.fail("Intentional failure for screenshot validation");
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }
}

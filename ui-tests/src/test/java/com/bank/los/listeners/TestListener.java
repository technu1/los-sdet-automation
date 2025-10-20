package com.bank.los.listeners;

import com.bank.los.core.ui.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String testName = result.getMethod().getMethodName();
                Path destDir = Path.of("ui-tests", "target", "screenshots");
                Files.createDirectories(destDir);
                Path destFile = destDir.resolve(testName + "_" + timestamp + ".png");
                Files.copy(srcFile.toPath(), destFile, StandardCopyOption.REPLACE_EXISTING);
    
                // 🔥 Make sure Allure results folder exists
                Path allureDir = Path.of("ui-tests", "target", "allure-results");
                Files.createDirectories(allureDir);
    
                // 🟢 Attach screenshot to Allure correctly
                Allure.addAttachment(
                    "Failure Screenshot",
                    "image/png",
                    new ByteArrayInputStream(Files.readAllBytes(destFile)),
                    ".png"
                );
    
                System.out.println("📸 Screenshot saved and attached: " + destFile.toAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("⚠️ No WebDriver instance found for screenshot.");
        }
    }
    

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}

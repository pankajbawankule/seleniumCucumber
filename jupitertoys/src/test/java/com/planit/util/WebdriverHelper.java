package com.planit.util;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebdriverHelper {
    static {
        getWebDriver();
    }
    public static WebDriver driver;
    public static WebDriver getWebDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/executables/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void takeScreenShot(Scenario scenario){
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        try {
            Thread.sleep(10000);
            File sourcePath = ((TakesScreenshot) WebdriverHelper.driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
            Files.copy(sourcePath, destinationPath);
            Reporter.addScreenCaptureFromPath(destinationPath.toString());
        } catch (Exception e) {
            System.out.println("Exception taking screenshots");
            e.printStackTrace();
        }
    }
}

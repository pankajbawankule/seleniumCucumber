package com.planit.util;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageActions {
    public static WebDriver driver;
    private static WebDriverWait wait;
    static {
        driver = WebdriverHelper.driver;
        wait = new WebDriverWait(driver,60);
    }

    /*private static void highLightElement(By by)throws Throwable{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("arguments[0].setAttribute)('style','border: 6px solid yellow')",waitForExpectedEleent(by));
    }*/

    /*private static ExpectedCondition<WebElement> visibilityOfElementLocated(By by) throws Throwable{
        Thread.sleep(500);
        WebElement element = driver.findElement(by);
        if(element.isDisplayed())
            return (ExpectedCondition<WebElement>) element;
        else
            return null;
    }*/

    private static WebElement waitForExpectedEleent(By by) {
        WebElement element = null;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));;
        return element;
    }

    public static void click(By by){
        waitForExpectedEleent(by).click();
    }

    public static List<WebElement> getMultipleElement(By by) throws Throwable{
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(by);
        return elements;
    }

    public static int getNumberOfElements(By by) throws Throwable{
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }
    public static String getText(By by){
        return waitForExpectedEleent(by).getText();
    }

    public static String getText(WebElement element){
        return element.getText();
    }

    public static void enterText(By by, String inputText){
        waitForExpectedEleent(by).sendKeys(inputText);
    }

    public static void pageScrollDown(){
        ((JavascriptExecutor)driver).executeScript("scroll(0,550)");
    }

    public static boolean isElementPresent(By by){
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));;
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void waitForPageLoad(){
        ExpectedCondition<Boolean> pageloadCondition = new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver,40);
        wait.until(pageloadCondition);
    }

}

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MyExecutor {
    JavascriptExecutor jse;
    PropertyFilesReader propertyReader;
    WebDriverWait wait;
    public MyExecutor(WebDriver driver, PropertyFilesReader propertyReader, int timeout) {
        this.propertyReader = propertyReader;
        jse = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, timeout);
    }
    public void click(WebElement webElement){
        jse.executeScript("arguments[0].scrollIntoView()", webElement);
        jse.executeScript("arguments[0].click();", webElement);
    }
    public void wait(String xpath){
        wait.until(visibilityOfElementLocated(By.xpath(propertyReader.getProperty(xpath))));
    }
}

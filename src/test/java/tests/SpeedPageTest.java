package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthAction;
import pages.SpeedPage;
import utils.MyExecutor;
import utils.PropertyFilesReader;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpeedPageTest {
    private PropertyFilesReader propertyReader;
    JavascriptExecutor jse;
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private MyExecutor ex;
    private SpeedPage speedPage;
    private AuthAction authAction;
    private static final int DEFAULT_TIMEOUT = 100;

    @BeforeAll
    void init() {
        propertyReader = new PropertyFilesReader();
        propertyReader.setProp("driver.properties");
        System.setProperty("webdriver.chrome.driver", propertyReader.getProperty("chrome_driver"));
        driver = new ChromeDriver();
        propertyReader.setProp("config.properties");
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        driver.manage().window().maximize();

        actions = new Actions(driver);
        authAction = new AuthAction(driver);
        speedPage = new SpeedPage(driver);
        ex = new MyExecutor(driver, propertyReader, DEFAULT_TIMEOUT);
    }

    @Test
    void testSpeedChecker() throws InterruptedException {
        driver.get(propertyReader.getProperty("speed_page_url"));
        wait.until(visibilityOfElementLocated(By.xpath(propertyReader.getProperty("speedTestStart"))));
        ex.click(speedPage.getSpeedtestStart());
        wait.until(visibilityOfElementLocated(By.xpath(propertyReader.getProperty("speedTestDownload"))));
        String emptyStr = " ";
        WebElement downloadSpeedSpan = driver.findElement(By.xpath(propertyReader.getProperty("speedTestDownload")));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(downloadSpeedSpan, emptyStr)))    ;
        String downloadSpeed = downloadSpeedSpan.getText();

        driver.get(propertyReader.getProperty("fast_page_url"));
        WebElement fastSpan = driver.findElement(By.xpath(propertyReader.getProperty("fast")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"show-more-details-link\"]")));
        String fastSpeed = fastSpan.getText();

        double speedtest = Double.valueOf(downloadSpeed);
        double fasttest = Double.valueOf(fastSpeed);
        System.out.println(speedtest);
        System.out.println(fasttest);

        boolean condition  = false;
        if(Math.abs(speedtest - fasttest)<10) condition = true;
        Assertions.assertEquals(condition, true);

    }
    @Test
    void serverTest() throws InterruptedException{
        driver.get("https://www.speedtest.net/ru/settings");
        wait.until(visibilityOfElementLocated(By.xpath(propertyReader.getProperty("changeServer"))));
        ex.click(speedPage.getDistance());
        ex.click(speedPage.getChangeServer());
        wait.until(visibilityOfElementLocated(By.xpath(propertyReader.getProperty("serverName"))));
        ex.click(speedPage.getServerName());
    }
}

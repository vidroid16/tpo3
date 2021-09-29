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
import pages.AppsPage;
import pages.AuthAction;
import pages.InsightsPage;
import utils.EmailReciver;
import utils.MyExecutor;
import utils.PropertyFilesReader;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InsightsPageTest {
    private PropertyFilesReader propertyReader;
    JavascriptExecutor jse;
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private MyExecutor ex;
    private InsightsPage insightsPage;
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
        insightsPage = new InsightsPage(driver);
        ex = new MyExecutor(driver, propertyReader, DEFAULT_TIMEOUT);
    }

    @Test
    void checkBlog() throws InterruptedException {
        driver.get(propertyReader.getProperty("insights_page_url"));
        ex.wait("subscribeBox");
        insightsPage.inputSubscribeRequest("shaliamydw@gmail.com");
        ex.click(driver.findElement(By.xpath(propertyReader.getProperty("subscribeButton"))));
        ex.wait("searchBox");
        insightsPage.inputSearchRequest("Mobile 5g");
        ex.wait("searchButton");
        ex.click(driver.findElement(By.xpath(propertyReader.getProperty("searchButton"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gh-5ece9f1acdcd67004537089e\"]/span[1]")));
        driver.get(propertyReader.getProperty("insights_page_url"));
    }
    @Test
    void testMail() throws InterruptedException{
        driver.get(propertyReader.getProperty("insights_page_url"));
        ex.wait("subscribeBox");
        insightsPage.inputSubscribeRequest("shalyap3211@gmail.com");
        ex.click(driver.findElement(By.xpath(propertyReader.getProperty("subscribeButton"))));
        String subject = EmailReciver.readEmail();
        Assertions.assertEquals(subject, "Please confirm your subscription to Speedtest Insights");
    }
    @Test
    void checkSearchGlobalIndex() throws InterruptedException{
        driver.get(propertyReader.getProperty("global_index_url"));
        ex.wait("searchGlobalButton");
        ex.click(insightsPage.getSearchGlobalButton());
        ex.wait("searchGlobalBox");
        insightsPage.inputSearchGlobalBox("russia");
        ex.wait("russia");
        ex.click(insightsPage.getRussia());
        Assertions.assertEquals(driver.getCurrentUrl(), propertyReader.getProperty("global_index_russia_url"));
    }
}

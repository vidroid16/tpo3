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
import utils.MyExecutor;
import utils.PropertyFilesReader;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppsPageTest {
    private PropertyFilesReader propertyReader;
    JavascriptExecutor jse;
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private MyExecutor ex;
    private AppsPage appsPage;
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
        appsPage = new AppsPage(driver);
        ex = new MyExecutor(driver, propertyReader, DEFAULT_TIMEOUT);
    }

    @Test
    void headerCheck() throws InterruptedException {
        driver.get(propertyReader.getProperty("apps_page_url"));

        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForAndroid());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_android_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForIos());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_ios_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForMac());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_mac_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForWindows());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_windows_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForChrome());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_chrome_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForCLI());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_cli_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForVpn());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_vpn_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        ex.wait("androidXpath");
        ex.click(appsPage.getSpeedtestForAppletv());
        Assertions.assertEquals(propertyReader.getProperty("apps_page_appletv_url"), driver.getCurrentUrl() );

        ex.click(appsPage.getApps());
        Thread.sleep(3000);
    }
    @Test
    void loginTest() throws InterruptedException{
        driver.get(propertyReader.getProperty("login_page"));
        authAction.inputLoginRequest("shalyaandrey16@gmail.com");
        authAction.inputPasswordRequest("qwerty228");
        wait.until(ExpectedConditions.urlMatches("https://www.speedtest.net/"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/div/div[2]/div[3]/div[1]/a/span[4]")));
        ex.click(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/div/div[2]/div[3]/div[3]/div/div[1]/ul/li[1]/a")));
        WebElement historyResult = driver.findElement(By.xpath("//*[@id=\"results-history-table\"]/tbody/tr[1]/td[3]/div"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"results-history-table\"]/tbody/tr[1]/td[3]/div")));
        double result = Double.valueOf(historyResult.getText());
        System.out.println(result);
        ex.click(driver.findElement(By.xpath("//*[@id=\"results-history\"]/div[3]/div/div/div[1]/div/ul/li[2]/span")));
        ex.click(driver.findElement(By.xpath("//*[@id=\"results-history-table\"]/tbody/tr[1]/td[6]/div[3]/a")));

    }
}

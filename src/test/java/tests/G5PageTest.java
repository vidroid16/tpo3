package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthAction;
import pages.G5Page;
import utils.MyExecutor;
import utils.PropertyFilesReader;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class G5PageTest {
    private PropertyFilesReader propertyReader;
    JavascriptExecutor jse;
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private MyExecutor ex;
    private G5Page g5Page;
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
        g5Page = new G5Page(driver);
        ex = new MyExecutor(driver, propertyReader, DEFAULT_TIMEOUT);
    }

    @Test
    void showCirclesTest() throws InterruptedException {
        driver.get(propertyReader.getProperty("g5_page_url"));

        ex.wait("checkbox1");
        ex.click(g5Page.getCheckbox1());
        ex.wait("checkbox2");
        ex.click(g5Page.getCheckbox2());
        ex.wait("checkbox3");
        ex.click(g5Page.getCheckbox3());
    }
}

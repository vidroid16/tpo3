package pages;

import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class AppsPage {
    WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@id=\"mobile\"]/div/div/div[1]/p[2]/a[1]")
    WebElement SpeedtestForAndroid;

    @FindBy(xpath = "//*[@id=\"mobile\"]/div/div/div[1]/p[2]/a[2]")
    WebElement SpeedtestForIos;

    @FindBy(xpath = "//*[@id=\"desktop\"]/div/div/div[2]/p[2]/a[1]")
    WebElement SpeedtestForWindows;

    @FindBy(xpath = "//*[@id=\"desktop\"]/div/div/div[2]/p[2]/a[2]")
    WebElement SpeedtestForMac;

    @FindBy(xpath = "//*[@id=\"chrome\"]/div/div/div[1]/p[2]/a")
    WebElement SpeedtestForChrome;

    @FindBy(xpath = "//*[@id=\"appletv\"]/div/div/div[2]/p[2]/a")
    WebElement SpeedtestForAppletv;

    @FindBy(xpath = "//*[@id=\"cli\"]/div/div/div[1]/p[2]/a")
    WebElement SpeedtestForCLI;

    @FindBy(xpath = "//*[@id=\"vpn\"]/div/div/div[2]/p[2]/a")
    WebElement SpeedtestForVpn;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/nav/ul/li[1]/a")
    WebElement Apps;

    public AppsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

}

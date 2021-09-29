package pages;

import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class G5Page {
    WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/main/div[2]/div[1]/div/div/div[1]/div[2]/div/table/tr[2]/th/div[1]/label/span")
    WebElement checkbox1;

    @FindBy(xpath = "/html/body/div[2]/div[2]/main/div[2]/div[1]/div/div/div[1]/div[2]/div/table/tr[1]/th/div[1]/label")
    WebElement checkbox2;

    @FindBy(xpath = "/html/body/div[2]/div[2]/main/div[2]/div[1]/div/div/div[1]/div[2]/div/table/tr[3]/th/div[1]/label/span")
    WebElement checkbox3;

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

    public G5Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

}


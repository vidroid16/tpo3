package pages;

import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class SpeedPage {
    WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/div/div[2]/div[3]/div[1]/a")
    WebElement SpeedtestStart;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div/div/div[2]/div[3]/div[3]/div/div[1]/ul/li[2]/a")
    WebElement Settings;

    @FindBy(xpath = "//*[@id=\"closest-server\"]/span/span[2]")
    WebElement ChangeServer;

    @FindBy(xpath = "//*[@id=\"global\"]/div[3]/div[2]/div/label[2]")
    WebElement Distance;

    @FindBy(xpath = "//*[@id=\"find-servers\"]/div/div/ul/li[2]/a")
    WebElement ServerName;





    public SpeedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

}
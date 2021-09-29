package pages;

import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Data
public class InsightsPage {
    WebDriver driver;
    JavascriptExecutor jse = (JavascriptExecutor) driver;


    @FindBy(xpath = "//*[@id=\"search-field\"]")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/div[2]/div/form/button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"email-5a1c0aae-f859-4ce5-9ce1-8700821dd1a8\"]")
    WebElement subscribeBox;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/div[2]/div/form/button")
    WebElement subscribeButton;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div[1]/div[2]/div/a")
    WebElement searchGlobalButton;
    @FindBy(xpath = "//*[@id=\"input-search\"]")
    WebElement searchGlobalBox;
    @FindBy(xpath = "//*[@id=\"react-autowhatever-1--item-0\"]")
    WebElement russia;


    public InsightsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }
    public void inputSearchRequest(String req) {
        searchBox.sendKeys(req);
    }

    public void inputSubscribeRequest(String req) {
        subscribeBox.sendKeys(req);
    }
    public void inputSearchGlobalBox(String req) {
        searchGlobalBox.sendKeys(req);
    }
}

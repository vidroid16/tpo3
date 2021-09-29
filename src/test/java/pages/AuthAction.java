package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class AuthAction {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor-label\"]")
    private WebElement captcha;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement authButton;

    public AuthAction(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void inputLoginRequest(String req) {
        loginInput.sendKeys(req);
    }

    public void inputPasswordRequest(String req) {
        passwordInput.sendKeys(req);
    }
}

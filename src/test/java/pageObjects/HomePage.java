package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class HomePage {

    WebDriver driver;

    @FindBy(id = "my_account")
    private WebElement myAccountButton;
    @FindBy (xpath = "//button[@class='btn btn-primary js-accept gtm_h76e8zjgoo btn-block']")
    private WebElement acceptCookiesButton;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeEmagGeniusAdd;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public LoginPage goToLoginPage(){
        myAccountButton.click();
        return new LoginPage(driver);
    }
    public void removeCookies(){
        getAcceptCookiesButton().click();
        getCloseEmagGeniusAdd().click();
    }
}

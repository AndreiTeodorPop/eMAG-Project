package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

@Getter
public class HomePage {

    WebDriver driver;

    @FindBy(id = "my_account")
    private WebElement myAccountButton;
    @FindBy (xpath = "//button[@class='btn btn-primary js-accept gtm_h76e8zjgoo btn-block']")
    private WebElement acceptCookiesButton;
    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeEmagGeniusAdd;
    @FindBy(id = "searchboxTrigger")
    private WebElement searchBar;
    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;


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

    public SearchTastaturaPage searchProduct(String product){
        searchBar.clear();
        searchBar.sendKeys(product);
        searchButton.click();
        return new SearchTastaturaPage(driver);
    }

    public HomePage validationHomePage(){
       assertEquals("https://www.emag.ro/", driver.getCurrentUrl());
       // assertEquals(driver.getTitle(), "eMAG.ro - Libertate în fiecare zi");
        return this;
    }
}

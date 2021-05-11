package pageObjects;

import lombok.Getter;
import org.openqa.selenium.StaleElementReferenceException;
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
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[1]")
    private WebElement addToCartProduct1;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[2]")
    private WebElement addToCartProduct2;
    @FindBy(xpath = "//button[@class='close gtm_6046yfqs']")
    private WebElement closeSuggestions;
    @FindBy(id = "my_cart")
    private WebElement shoppingBasketButton;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public BasketPage goToBasketPage() {
        shoppingBasketButton.click();
        return new BasketPage(driver);
    }

    public HomePage addProductsToCart() {

        try {
            addToCartProduct1.click();
            closeSuggestions.click();
            addToCartProduct2.click();
            closeSuggestions.click();
            closeSuggestions.click();
        } catch (StaleElementReferenceException ex) {
            addToCartProduct1.click();
            closeSuggestions.click();
            addToCartProduct2.click();
            closeSuggestions.click();
            closeSuggestions.click();
        }
        return this;
    }

    public HomePage clickOnSearchButton(){
        searchButton.click();
        return this;
    }

    public void removeCookies(){
        getAcceptCookiesButton().click();
        getCloseEmagGeniusAdd().click();
    }

    public HomePage writeOnSearchBox(String product){
        searchBar.clear();
        searchBar.sendKeys(product);
        return this;
    }

    public SearchTastaturaPage goToSearchTastaturaPage(){
        searchButton.click();
        return new SearchTastaturaPage(driver);
    }

    public SearchMousePage goToSearchMousePage(){
        searchButton.click();
        return new SearchMousePage(driver);
    }
    public SearchCastiPage goToSearchCastiPage(){
        searchButton.click();
        return new SearchCastiPage(driver);
    }
    public SearchTelevizoarePage goToSearchTelevizoarePage(){
        searchButton.click();
        return new SearchTelevizoarePage(driver);
    }

    public HomePage validationHomePage(){
       assertEquals("https://www.emag.ro/homepage", driver.getCurrentUrl());
       // assertEquals(driver.getTitle(), "eMAG.ro - Libertate în fiecare zi");
        return this;
    }

}

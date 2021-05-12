package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by diana on 20 Apr 2021
 */

public class SearchTastaturaPage extends LoadableComponent<SearchTastaturaPage> {

    WebDriver driver;
    String baseURL = "https://www.emag.ro/search/tastatura?ref=effective_search";

    private String FirstProductText;
    private String SecondProductText;

    @FindBy(xpath = "//a[text()='Livrate de eMAG ']")
    private WebElement checkEmagGenius;
    @FindBy(xpath = "(//a[@data-zone='title'])[1]")
    private WebElement productOneText;
    @FindBy(xpath = "(//a[@data-zone='title'])[2]")
    private WebElement productTwoText;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[1]")
    private WebElement addProductOne;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[2]")
    private WebElement addProductTwo;
    @FindBy(xpath = "//button[@class='close gtm_6046yfqs']")
    private WebElement closeSuggestions;
    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[1]")
    private WebElement productOne;
    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[2]")
    private WebElement productTwo;
    @FindBy(id = "my_cart")
    private WebElement cartButton;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[1]")
    private WebElement deleteFirstProduct;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[2]")
    private WebElement deleteSecond;
    @FindBy(xpath = "//div[text()='Cosul tau este gol']")
    private WebElement message;

    public SearchTastaturaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstProductText() {
        return FirstProductText;
    }

    public String getSecondProductText() {
        return SecondProductText;
    }

    public WebElement getAddProductOne() {
        return addProductOne;
    }

    public WebElement getCheckEmagGenius() {
        return checkEmagGenius;
    }

    public SearchTastaturaPage selectEmagGenius() {
        checkEmagGenius.click();
        return this;
    }

    public SearchTastaturaPage addElements() {
        FirstProductText = productOneText.getText();
        SecondProductText = productTwoText.getText();
        try {
            addProductOne.click();
            closeSuggestions.click();
            addProductTwo.click();
            closeSuggestions.click();
        } catch (StaleElementReferenceException ex) {
            addProductOne.click();
            closeSuggestions.click();
            addProductTwo.click();
            closeSuggestions.click();
        }
        return this;
    }

    public BasketPage goToBasketPage() {
        cartButton.click();
        return new BasketPage(driver);
    }

    @Override
    public void load() {
        this.driver.get(baseURL);
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(baseURL));
    }
}

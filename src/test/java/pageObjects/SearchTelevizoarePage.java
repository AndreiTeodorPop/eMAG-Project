package pageObjects;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchTelevizoarePage extends LoadableComponent<SearchTelevizoarePage> {

    WebDriver driver;
    String baseURL = "https://www.emag.ro/search/televizoare?ref=effective_search";

    @FindBy(id = "card_grid")
    private WebElement listOfTvDisplayed;
    @FindBy(xpath = "//a[@class='js-filter-item filter-item' and @data-name='Resigilate']")
    private WebElement filterResigilate;
    @FindBy(xpath = "(//a[@class='card-family-options'])[1]")
    private WebElement varianteDiagonalaDisplayed;
    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-default btn-sm btn-block bundle-product-buy-button po-text-small gtm_nhdl6r']")
    private WebElement cumparaResigilatButton;
    @FindBy(xpath = "//button[@type='button' and @class='close gtm_6046yfqs']")
    private WebElement closeSugestion;
    @FindBy(id = "my_cart")
    private WebElement shoppingBasketButton;
    @FindBy(xpath = "//div[@class='menu-container']")
    private WebElement meniuDeSelectie;

    public SearchTelevizoarePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getMeniuDeSelectie(){
        return meniuDeSelectie;
    }

    public WebElement getCumparaResigilatButton(){
        return cumparaResigilatButton;
    }

    public WebElement getFilterResigilate(){
        return filterResigilate;
    }

    public WebElement getVarianteDiagonalaDisplayed(){
        return varianteDiagonalaDisplayed;
    }

    public SearchTelevizoarePage productsTvAreDisplayed() {
        WebElement allElements = driver.findElement(By.id("card_grid"));
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'televizor')]"));

        assertTrue(list.size() > 0);
        assertTrue(listOfTvDisplayed.isDisplayed());
        return this;
    }

    public SearchTelevizoarePage filterTvFromDisponibilitate() {
        filterResigilate.click();
        return this;
    }

    public SearchTelevizoarePage selectDiagonalaDisplay() {
        try {
            varianteDiagonalaDisplayed.click();
        } catch (StaleElementReferenceException ex) {
            varianteDiagonalaDisplayed.click();
        }
        return this;
    }

    public SearchTelevizoarePage addToShoppingBasket() {
        cumparaResigilatButton.click();
        closeSugestion.click();
        return this;
    }

    public BasketPage goToBasketPage() {
        shoppingBasketButton.click();
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

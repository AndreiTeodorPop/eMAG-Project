package pageObjects;

import implementationSteps.Helper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class BasketPage extends LoadableComponent<BasketPage>{

    WebDriver driver;
    String baseURL = "https://www.emag.ro/cart/products?ref=cart";

    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[1]")
    private WebElement productOne;
    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[2]")
    private WebElement productTwo;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[1]")
    private WebElement deleteFirstProduct;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[2]")
    private WebElement deleteSecondProduct;
    @FindBy(xpath = "//div[text()='Cosul tau este gol']")
    private WebElement messageEmptyShoppingBasket;
    @FindBy(xpath = "//a[@class='line-item-title main-product-title']")
    private WebElement tvProductText;
    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[1]")
    private WebElement mouseText1;
    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[2]")
    private WebElement mouseText2;
    @FindBy(xpath = "(//a[@class='line-item-title main-product-title'])[3]")
    private WebElement mouseText3;


    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDeleteFirstProduct(){
        return deleteFirstProduct;
    }

    public BasketPage deleteTastaturaProducts() {
        try {
            deleteFirstProduct.click();
            deleteSecondProduct.click();
            Assert.assertTrue(messageEmptyShoppingBasket.isDisplayed());
        } catch (StaleElementReferenceException ex) {
            deleteFirstProduct.click();
            deleteSecondProduct.click();
            Assert.assertTrue(messageEmptyShoppingBasket.isDisplayed());
        }
        return this;
    }

    public BasketPage deleteProduct() {
        driver.navigate().refresh();
        deleteFirstProduct.click();
        return this;
    }

    public BasketPage deleteMouseProducts() {
        deleteFirstProduct.click();
        load();
        isLoaded();
//        driver.navigate().refresh();
        deleteFirstProduct.click();
        load();
        isLoaded();
//        driver.navigate().refresh();
        deleteFirstProduct.click();
        return this;
    }

    public BasketPage deleteTelevizorProduct() {
        deleteFirstProduct.click();
        return this;
    }

    public BasketPage checkTvProductsIsDisplayed() {
        Assert.assertTrue(tvProductText.getText().contains("Televizor"));
        return this;
    }


    public BasketPage checkTastaturaProductsIsDisplayed(String firstElement, String secondElement) {
        Assert.assertEquals(firstElement, productOne.getText());
        Assert.assertEquals(secondElement, productTwo.getText());
        return this;
    }

    public BasketPage checkMouseProductsIsDisplayed(String mouse1StrText, String mouse2StrText, String mouse3StrText) {
        System.out.println();
        System.out.println(mouseText1.getText());
        System.out.println(mouseText2.getText());
        System.out.println(mouseText3.getText());
        Assert.assertEquals(mouse1StrText, mouseText1.getText());
        Assert.assertEquals(mouse2StrText, mouseText2.getText());
        Assert.assertEquals(mouse3StrText, mouseText3.getText());
        return this;
    }

    public HomePage navigateToHomePage() {
        driver.navigate().to("https://www.emag.ro/");
        assertEquals("https://www.emag.ro/", driver.getCurrentUrl());
        return new HomePage(driver);
    }

    public BasketPage emptyBasketValidation() {
        System.out.println(messageEmptyShoppingBasket.getText());
        Assert.assertEquals("Cosul tau este gol", messageEmptyShoppingBasket.getText());
        return this;
    }

    @Override
    protected void load() {
        this.driver.get(baseURL);
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(baseURL));
    }
}
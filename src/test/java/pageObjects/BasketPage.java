package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class BasketPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[1]/a")
    private WebElement productOne;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[2]/div/div[2]/div[1]/div[1]/a")
    private WebElement productTwo;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[1]")
    private WebElement deleteFirstProduct;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[2]")
    private WebElement deleteSecondProduct;
    @FindBy(xpath = "//*[@id=\"empty-cart\"]/div[1]")
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

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }


    public void waitForVisibilityOfElementErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[1]")));
    }


    public BasketPage deleteTastaturaProducts() {
        try {
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deleteSecondProduct.click();
            Assert.assertTrue(messageEmptyShoppingBasket.isDisplayed());
        } catch (StaleElementReferenceException ex) {
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deleteSecondProduct.click();
            Assert.assertTrue(messageEmptyShoppingBasket.isDisplayed());
        }
        return this;
    }

    public HomePage navigateToHomePage() {
        driver.navigate().to("https://www.emag.ro/");
        assertEquals("https://www.emag.ro/", driver.getCurrentUrl());
        return new HomePage(driver);
    }

    public BasketPage checkTvProductsIsDisplayed() {
        Assert.assertTrue(tvProductText.getText().contains("Televizor"));
        return this;
    }

    public BasketPage deleteProduct() {
        deleteFirstProduct.click();
        Assert.assertEquals(messageEmptyShoppingBasket.getText(), "Cosul tau este gol");
        return this;
    }

    public BasketPage checkPresenceOfProd(String firstElement, String secondElement) {
        Assert.assertEquals(firstElement, productOne.getText());
        Assert.assertEquals(secondElement, productTwo.getText());
        return new BasketPage(driver);
    }
    public BasketPage checkPresenceOfMouses() {
        Assert.assertTrue(mouseText1.getText().contains("Mouse"));
        Assert.assertTrue(mouseText2.getText().contains("Mouse"));
        Assert.assertTrue(mouseText3.getText().contains("Mouse"));
        return this;
    }

    public BasketPage deleteMouseProducts(){
        try {
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deleteFirstProduct.click();
        }catch (StaleElementReferenceException ex)
        {
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deleteFirstProduct.click();
        }
        return this;
    }

    public BasketPage emptyBasketValidation(){
        Assert.assertEquals(messageEmptyShoppingBasket.getText(), "Cosul tau este gol");
        return this;
    }
}

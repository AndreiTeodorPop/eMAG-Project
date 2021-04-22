package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by diana on 20 Apr 2021
 */

public class SearchTastaturaPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Livrate de eMAG ']")
    private WebElement checkEmagGenius;
    @FindBy(xpath = "//*[@id=\"card_grid\"]/div[1]/div[2]/div/div[2]/h2/a")
    private WebElement productOneText;
    @FindBy(xpath = "//*[@id=\"card_grid\"]/div[2]/div[2]/div/div[2]/h2/a")
    private WebElement productTwoText;
    private String TestF = "";
    private String TestS = "";
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[1]")
    private WebElement addProductOne;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[2]")
    private WebElement addProductTwo;
    @FindBy(xpath = "//button[@class='close gtm_6046yfqs']")
    private WebElement closeSuggestions;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[1]/a")
    private WebElement productOne;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[2]/div/div[2]/div[1]/div[1]/a")
    private WebElement productTwo;
    @FindBy(id = "my_cart")
    private WebElement cartButton;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[1]")
    private WebElement deleteFirstProduct;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[2]")
    private WebElement deleteSecond;
    @FindBy(xpath = "//*[@id=\"empty-cart\"]/div[1]")
    private WebElement message;


    public SearchTastaturaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }

    public SearchTastaturaPage selectEmagGenius() {
        scrollToElement(checkEmagGenius);
        checkEmagGenius.click();
        return this;
    }

    public SearchTastaturaPage addElements() {
        try {
            TestF = productOneText.getText();
            TestS = productTwoText.getText();
            scrollToElement(addProductOne);
            addProductOne.click();
            closeSuggestions.click();
            scrollToElement(addProductTwo);
            addProductTwo.click();
            closeSuggestions.click();
            Assert.assertTrue(productOneText.isDisplayed());
            Assert.assertTrue(productTwoText.isDisplayed());
        } catch (StaleElementReferenceException ex) {
            TestF = productOneText.getText();
            TestS = productTwoText.getText();
            scrollToElement(addProductOne);
            addProductOne.click();
            closeSuggestions.click();
            scrollToElement(addProductTwo);
            addProductTwo.click();
            closeSuggestions.click();
            Assert.assertTrue(productOneText.isDisplayed());
            Assert.assertTrue(productTwoText.isDisplayed());
        }
        return this;
    }

    public BasketPage goToBasketPage() {
        cartButton.click();
        return new BasketPage(driver);
    }

    public String getFirstElement() {
        return this.TestF;
    }

    public String getSecondElement() {
        return this.TestS;
    }

}

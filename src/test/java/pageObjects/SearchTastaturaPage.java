package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by diana on 20 Apr 2021
 */

public class SearchTastaturaPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Livrate de eMAG ']")
    private WebElement checkEmagGenius;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[1]")
    private WebElement firstProduct;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[2]")
    private WebElement secondProduct;
    @FindBy(xpath = "//button[@class='close gtm_6046yfqs']")
    private WebElement closeSuggestions;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[1]/a")
    private WebElement productOne;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[2]/div/div[2]/div[1]/div[1]/a")
    private WebElement productTwo;
    @FindBy(xpath = "//*[@id=\"my_cart\"]/span[2]")
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
            scrollToElement(firstProduct);
            firstProduct.click();
            firstProduct.getText();
            closeSuggestions.click();
            scrollToElement(secondProduct);
            secondProduct.click();
            secondProduct.getText();
            closeSuggestions.click();
        } catch (StaleElementReferenceException ex) {
            scrollToElement(firstProduct);
            firstProduct.click();
            closeSuggestions.click();
            scrollToElement(secondProduct);
            secondProduct.click();
            closeSuggestions.click();
        }
        return this;
    }

    public BasketPage checkPresenceOfProd() {
        cartButton.click();
        Assert.assertTrue(productOne.getText().contains("Tastatura"));
        Assert.assertTrue(productTwo.getText().contains("Tastatura"));
        return new BasketPage(driver);
    }

}

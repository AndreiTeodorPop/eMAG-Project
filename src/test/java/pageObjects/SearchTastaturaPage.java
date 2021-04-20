package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
    @FindBy(xpath = "//*[@id=\"my_cart\"]/span[2]")
    private WebElement cartButton;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[1]/a")
    private WebElement productOne;
    @FindBy(xpath = "//*[@id=\"vendorsContainer\"]/div/div[2]/div/div[2]/div[1]/div[1]/a")
    private WebElement productTwo;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[1]")
    private WebElement deleteFirstProduct;
    @FindBy(xpath = "(//a[@class ='emg-right remove-product btn-remove-product gtm_rp080219'])[2]")
    private WebElement deletSecond;
    @FindBy(xpath = "//*[@id=\"empty-cart\"]/div[1]")
    private WebElement message;
    @FindBy(xpath = "//*[@id=\"emg-fluid-header\"]/div/div[1]/a/img")
    private WebElement logo;

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

    public void waitForVisibilityOfElementErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vendorsContainer\"]/div/div[1]/div/div[2]/div[1]/div[3]/a[1]")));
    }

    public SearchTastaturaPage addElements() {
        try {
            scrollToElement(firstProduct);
            firstProduct.click();
            closeSuggestions.click();
            scrollToElement(secondProduct);
            secondProduct.click();
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

    public SearchTastaturaPage checkPresenceOfProd() {
        cartButton.click();
        Assert.assertEquals(productOne.getText(),"Kit Gaming A+ EL1, 4 in 1,Tastatura, Mouse, Casti, Mousepad");
        Assert.assertEquals(productTwo.getText(), "Tastatura gaming mecanica A+ Seth, iluminare rainbow");
        return this;
    }

    public SearchTastaturaPage deleteProducts() {
        try {
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deletSecond.click();
            Assert.assertTrue(message.isDisplayed());
        } catch (StaleElementReferenceException ex) {
            deleteFirstProduct.click();
            waitForVisibilityOfElementErrorMessage();
            deletSecond.click();
            Assert.assertTrue(message.isDisplayed());
        }
        return this;
    }

    public HomePage navigateToHomePage(){
        logo.click();
        assertEquals("https://www.emag.ro/", driver.getCurrentUrl());
        return new HomePage(driver);
    }


}

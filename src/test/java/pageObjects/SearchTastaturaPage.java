package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    public BasketPage checkPresenceOfProd() {
        cartButton.click();
        //Assert.assertEquals(productOne.getText(), "Kit Gaming A+ EL1, 4 in 1,Tastatura, Mouse, Casti, Mousepad");
        //Assert.assertEquals(productTwo.getText(), "Tastatura gaming mecanica A+ Seth, iluminare rainbow");
        return new BasketPage(driver);
    }

}

package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchMousePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='d-flex vcenter hidden-xs']//preceding-sibling::div[text()='Mouse']")
    private WebElement mouseProducts;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-alt sort-control-btn']//preceding-sibling::span[text()='Relevanta'])[1]")
    private WebElement dropDownTable;
    @FindBy(xpath = "//a[text()='Pret crescator']")
    private WebElement pretCrescator;
    @FindBy(xpath = "(//img[@class='lozad'])[1]")
    private WebElement firstProductImg;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[1]")
    private WebElement addToCartProduct1;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[2]")
    private WebElement addToCartProduct2;
    @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[3]")
    private WebElement addToCartProduct3;
    @FindBy(xpath = "//button[@class='close gtm_6046yfqs']")
    private WebElement closeSuggestions;
    @FindBy(id = "my_cart")
    private WebElement shoppingBasketButton;


    public SearchMousePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchMousePage selectMouseProducts() {
        mouseProducts.click();
        return this;
    }

    public SearchMousePage selectAscendingPriceDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mouse']")));
        dropDownTable.click();
        pretCrescator.click();
        return this;
    }

    public SearchMousePage addProductsToCart(){
        try {
            scrollToElement(addToCartProduct1);
            addToCartProduct1.click();
            closeSuggestions.click();
            addToCartProduct2.click();
            closeSuggestions.click();
            addToCartProduct3.click();
            closeSuggestions.click();
        }catch (StaleElementReferenceException ex){
            scrollToElement(addToCartProduct1);
            addToCartProduct1.click();
            closeSuggestions.click();
            addToCartProduct2.click();
            closeSuggestions.click();
            addToCartProduct3.click();
            closeSuggestions.click();
        }
        return this;
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }

    public BasketPage goToBasketPage(){
        shoppingBasketButton.click();
        return new BasketPage(driver);
    }
}

package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SearchMousePage {

    WebDriver driver;

    String product1StrText;
    String product2StrText;
    String product3StrText;

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
    @FindBy(xpath = "//span[text()='Mouse']")
    private WebElement mouseText;
    @FindBy(xpath = "(//a[@class='product-title js-product-url'])[1]")
    private WebElement product1Text;
    @FindBy(xpath = "(//a[@class='product-title js-product-url'])[2]")
    private WebElement product2Text;
    @FindBy(xpath = "(//a[@class='product-title js-product-url'])[3]")
    private WebElement product3Text;
    @FindBy(xpath = "//span[@class='small']")
    private WebElement productTextFromSugestion;

    public SearchMousePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToCartProduct1() {
        return addToCartProduct1;
    }

    public WebElement getAddToCartProduct2() {
        return addToCartProduct2;
    }

    public WebElement getAddToCartProduct3() {
        return addToCartProduct3;
    }

    public WebElement getMouseText() {
        return mouseText;
    }

    public String getProduct1StrText() {
        return product1StrText;
    }

    public String getProduct2StrText(){
        return product2StrText;
    }

    public String getProduct3StrText(){
        return product3StrText;
    }

    public String getProduct3Text() {
        return product3Text.getText();
    }

    public SearchMousePage selectMouseProducts() {
        mouseProducts.click();
        return this;
    }

    public SearchMousePage selectAscendingPriceDropDown() {
        dropDownTable.click();
        pretCrescator.click();
        return this;
    }

    public SearchMousePage addProductsToCart() {

        try {
            addToCartProduct1.click();
            product1StrText = productTextFromSugestion.getText();
            closeSuggestions.click();
            addToCartProduct2.click();
            product2StrText = productTextFromSugestion.getText();
            closeSuggestions.click();
            addToCartProduct3.click();
            product3StrText = productTextFromSugestion.getText();
            closeSuggestions.click();
        } catch (StaleElementReferenceException ex) {
            addToCartProduct1.click();
            product1StrText = productTextFromSugestion.getText();
            closeSuggestions.click();
            addToCartProduct2.click();
            product2StrText = productTextFromSugestion.getText();
            closeSuggestions.click();
            addToCartProduct3.click();
            product3StrText = productTextFromSugestion.getText();
            closeSuggestions.click();
        }
        System.out.println(product1StrText);
        System.out.println(product2StrText);
        System.out.println(product3StrText);

        ArrayList<String> productsText = new ArrayList<>();
        productsText.add(product1StrText);
        productsText.add(product2StrText);
        productsText.add(product3StrText);
        productsText.sort(String::compareToIgnoreCase);

        System.out.println(product1StrText);
        System.out.println(product2StrText);
        System.out.println(product3StrText);
        return this;
    }

    public BasketPage goToBasketPage() {
        shoppingBasketButton.click();
        return new BasketPage(driver);
    }
}

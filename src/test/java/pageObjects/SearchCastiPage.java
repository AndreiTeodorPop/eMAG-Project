package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.StringTokenizer;


/**
 * Created by atpop on 20 Apr 2021
 */

public class SearchCastiPage extends LoadableComponent<SearchCastiPage> {

    WebDriver driver;
    String baseURL = "https://www.emag.ro/search/casti?ref=effective_search";

    @FindBy(xpath = "//title[text()='Cauți Casti? Alege din oferta eMAG.ro']")
    private WebElement castiPageTitle;
    @FindBy(xpath = "//button[@class='btn btn-sm btn-alt sort-control-btn']")
    private WebElement dropDown;
    @FindBy(xpath = "//a[@data-sort-id='reviews'][@class='js-sort-option']")
    private WebElement dropDownOrderByReviews;
    @FindBy(xpath = "(//span[@class='hidden-xs '])[6]")
    private WebElement productReviewButton;
    @FindBy(xpath = "//p[@class='review-rating-data']")
    private WebElement productReviewNote;
    @FindBy(xpath = "(//a[@class='product-title js-product-url'])[1]")
    private WebElement firstCastiProduct;
    @FindBy(xpath = "(//a[text()='Casti audio JBL'])[1]")
    private WebElement firstCastiProductType;

    private String productName;

    public SearchCastiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDropDownOrderByReviews(){
        return dropDownOrderByReviews;
    }

    public WebElement getProductReviewButton(){
        return productReviewButton;
    }

    public SearchCastiPage checkForCastiPage() {
        Assert.assertEquals(driver.getTitle(), "Cauți Casti? Alege din oferta eMAG.ro");
        return this;
    }

    public SearchCastiPage checkForFirstCastiProductPage() {
        Assert.assertEquals(firstCastiProductType.getText(), "Casti audio JBL");
        return this;
    }

    public SearchCastiPage filterByNrOfReviews() {
        dropDown.click();
        dropDownOrderByReviews.click();
        productName = firstCastiProduct.getText();
        return this;
    }

    public SearchCastiPage selectProductByReview() {
        try {
            productReviewButton.click();
        } catch (StaleElementReferenceException ex) {
            productReviewButton.click();
        }
        return this;
    }

    public void displayProductReview() {
        StringTokenizer tokenizer = new StringTokenizer(productName, ",");
        System.out.println("First product name and review note: ");
        System.out.println("===================================");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        System.out.println("----------------" + productReviewNote.getText() + "----------------");
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

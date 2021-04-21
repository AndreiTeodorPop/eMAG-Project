package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by atpop on 20 Apr 2021
 */

public class SearchCastiPage {

    WebDriver driver;

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

    public SearchCastiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }

    public SearchCastiPage checkForCastiPage() {
        Assert.assertEquals(driver.getTitle(), "Cauți Casti? Alege din oferta eMAG.ro");
        return this;
    }

    public SearchCastiPage filterByNrOfReviews() {
        dropDown.click();
        dropDownOrderByReviews.click();
        return this;
    }

    public SearchCastiPage selectProductByReview() {
        try {
            scrollToElement(productReviewButton);
            productReviewButton.click();
        } catch (StaleElementReferenceException ex) {
            scrollToElement(productReviewButton);
            productReviewButton.click();
        }
        return this;
    }

    public void displayProductReview() {
        System.out.println("Product review note: " + productReviewNote.getText());
    }
}

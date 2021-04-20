package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
//    @FindBy(linkText = "Nr. review-uri")
    private WebElement dropDownOrderByReviews;

    public SearchCastiPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchCastiPage checkForCastiPage() {
        Assert.assertEquals(driver.getTitle(), "Cauți Casti? Alege din oferta eMAG.ro");
        return this;
    }

    public SearchCastiPage filterByNrOfReviews () {
        dropDown.click();
        dropDownOrderByReviews.click();
        return this;
    }
}

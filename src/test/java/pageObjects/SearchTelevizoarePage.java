package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchTelevizoarePage {
    WebDriver driver;

    public SearchTelevizoarePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "card_grid")
    private WebElement listOfTvDisplayed;
    @FindBy(xpath = "//a[@class='js-filter-item filter-item' and @data-name='Resigilate']")
    private WebElement filterResigilate;
    @FindBy(xpath = "(//a[@class='card-family-options'])[1]")
    private WebElement varianteDiagonalaDisplayed;
//    @FindBy(xpath = "//a[@href='https://www.emag.ro/televizor-led-star-light-80-cm-32dm3500-hd-clasa-f-rsgemag4268360x-32dm3500/pd/D13W62BBM/?X-Search-Id=ca8f03d625ad23954bd5&X-Product-Id=8009487&X-Search-Page=1&X-Search-Position=0&X-Section=search&X-MB=0&X-Search-Action=view&ref=view-family'][@class='card-family-options']")
//    private WebElement varianteDisplayed;
    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-default btn-sm btn-block bundle-product-buy-button po-text-small gtm_nhdl6r']")
    private WebElement cumparaResigilatButton;
    @FindBy(xpath = "//button[@type='button' and @class='close gtm_6046yfqs']")
    private WebElement closeSugestion;

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }
    public void waitForVisibilityOfElement(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-container']")));
    }

    public SearchTelevizoarePage productsTvAreDisplayed(){
        WebElement allElements =driver.findElement(By.id("card_grid"));
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'televizor')]"));

        assertTrue(list.size() > 0);
        assertTrue(listOfTvDisplayed.isDisplayed());
        return this;
    }
    public SearchTelevizoarePage filterTvFromDisponibilitate(){
        scrollToElement(filterResigilate);
        filterResigilate.click();
        return this;
    }
    public SearchTelevizoarePage selectDiagonalaDisplay(){
       varianteDiagonalaDisplayed.click();
        return this;
    }
    public SearchTelevizoarePage addToShoppingBasket(){
        scrollToElement(cumparaResigilatButton);
        cumparaResigilatButton.click();
        closeSugestion.click();
        return this;
    }


}

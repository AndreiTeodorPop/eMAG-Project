package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void waitForVisibilityOfElementErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-sm btn-primary btn-emag yeahIWantThisProduct'])[1]")));
    }
    public SearchTastaturaPage addElements() {
        try {
            scrollToElement(firstProduct);
            firstProduct.click();
            closeSuggestions.click();
            scrollToElement(secondProduct);
            secondProduct.click();
            closeSuggestions.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            scrollToElement(firstProduct);
            firstProduct.click();
            closeSuggestions.click();
            scrollToElement(secondProduct);
            secondProduct.click();
            closeSuggestions.click();
        }
        return this;
    }




}

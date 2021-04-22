package implementationSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class SetUp {

    WebDriver driver;
    HomePage homePage;
    SearchTastaturaPage searchTastaturaPage;
    BasketPage basketPage;
    SearchCastiPage searchCastiPage;
    SearchTelevizoarePage searchTelevizoarePage;
    SearchMousePage searchMousePage;

    public SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://emag.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        searchTastaturaPage = new SearchTastaturaPage(driver);
        basketPage = new BasketPage(driver);
        searchCastiPage = new SearchCastiPage(driver);
        searchTelevizoarePage = new SearchTelevizoarePage(driver);
        searchMousePage = new SearchMousePage(driver);
    }

}

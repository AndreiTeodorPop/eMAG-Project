package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import logger.Log4j;
import org.junit.After;
import org.junit.Before;
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
    Helper helper;
    Constants constants;
    Log4j logger;

    public SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.emag.ro/homepage");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        searchTastaturaPage = new SearchTastaturaPage(driver);
        basketPage = new BasketPage(driver);
        searchCastiPage = new SearchCastiPage(driver);
        searchTelevizoarePage = new SearchTelevizoarePage(driver);
        searchMousePage = new SearchMousePage(driver);
        helper = new Helper(driver);
        constants = new Constants(driver);
        logger = new Log4j(driver);
    }
//
//    @Before
//    @Given("User opens eMAG home page")
//    public void userOpensEmagHomePage() {
//        logger.configure();
//        // setUp.driver.get("https://www.emag.ro/");
//        homePage.validationHomePage();
//    }
//
//    @After
//    @And("User navigates to home page and quit the browser")
//    public void userNavigatesToHomePageAndQuitTheBrowser() {
//        logger.resetConfiguration();
//        basketPage.navigateToHomePage();
//        driver.quit();
//    }
}

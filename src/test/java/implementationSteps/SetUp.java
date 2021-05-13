package implementationSteps;

import logger.Log4j;
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

    public SetUp(WebDriver driver) {
        this.driver=driver;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.emag.ro/");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(this.driver);
        searchTastaturaPage = new SearchTastaturaPage(this.driver);
        basketPage = new BasketPage(this.driver);
        searchCastiPage = new SearchCastiPage(this.driver);
        searchTelevizoarePage = new SearchTelevizoarePage(this.driver);
        searchMousePage = new SearchMousePage(this.driver);
        helper = new Helper(this.driver);
        constants = new Constants(this.driver);
        logger = new Log4j(this.driver);
    }
}


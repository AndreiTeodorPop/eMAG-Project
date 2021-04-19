package implementationSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class SetUp {

    WebDriver driver;
    HomePage homePage;

    public SetUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome2driver.exe");
        driver = new ChromeDriver();
        driver.get("https://emag.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);

    }
}

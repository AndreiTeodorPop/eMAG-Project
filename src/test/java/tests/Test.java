package tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class Test {
    String driverPath = "src/main/resources\\chromedriver.exe";
    WebDriver driver;

    HomePage obj_HomePage;
    LoginPage obj_LoginPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://emag.ro/");
    }

    @org.junit.Test
    public void Test() {
        obj_HomePage = new HomePage(driver);
        obj_HomePage.validationHomePage();
    }
}

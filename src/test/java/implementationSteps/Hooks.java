//package implementationSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class Hooks {
//
//    WebDriver driver;
//
//    SetUp setUp = new SetUp();
//
//    @Before
//    public void beforeScenario(){
//        System.out.println("This will run before the Scenario");
//    }
//
//    @After
//    public void afterScenario(){
//        System.out.println("This will run after the Scenario");
//        setUp.driver.quit();
//    }
//}

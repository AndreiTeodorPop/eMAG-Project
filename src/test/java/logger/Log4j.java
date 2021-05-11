package logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Log4j {

    WebDriver driver;


    public Logger logger = LogManager.getLogger(Log4j.class);

    public Log4j(WebDriver driver) {
        this.driver = driver;
    }

    public void configure() {
        BasicConfigurator.configure();
    }

    public void resetConfiguration() {
        BasicConfigurator.resetConfiguration();
    }

}

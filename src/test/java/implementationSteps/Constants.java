package implementationSteps;

import org.openqa.selenium.WebDriver;

public class Constants {

    WebDriver driver;

    private final String mouseTextForSearch = "Mouse";
    private final String tastaturiTextForSearch = "Tastaturi";
    private final String castiTextForSearch = "Casti";
    private final String televizoareTextForSearch = "Televizoare";

    public Constants(WebDriver driver) {
        this.driver = driver;
    }

    public String getMouseTextForSearch() {
        return mouseTextForSearch;
    }

    public String getTastaturiTextForSearch() {
        return tastaturiTextForSearch;
    }

    public String getCastiTextForSearch() {
        return castiTextForSearch;
    }

    public String getTelevizoareTextForSearch() {
        return televizoareTextForSearch;
    }
}

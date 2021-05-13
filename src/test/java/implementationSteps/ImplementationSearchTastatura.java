package implementationSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ImplementationSearchTastatura {


    WebDriver driver;
    SetUp setUp = new SetUp(driver);

    @Before
    @Given("^User opens eMAG home page$")
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
        setUp.logger.configure();
        setUp.homePage.validationHomePage();
        setUp.homePage.isLoaded();
    }

    @After
    @And("^User navigates to home page and quit the browser$")
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
        setUp.logger.resetConfiguration();
        setUp.homePage.load();
        setUp.driver.quit();
    }

    @When("^User searches for (.*) in search bar$")
    public void userSearchesForInSearchBar(String product) throws Throwable{
        setUp.logger.logger.info("Now running scenario nr.1");
        setUp.homePage.writeOnSearchBox(product);
        setUp.searchTastaturaPage = setUp.homePage.goToSearchTastaturaPage();
    }

    @And("User selects eMAG genius products")
    public void userSelectsEMAGGeniusProducts() {
        setUp.helper.scrollToElement(setUp.searchTastaturaPage.getCheckEmagGenius());
        setUp.searchTastaturaPage.selectEmagGenius();
    }

    @Then("User adds products to cart")
    public void userAddsProductsToCart() {
        setUp.helper.scrollToElement(setUp.searchTastaturaPage.getAddProductOne());
        setUp.searchTastaturaPage.addElements();
    }

    @Then("User checks that the products are added to cart")
    public void userChecksThatTheProductsAreAddedToCart() {
        setUp.searchTastaturaPage.goToBasketPage();
        setUp.basketPage.checkTastaturaProductsIsDisplayed(setUp.searchTastaturaPage.getFirstProductText(), setUp.searchTastaturaPage.getSecondProductText());
        System.out.println(setUp.searchTastaturaPage.getFirstProductText());
        System.out.println(setUp.searchTastaturaPage.getSecondProductText());
    }

    @And("User deletes all the products from cart")
    public void userDeletesAllTheProductsFromCart() {
        setUp.helper.waitVisibility10seconds(setUp.basketPage.getDeleteFirstProduct());
        setUp.basketPage.deleteTastaturaProducts();
    }
}

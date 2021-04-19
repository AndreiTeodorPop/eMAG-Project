package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

public class ImplementationSearch {

    WebDriver driver;
    SetUp setUp = new SetUp();

    @Given("User opens eMAG home page")
    public void userOpensEmagHomePage() {
        // setUp.driver.get("https://www.emag.ro/");
        setUp.homePage.validationHomePage();
    }

    @When("User searches for tastatura in search bar")
    public void userSearchesForTastaturaInSearchBar() {
        setUp.homePage.searchProduct("Tastatura");
    }


//    @And("User selects eMAG genius products")
//    public void userSelectsEMAGGeniusProducts() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("User adds first product to cart")
//    public void userAddsFirstProductToCart() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @And("User adds second product to cart")
//    public void userAddsSecondProductToCart() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("User checks that the products are added to cart")
//    public void userChecksThatTheProductsAreAddedToCart() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @And("User deletes all the products from cart")
//    public void userDeletesAllTheProductsFromCart() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("User navigates to home page")
//    public void userNavigatesToHomePage() {
//        throw new io.cucumber.java.PendingException();
//    }


}

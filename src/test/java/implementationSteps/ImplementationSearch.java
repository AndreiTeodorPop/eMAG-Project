package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

public class ImplementationSearch{

    WebDriver driver;
    SetUp setUp = new SetUp();

    @Given("User opens eMAG home page")
    public void userOpensEmagHomePage(){
        setUp.homePage.validationHomePage();
    }

//    @And("User navigate on search bar")
//    public void userNavigateOnSearchBar() {
//    }
//
//    @When("User searches for tastatura")
//    public void userSearchesForTastatura() {
//    }
//
//    @And("User selects eMAG genius products")
//    public void userSelectsEMAGGeniusProducts() {
//    }
//
//    @Then("User adds first product to cart")
//    public void userAddsFirstProductToCart() {
//    }
//
//    @And("User adds second product to cart")
//    public void userAddsSecondProductToCart() {
//    }
//
//    @Then("User checks that the products are added to cart")
//    public void userChecksThatTheProductsAreAddedToCart() {
//    }
//
//    @And("User deletes all the products from cart")
//    public void userDeletesAllTheProductsFromCart() {
//    }
//
//    @Then("User navigates to home page")
//    public void userNavigatesToHomePage() {
//    }
}

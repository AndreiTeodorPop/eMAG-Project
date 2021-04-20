package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

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
        setUp.searchTastaturaPage = setUp.homePage.searchProduct("Tastatura");
    }

    @And("User selects eMAG genius products")
    public void userSelectsEMAGGeniusProducts() {
       setUp.searchTastaturaPage.selectEmagGenius();
    }

    @Then("User adds products to cart")
    public void userAddsProductsToCart() {
        setUp.searchTastaturaPage.addElements();
    }

    @Then("User checks that the products are added to cart")
    public void userChecksThatTheProductsAreAddedToCart() {
        setUp.searchTastaturaPage.checkPresenceOfProd();
    }

    @And("User deletes all the products from cart")
    public void userDeletesAllTheProductsFromCart() {
        setUp.basketPage.deleteProducts();
    }

    @Then("User navigates to home page")
    public void userNavigatesToHomePage() {
        setUp.basketPage.navigateToHomePage();
    }

    @When("User searches for a list of products in casti category")
    public void userSearchesForAListOfProductsInCastiCategory() {
    }

//    @Then("Show a list of casti products")
//    public void showAListOfCastiProducts() {
//    }
//
//    @When("User filters the list based on reviews")
//    public void userFiltersTheListBasedOnReviews() {
//    }
//
//    @Then("Show a list of casti products ordered by most reviews")
//    public void showAListOfCastiProductsOrderedByMostReviews() {
//    }
//
//    @When("User selects desired product to see his review")
//    public void userSelectsDesiredProductToSeeHisReview() {
//    }
//
//    @Then("Show selected product page info")
//    public void showSelectedProductPageInfo() {
//    }
//
//    @And("Product review is displayed in console")
//    public void productReviewIsDisplayedInConsole() {
//    }
}

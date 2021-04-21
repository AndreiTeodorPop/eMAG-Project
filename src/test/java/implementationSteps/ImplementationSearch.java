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
        setUp.searchTastaturaPage.goToBasketPage();
        setUp.basketPage.checkPresenceOfProd();
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
        setUp.searchTastaturaPage = setUp.homePage.searchProduct("Casti");
    }

    @Then("Show a list of casti products")
    public void showAListOfCastiProducts() {
        setUp.castiPage.checkForCastiPage();
    }

    @When("User filters the list based on reviews")
    public void userFiltersTheListBasedOnReviews() {
        setUp.castiPage.filterByNrOfReviews();
    }

    @When("User writes in the search field the product name and presses on cauta button")
    public void userWritesInTheSearchFieldTheProductNameAndPressesOnCautaButton() {
        setUp.searchTastaturaPage = setUp.homePage.searchProduct("Televizoare");
    }

    @Then("All products from televizoare are displayed")
    public void allProductsFromTelevizoareAreDisplayed() {
        setUp.searchTelevizoarePage.productsTvAreDisplayed();
    }

    @And("User filters from disponibilitate products which are resigilate")
    public void userFiltersFromDisponibilitateProductsWhichAreResigilate() {
        setUp.searchTelevizoarePage.filterTvFromDisponibilitate();
    }

    @When("Navigate on diagonala display of the first product")
    public void navigateOnDiagonalaDisplayOfTheFirstProduct() throws InterruptedException {
        setUp.searchTelevizoarePage.waitForVisibilityOfElement();
        //Thread.sleep(2000);
        setUp.searchTelevizoarePage.selectDiagonalaDisplay();
    }

    @And("Add the product to shopping basket")
    public void addTheProductToShoppingBasket() {
        setUp.searchTelevizoarePage.addToShoppingBasket();
    }

    @Then("Check if the product is in the shopping basket")
    public void checkIfTheProductIsInTheShoppingBasket() {
        setUp.searchTelevizoarePage.goToBasketPage();
        setUp.basketPage.checkTvProductsIsDisplayed();
    }

    @Then("Delete the product from shopping basket")
    public void deleteTheProductFromShoppingBasket() {
        setUp.basketPage.deleteProduct();
    }

    //    @Then("Show a list of casti products ordered by most reviews")
//    public void showAListOfCastiProductsOrderedByMostReviews() {
//    }
//
    @When("User selects desired product to see his review")
    public void userSelectsDesiredProductToSeeHisReview() throws InterruptedException {
//        Thread.sleep(2000);
        setUp.castiPage.selectProductByReview();
    }

    //
//    @Then("Show selected product page info")
//    public void showSelectedProductPageInfo() {
//    }
//
    @And("Product review is displayed in console")
    public void productReviewIsDisplayedInConsole() {
        setUp.castiPage.displayProductReview();
    }
}

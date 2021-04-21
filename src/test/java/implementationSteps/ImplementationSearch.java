package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImplementationSearch {

    SetUp setUp = new SetUp();


    @Given("User opens eMAG home page")
    public void userOpensEmagHomePage() {
        // setUp.driver.get("https://www.emag.ro/");
        setUp.homePage.validationHomePage();
    }

    @When("User searches for tastatura in search bar")
    public void userSearchesForTastaturaInSearchBar() {
        setUp.searchTastaturaPage = setUp.homePage.goToSearchTastaturaPage("Tastatura");
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

    @And("User navigates to home page and quit the browser")
    public void userNavigatesToHomePageAndQuitTheBrowser() {
        setUp.basketPage.navigateToHomePage();
        setUp.driver.quit();
    }

    @When("User searches for a list of products in casti category")
    public void userSearchesForAListOfProductsInCastiCategory() {
        setUp.searchCastiPage = setUp.homePage.goToSearchCastiPage("Casti");
    }

    @Then("Show a list of casti products")
    public void showAListOfCastiProducts() {
        setUp.searchCastiPage.checkForCastiPage();
    }

    @When("User filters the list based on reviews")
    public void userFiltersTheListBasedOnReviews() {
        setUp.searchCastiPage.filterByNrOfReviews();
    }

    @When("User writes in the search field the product name and presses on cauta button")
    public void userWritesInTheSearchFieldTheProductNameAndPressesOnCautaButton() {
        setUp.searchTelevizoarePage = setUp.homePage.goToSearchTelevizoarePage("Televizoare");
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
    public void navigateOnDiagonalaDisplayOfTheFirstProduct() {
        setUp.searchTelevizoarePage.waitForVisibilityOfElement();
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
    public void userSelectsDesiredProductToSeeHisReview() {
        setUp.searchCastiPage.selectProductByReview();
    }

    //
//    @Then("Show selected product page info")
//    public void showSelectedProductPageInfo() {
//    }
//
    @And("Product review is displayed in console")
    public void productReviewIsDisplayedInConsole() {
        setUp.searchCastiPage.displayProductReview();
    }

    @Then("User types in the search bar mouse")
    public void userTypesInTheSearchBarMouse() {
        setUp.searchMousePage = setUp.homePage.goToSearchMousePage("Mouse");
    }

    @And("User sorts a list of products in ascending order")
    public void userSortsAListOfProductsInAscendingOrder() {
        setUp.searchMousePage.selectMouseProducts();
        setUp.searchMousePage.selectAscendingPriceDropDown();
    }

    @When("User adds the first three products to the cart")
    public void userAddsTheFirstThreeProductsToTheCart() {
        setUp.searchMousePage.addProductsToCart();
    }

    @Then("The three products should be in my shopping cart")
    public void theThreeProductsShouldBeInMyShoppingCart() {
        setUp.basketPage = setUp.searchMousePage.goToBasketPage();
        setUp.basketPage.checkPresenceOfMouses();
    }

    @When("User delete the products from the cart")
    public void userDeleteTheProductsFromTheCart() {
        setUp.basketPage.deleteMouseProducts();
    }

    @Then("The shopping cart must be empty")
    public void theShoppingCartMustBeEmpty() {
        setUp.basketPage.emptyBasketValidation();
    }
}

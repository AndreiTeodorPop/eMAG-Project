package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImplementationSearch {

    SetUp setUp = new SetUp();

    //Commnon methods

    @Given("User opens eMAG home page")
    public void userOpensEmagHomePage() throws Throwable {
        setUp.logger.configure();
        // setUp.driver.get("https://www.emag.ro/");
        setUp.homePage.validationHomePage();
    }

    @And("User navigates to home page and quit the browser")
    public void userNavigatesToHomePageAndQuitTheBrowser() {
        setUp.logger.resetConfiguration();
        setUp.basketPage.navigateToHomePage();
        setUp.driver.quit();
    }

    @Then("The shopping cart must be empty")
    public void theShoppingCartMustBeEmpty() {
        setUp.basketPage.emptyBasketValidation();
    }

 //Scenario nr. 1
//
//    @When("User searches for Product in search bar")
//    public void userSearchesForProductInSearchBar() {
//        setUp.logger.logger.info("Now running scenario nr.1");
//        setUp.searchTastaturaPage = setUp.homePage.goToSearchTastaturaPage(setUp.constants.getTastaturiTextForSearch());
//    }

//
//    @When("^User searches for \"(.*)\" in search bar$")
//    public void userSearchesForInSearchBar(String Product) throws Throwable{
//        setUp.logger.logger.info("Now running scenario nr.1");
//        setUp.searchTastaturaPage = setUp.homePage.goToSearchTastaturaPage(Product);
//    }
//
//    @And("User selects eMAG genius products")
//    public void userSelectsEMAGGeniusProducts() {
//        setUp.helper.scrollToElement(setUp.searchTastaturaPage.getCheckEmagGenius());
//        setUp.searchTastaturaPage.selectEmagGenius();
//    }
//
//    @Then("User adds products to cart")
//    public void userAddsProductsToCart() {
//        setUp.helper.scrollToElement(setUp.searchTastaturaPage.getAddProductOne());
//        setUp.searchTastaturaPage.addElements();
//    }
//
//    @Then("User checks that the products are added to cart")
//    public void userChecksThatTheProductsAreAddedToCart() {
//        setUp.searchTastaturaPage.goToBasketPage();
//        setUp.basketPage.checkTastaturaProductsIsDisplayed(setUp.searchTastaturaPage.getFirstProductText(), setUp.searchTastaturaPage.getSecondProductText());
//        System.out.println(setUp.searchTastaturaPage.getFirstProductText());
//        System.out.println(setUp.searchTastaturaPage.getSecondProductText());
//    }
//
//    @And("User deletes all the products from cart")
//    public void userDeletesAllTheProductsFromCart() {
//        setUp.helper.waitVisibility10seconds(setUp.basketPage.getDeleteFirstProduct());
//        setUp.basketPage.deleteTastaturaProducts();
//    }

//Scenario nr. 2

//    @When("User searches for a list of products in casti category")
//    public void userSearchesForAListOfProductsInCastiCategory() {
//        setUp.logger.logger.info("Now running scenario nr.2");
//        setUp.searchCastiPage = setUp.homePage.goToSearchCastiPage(setUp.constants.getCastiTextForSearch());
//    }
//
//    @Then("Show a list of casti products")
//    public void showAListOfCastiProducts() {
//        setUp.searchCastiPage.checkForCastiPage();
//    }
//
//    @When("User filters the list based on reviews")
//    public void userFiltersTheListBasedOnReviews() {
//        setUp.helper.scrollToElement(setUp.searchCastiPage.getDropDownOrderByReviews());
//        setUp.searchCastiPage.filterByNrOfReviews();
//    }
//
//    @And("User selects desired product to see his review")
//    public void userSelectsDesiredProductToSeeHisReview() {
//        setUp.helper.scrollToElement(setUp.searchCastiPage.getProductReviewButton());
//        setUp.searchCastiPage.selectProductByReview();
//    }
//
//    @Then("Show selected product page info")
//    public void showSelectedProductPageInfo() {
//        setUp.searchCastiPage.checkForFirstCastiProductPage();
//    }
//
//    @And("Product review is displayed in console")
//    public void productReviewIsDisplayedInConsole() {
//        setUp.searchCastiPage.displayProductReview();
//    }

 //   Scenario nr. 3

    @When("User writes in the search field the product name and presses on cauta button")
    public void userWritesInTheSearchFieldTheProductNameAndPressesOnCautaButton() {
        setUp.logger.logger.info("Now running scenario nr.3");
        //setUp.searchTelevizoarePage = setUp.homePage.goToSearchTelevizoarePage(setUp.constants.getTelevizoareTextForSearch());
    }

    @Then("All products from televizoare are displayed")
    public void allProductsFromTelevizoareAreDisplayed() {
        setUp.searchTelevizoarePage.productsTvAreDisplayed();
    }

    @And("User filters from disponibilitate products which are resigilate")
    public void userFiltersFromDisponibilitateProductsWhichAreResigilate() {
        setUp.helper.scrollToElement(setUp.searchTelevizoarePage.getFilterResigilate());
        setUp.searchTelevizoarePage.filterTvFromDisponibilitate();
    }

    @When("Navigate on diagonala display of the first product")
    public void navigateOnDiagonalaDisplayOfTheFirstProduct() {
        setUp.helper.waitVisibility10seconds(setUp.searchTelevizoarePage.getMeniuDeSelectie());
        setUp.helper.waitVisibility10seconds(setUp.searchTelevizoarePage.getVarianteDiagonalaDisplayed());
        setUp.searchTelevizoarePage.selectDiagonalaDisplay();
    }

    @And("Add the product to shopping basket")
    public void addTheProductToShoppingBasket() {
        setUp.helper.scrollToElement(setUp.searchTelevizoarePage.getCumparaResigilatButton());
        setUp.searchTelevizoarePage.addToShoppingBasket();
    }

    @Then("Check if the product is in the shopping basket")
    public void checkIfTheProductIsInTheShoppingBasket() {
        setUp.searchTelevizoarePage.goToBasketPage();
        setUp.basketPage.checkTvProductsIsDisplayed();
    }

    @Then("Delete the product from shopping basket")
    public void deleteTheProductFromShoppingBasket() {
        setUp.basketPage.deleteTelevizorProduct();
    }

    //scenario nr. 4

    @And("User types in the search bar mouse")
    public void userTypesInTheSearchBarMouse() {
        setUp.logger.logger.info("Now running scenario nr.4");
        //setUp.searchMousePage = setUp.homePage.goToSearchMousePage(setUp.constants.getMouseTextForSearch());
    }

    @And("User sorts a list of products in ascending order")
    public void userSortsAListOfProductsInAscendingOrder() {
        setUp.searchMousePage.selectMouseProducts();
        setUp.helper.waitVisibility10seconds(setUp.searchMousePage.getMouseText());
        setUp.searchMousePage.selectAscendingPriceDropDown();
    }

    @When("User adds the first three products to the cart")
    public void userAddsTheFirstThreeProductsToTheCart() {
        setUp.helper.scrollToElement(setUp.searchMousePage.getAddToCartProduct1());
        setUp.searchMousePage.addProductsToCart();
    }

    @Then("The three products should be in my shopping cart")
    public void theThreeProductsShouldBeInMyShoppingCart() {
        setUp.basketPage = setUp.searchMousePage.goToBasketPage();
        setUp.basketPage.checkMouseProductsIsDisplayed(setUp.searchMousePage.getProduct1StrText(), setUp.searchMousePage.getProduct2StrText(), setUp.searchMousePage.getProduct3StrText());
    }

    @When("User delete the products from the cart")
    public void userDeleteTheProductsFromTheCart() {
        setUp.basketPage.deleteMouseProducts();
    }

}

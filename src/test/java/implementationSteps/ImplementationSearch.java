package implementationSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

public class ImplementationSearch {


    WebDriver driver;
    SetUp setUp = new SetUp(driver);

//    @Before
//    @Given("^User opens eMAG home page$")
//    public void beforeScenario(){
//        System.out.println("This will run before the Scenario");
//        setUp.logger.configure();
//        setUp.homePage.validationHomePage();
//        setUp.homePage.isLoaded();
//    }
//
//    @After
//    @And("^User navigates to home page and quit the browser$")
//    public void afterScenario(){
//        System.out.println("This will run after the Scenario");
//        setUp.logger.resetConfiguration();
//        setUp.basketPage.navigateToHomePage();
//        setUp.driver.quit();
//    }

    //Before and After



//    @Given("^User opens eMAG home page$")
//    public void userOpensEmagHomePage(){
//        setUp.logger.configure();
//        setUp.homePage.validationHomePage();
//        setUp.homePage.isLoaded();
////        driver.findElement(By.id("searchboxTrigger")).sendKeys("tastatura");
//    }
//
//    @And("^User navigates to home page and quit the browser$")
//    public void userNavigatesToHomePageAndQuitTheBrowser() {
//        setUp.logger.resetConfiguration();
//        setUp.basketPage.navigateToHomePage();
////        setUp.driver.quit();
//    }

//    @Given("^User opens eMAG home page$")
//    public void userOpensEmagHomePage(){
//        //setUp.mySetUp();
//        setUp.logger.configure();
//        setUp.homePage.validationHomePage();
//        setUp.homePage.isLoaded();
////        driver.findElement(By.id("searchboxTrigger")).sendKeys("tastatura");
//    }
//
//    @And("^User navigates to home page and quit the browser$")
//    public void userNavigatesToHomePageAndQuitTheBrowser() {
//        setUp.logger.resetConfiguration();
//        setUp.basketPage.navigateToHomePage();
////        setUp.driver.quit();
    //}

    @Then("^The shopping cart must be empty$")
    public void theShoppingCartMustBeEmpty() {
        setUp.basketPage.emptyBasketValidation();
    }

 //Scenario nr. 1

//    @When("User searches for Product in search bar")
//    public void userSearchesForProductInSearchBar() {
//        setUp.logger.logger.info("Now running scenario nr.1");
//        setUp.homePage.writeOnSearchBox(setUp.constants.getTastaturiTextForSearch());
//        setUp.searchTastaturaPage = setUp.homePage.goToSearchTastaturaPage();
//    }
//
//
//    @When("^User searches for (.*) in search bar$")
//    public void userSearchesForInSearchBar(String product) throws Throwable{
//        setUp.logger.logger.info("Now running scenario nr.1");
//        setUp.homePage.writeOnSearchBox(product);
//        setUp.searchTastaturaPage = setUp.homePage.goToSearchTastaturaPage();
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

    @When("^User searches for (.*) in search box$")
    public void userSearchesForAListOfProductsInCastiCategory(String product) {
        setUp.logger.logger.info("Now running scenario nr.2");
        setUp.homePage.writeOnSearchBox(product);
        setUp.searchCastiPage = setUp.homePage.goToSearchCastiPage();
    }

    @Then("Show a list of casti products")
    public void showAListOfCastiProducts() {
        setUp.searchCastiPage.checkForCastiPage();
    }

    @When("User filters the list based on reviews")
    public void userFiltersTheListBasedOnReviews() {
        setUp.helper.scrollToElement(setUp.searchCastiPage.getDropDownOrderByReviews());
        setUp.searchCastiPage.filterByNrOfReviews();
    }

    @And("User selects desired product to see his review")
    public void userSelectsDesiredProductToSeeHisReview() {
        setUp.helper.scrollToElement(setUp.searchCastiPage.getProductReviewButton());
        setUp.searchCastiPage.selectProductByReview();
    }

    @Then("Show selected product page info")
    public void showSelectedProductPageInfo() {
        setUp.searchCastiPage.checkForFirstCastiProductPage();
    }

    @And("Product review is displayed in console")
    public void productReviewIsDisplayedInConsole() {
        setUp.searchCastiPage.displayProductReview();
    }

 //   Scenario nr. 3

    @When("^User writes in the search field the (.*) name and presses on cauta button$")
    public void userWritesInTheSearchFieldTheProductNameAndPressesOnCautaButton(String product) {
        setUp.logger.logger.info("Now running scenario nr.3");
        setUp.homePage.writeOnSearchBox(product);
        setUp.searchTelevizoarePage = setUp.homePage.goToSearchTelevizoarePage();
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

    @And("^User types in the search bar (.*)$")
    public void userTypesInTheSearchBarMouse(String product) {
        setUp.logger.logger.info("Now running scenario nr.4");
        setUp.homePage.writeOnSearchBox(product);
        setUp.searchMousePage = setUp.homePage.goToSearchMousePage();
    }

    @And("User sorts a list of products in ascending order")
    public void userSortsAListOfProductsInAscendingOrder() {
//        setUp.searchMousePage.load();
//        setUp.searchMousePage.isLoaded();
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

    //Parametrization

    @And("^User types (.*) in the search bar$")
    public void userTypesProductInTheSearchBar(String product) throws Throwable{
        setUp.homePage.writeOnSearchBox(product);
        setUp.homePage.clickOnSearchButton();
    }

    @And("User adds the first two products to the cart")
    public void userAddsTheFirstTwoProductsToTheCart() {
        setUp.helper.scrollToElement(setUp.homePage.getAddToCartProduct1());
        setUp.homePage.addProductsToCart();
    }

    @When("User delete all products from the cart")
    public void userDeleteAllProductsFromTheCart() {
        setUp.basketPage = setUp.homePage.goToBasketPage();
        setUp.helper.scrollToElement(setUp.basketPage.getDeleteFirstProduct());
        setUp.basketPage.deleteProduct();
        setUp.helper.scrollToElement(setUp.basketPage.getDeleteFirstProduct());
        setUp.basketPage.deleteProduct();
    }
}

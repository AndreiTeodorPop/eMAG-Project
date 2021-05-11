//package implementationSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = {"Cases"}, glue = {"StepsToTest"})
//
//public class ImplementationSearchTastatura {
//
//
//    WebDriver driver;
//    SetUp setUp;
//
//    @When("^User searches for (.*) in search bar$")
//    public void userSearchesForProductInSearchBar(String product) {
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
//}

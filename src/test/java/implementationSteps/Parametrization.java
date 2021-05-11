//package implementationSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.When;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class Parametrization {
//
//
//    WebDriver driver;
//    SetUp setUp = new SetUp();
//
//    @And("^User types (.*) in the search bar$")
//    public void userTypesProductInTheSearchBar(String product) throws Throwable{
//        setUp.homePage.writeOnSearchBox(product);
//        setUp.homePage.clickOnSearchButton();
//    }
//
//    @And("User adds the first two products to the cart")
//    public void userAddsTheFirstTwoProductsToTheCart() {
//        setUp.helper.scrollToElement(setUp.homePage.getAddToCartProduct1());
//        setUp.homePage.addProductsToCart();
//    }
//
//    @When("User delete all products from the cart")
//    public void userDeleteAllProductsFromTheCart() {
//        setUp.basketPage = setUp.homePage.goToBasketPage();
//        setUp.helper.scrollToElement(setUp.basketPage.getDeleteFirstProduct());
//        setUp.basketPage.deleteProduct();
//        setUp.helper.scrollToElement(setUp.basketPage.getDeleteFirstProduct());
//        setUp.basketPage.deleteProduct();
//    }
//}

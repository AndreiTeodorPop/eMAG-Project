package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ImplementationSearchCasti {

    WebDriver driver;
    SetUp setUp = new SetUp(driver);

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
}

package implementationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ImplementationLogin {

    WebDriver driver;

    @Given("User accesses eMAG website")
    public void browserIsOpen(){}
    @When("User enters his email address and his password")
    public void userEntersHisEmailAddressAndHisPassword() { }
    @Then("User succesfully login into his account")
    public void userSuccesfullyLoginIntoHisAccount() { }
    @And("User goes on his account")
    public void userGoesOnHisAccount() { }
    @Then("User updates his home address")
    public void userUpdatesHisHomeAddress() { }
    @And("User navigates on the main page")
    public void userNavigatesOnTheMainPage() { }
}

package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user_login_email")
    private WebElement fieldEmail;
    @FindBy(id="user_login_continue")
    private  WebElement continueEmailButton;
    @FindBy(id="user_login_password")
    private WebElement fieldPassword;
    @FindBy(id="user_login_continue")
    private WebElement continuePasswordButton;


    public LoginPage insertEmail(String email){
        fieldEmail.clear();
        fieldEmail.sendKeys(email);
        continueEmailButton.click();
        return this;
    }

//    public void loginInMyAccount(){
//        String email="";
//        String password="";
//        getFieldEmail().click();
//        getFieldEmail().sendKeys(email);
//        getContinueEmailButton().click();
//        getFieldPassword().click();
//    }


}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h2[text()=\"New User Signup!\"]")
    public WebElement newUserSignUpText ;

    @FindBy (xpath = "//input[@name=\"name\"]")
    public WebElement nameBox ;

    @FindBy (xpath = "(//input[@name=\"email\"])[2]")
    public WebElement registerEmailBox ;

    @FindBy (xpath = "//button[text()=\"Signup\"]")
    public WebElement signupButton ;

    @FindBy (xpath = "//*[text()=\"Login to your account\"]")
    public WebElement loginToYourAccountText ;

    @FindBy (xpath = "(//input[@name=\"email\"])[1]")
    public WebElement loginEmailBox ;

    @FindBy (xpath = "(//input[@name=\"password\"])")
    public WebElement passwordBox ;

    @FindBy (xpath = "//*[text()=\"Login\"]")
    public WebElement loginButton ;

    @FindBy (xpath = "//*[text()=\"Your email or password is incorrect!\"]")
    public WebElement warningMessage ;
}

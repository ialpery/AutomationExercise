package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//i[@class=\"fa fa-home\"]")
    public WebElement homeButton;

    @FindBy (xpath = "//a[@href=\"/login\"]")
    public WebElement signupButton ;

    @FindBy (xpath = "//*[contains(text(),\"Logged in\")]")
    public WebElement loggedInText ;

    @FindBy (xpath = "//*[contains(text(),\"Delete\")]")
    public WebElement deleteAccountButton ;

}

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

    @FindBy (xpath = "//*[contains(text(),\"Logout\")]")
    public WebElement logoutButton ;

    @FindBy (xpath = "//*[text()=\" Contact us\"]")
    public WebElement contactUsButton ;

    @FindBy (xpath = "//*[(text()=\" Test Cases\")]")
    public WebElement testCasesButton ;

    @FindBy (xpath = "//*[(text()=\" Products\")]")
    public WebElement productsButton ;

    @FindBy (xpath = "//div[@class=\"single-widget\"]/form/p")
    public WebElement footerText ;

    @FindBy (xpath = "//*[text()=\"Subscription\"]")
    public WebElement subscriptionText ;

    @FindBy (id = "susbscribe_email")
    public WebElement subscribeEmail ;

    @FindBy (id = "subscribe")
    public WebElement subscribeButton ;

    @FindBy (id = "success-subscribe")
    public WebElement successSubscribeMessage ;



}

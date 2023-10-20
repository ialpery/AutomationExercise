package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountCreatedPage {

    public AccountCreatedPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[text()=\"Account Created!\"]")
    public WebElement accountCreatedText ;

    @FindBy (xpath = "//*[text()=\"Continue\"]")
    public WebElement continueButton ;



}

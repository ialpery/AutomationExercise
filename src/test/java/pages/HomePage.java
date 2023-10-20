package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//i[@class=\"fa fa-home\"]")
    public WebElement homeButton;

    @FindBy (xpath = "//a[@href=\"/login\"]")
    public WebElement signupButton ;

}

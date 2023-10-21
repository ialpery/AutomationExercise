package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {

    public ContactUsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[text()=\"Get In Touch\"]")
    public WebElement getInTouchText ;

    @FindBy (xpath = "//input[@name=\"name\"]")
    public WebElement nameBox ;

    @FindBy (xpath = "//input[@name=\"email\"]")
    public WebElement emailBox ;

    @FindBy (xpath = "//input[@name=\"subject\"]")
    public WebElement subjectBox ;

    @FindBy (id = "message")
    public WebElement messageBox ;

    @FindBy (xpath = "//input[@name=\"upload_file\"]")
    public WebElement uploadFileButton ;

    @FindBy (xpath = "//input[@name=\"submit\"]")
    public WebElement submitButton ;



}

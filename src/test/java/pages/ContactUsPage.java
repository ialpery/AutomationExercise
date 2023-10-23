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

    @FindBy (name = "name")
    public WebElement nameBox ;

    @FindBy (name = "email")
    public WebElement emailBox ;

    @FindBy (name = "subject")
    public WebElement subjectBox ;

    @FindBy (id = "message")
    public WebElement messageBox ;

    @FindBy (name = "upload_file")
    public WebElement uploadFileButton ;

    @FindBy (xpath = "//input[@name=\"submit\"]")
    public WebElement submitButton ;

    @FindBy (xpath = "(//div[contains(text(),\"Your details\")])[1]")
    public WebElement successMessage ;

    @FindBy (xpath = "//*[(text()=\" Home\")]")
    public WebElement homeButton ;

}

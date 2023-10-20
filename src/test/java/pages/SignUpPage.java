package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class SignUpPage {

    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[contains(text(),\"Enter Account\")]")
    public WebElement title ;

    @FindBy (id = "id_gender1")
    public WebElement selectMr ;

    @FindBy (id = "password")
    public WebElement passwordBox ;

    @FindBy (id = "days")
    public WebElement selectDay ;

    @FindBy (id = "months")
    public WebElement selectMonth ;

    @FindBy (id = "years")
    public WebElement selectYear ;

    @FindBy (xpath = "//*[text()=\"Address Information\"]")
    public WebElement addressInformationTitle ;

    @FindBy (id = "first_name")
    public WebElement firstNameBox ;

    @FindBy (id = "last_name")
    public WebElement lastNameBox ;

    @FindBy (id = "company")
    public WebElement companyBox ;

    @FindBy (id = "address1")
    public WebElement addressBox ;

    @FindBy (id = "country")
    public WebElement selectCountry ;

    @FindBy (id = "state")
    public WebElement stateBox ;

    @FindBy (id = "city")
    public WebElement cityBox ;

    @FindBy (id = "zipcode")
    public WebElement zipcodeBox ;

    @FindBy (id = "mobile_number")
    public WebElement mobileNumberBox ;

    @FindBy (xpath = "//*[text()=\"Create Account\"]")
    public WebElement createAccountButton ;











}

package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountCreatedPage {

    public AccountCreatedPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}

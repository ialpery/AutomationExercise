package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class T05_Logout extends tests.T01_Register{


    @Test
    public void logout () {

        registerTest();

        homePage.signupButton.click();

        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

        Assert.assertEquals(homePage.loggedInText.getText(), "Logged in as " + ConfigReader.getProperty("userName"));

        homePage.logoutButton.click();
        loginPage.loginToYourAccountText.isDisplayed();

        Driver.closeDriver();

    }

}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import tests.T01_Register ;

public class T03_LoginCorrectUser extends tests.T01_Register {

    @Test
    public void loginCorrectUser () {

        registerTest();

        homePage.signupButton.click();

        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

        Assert.assertEquals(homePage.loggedInText.getText(), "Logged in as " + ConfigReader.getProperty("userName"));

        homePage.deleteAccountButton.click();


        Assert.assertTrue(deleteAccountPage.accountDeletedText.isDisplayed());
        deleteAccountPage.continueButton.click();

        Driver.closeDriver();

    }

}

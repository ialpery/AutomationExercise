package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class T06_RegisterWithExistingUser extends tests.T01_Register {

    @Test
    public void registerExistingEmail () {

        registerTest();

        homePage.signupButton.click();
        loginPage.newUserSignUpText.isDisplayed();
        loginPage.nameBox.sendKeys(ConfigReader.getProperty("userName"));
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.signupButton.click();

        Assert.assertEquals(loginPage.registerWarningMessage.getText(), "Email Address already exist! ");

        Driver.closeDriver();

    }

}

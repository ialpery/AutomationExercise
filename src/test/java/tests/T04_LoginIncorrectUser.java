package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class T04_LoginIncorrectUser {


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void loginIncorrectUser () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.signupButton.click();


        loginPage.loginToYourAccountText.isDisplayed();
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("incorrectEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("incorrectPassword"));
        loginPage.loginButton.click();

        loginPage.loginWarningMessage.isDisplayed();

        Driver.closeDriver();

    }

}

package tests;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class T01_Register {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();

    ContactUsPage contactUsPage = new ContactUsPage() ;
    @Test
    public void registerTest () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.signupButton.click();


        loginPage.newUserSignUpText.isDisplayed();
        loginPage.nameBox.sendKeys(ConfigReader.getProperty("userName"));
        loginPage.registerEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.signupButton.click();


        signUpPage.title.isDisplayed();
        signUpPage.selectMr.click();
        signUpPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));

        Select ddDays = new Select(signUpPage.selectDay);
        ddDays.selectByVisibleText(ConfigReader.getProperty("selectDay"));

        Select ddMonths = new Select(signUpPage.selectMonth);
        ddMonths.selectByVisibleText(ConfigReader.getProperty("selectMonth"));

        Select ddYears = new Select(signUpPage.selectYear);
        ddYears.selectByVisibleText(ConfigReader.getProperty("selectYear"));


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", signUpPage.addressInformationTitle);

        signUpPage.firstNameBox.sendKeys(ConfigReader.getProperty("firstName"));
        signUpPage.lastNameBox.sendKeys(ConfigReader.getProperty("lastName"));
        signUpPage.companyBox.sendKeys(ConfigReader.getProperty("companyName"));
        signUpPage.addressBox.sendKeys(ConfigReader.getProperty("address"));

        Select ddCountry = new Select(signUpPage.selectCountry);
        ddCountry.selectByVisibleText(ConfigReader.getProperty("country"));

        signUpPage.stateBox.sendKeys(ConfigReader.getProperty("state"));
        signUpPage.cityBox.sendKeys(ConfigReader.getProperty("city"));
        signUpPage.zipcodeBox.sendKeys(ConfigReader.getProperty("zipcode"));
        signUpPage.mobileNumberBox.sendKeys(ConfigReader.getProperty("mobileNumber"));
        signUpPage.createAccountButton.click();


        Assert.assertTrue(accountCreatedPage.accountCreatedText.isDisplayed());
        accountCreatedPage.continueButton.click();

        Assert.assertTrue(homePage.loggedInText.isDisplayed());
        Assert.assertEquals(homePage.loggedInText.getText(), "Logged in as " + ConfigReader.getProperty("userName"));
    }
    @Test
    public void deleteAccount () {

        homePage.deleteAccountButton.click();


        Assert.assertTrue(deleteAccountPage.accountDeletedText.isDisplayed());
        deleteAccountPage.continueButton.click();

        Driver.closeDriver();
    }

    @Test
    public void loginCorrectUser () {

        registerTest();

        homePage.signupButton.click();

        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButton.click();

        Assert.assertEquals(homePage.loggedInText.getText(), "Logged in as " + ConfigReader.getProperty("userName"));

        deleteAccount();

    }

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

    }

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

    }

    @Test
    public void registerExistingEmail () {

        registerTest();

        homePage.signupButton.click();
        loginPage.newUserSignUpText.isDisplayed();
        loginPage.nameBox.sendKeys(ConfigReader.getProperty("userName"));
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.signupButton.click();

        Assert.assertEquals(loginPage.registerWarningMessage.getText(), "Email Address already exist! ");

    }

    @Test
    public void uploadFile () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.contactUsButton.click();

        String actualGetInTouchText = contactUsPage.getInTouchText.getText();
        String expectedGetInTouchText = "GET IN TOUCH" ;

        Assert.assertEquals(actualGetInTouchText, expectedGetInTouchText);



    }


}

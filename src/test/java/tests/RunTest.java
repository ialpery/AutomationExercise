package tests;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

public class RunTest {

    @Test
    public void test01 () throws InterruptedException {

        Driver.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage();

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.signupButton.click();

        LoginPage loginPage = new LoginPage();

        loginPage.newUserSignUpText.isDisplayed();
        loginPage.nameBox.sendKeys("Alper");
        loginPage.emailBox.sendKeys("test1@alper.com");
        loginPage.signupButton.click();

        SignUpPage signUpPage = new SignUpPage();

        signUpPage.title.isDisplayed();
        signUpPage.selectMr.click();
        signUpPage.passwordBox.sendKeys("123456");

        Select ddDays = new Select(signUpPage.selectDay);
        ddDays.selectByVisibleText("20");

        Select ddMonths = new Select(signUpPage.selectMonth);
        ddMonths.selectByVisibleText("October");

        Select ddYears = new Select(signUpPage.selectYear);
        ddYears.selectByVisibleText("2020");


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", signUpPage.addressInformationTitle);

        signUpPage.firstNameBox.sendKeys("Alper");
        signUpPage.lastNameBox.sendKeys("Test");
        signUpPage.companyBox.sendKeys("Apple");
        signUpPage.addressBox.sendKeys("Test Street, Test Apartment, No:12/6");

        Select ddCountry = new Select(signUpPage.selectCountry);
        ddCountry.selectByVisibleText("Canada");

        signUpPage.stateBox.sendKeys("Istanbul");
        signUpPage.cityBox.sendKeys("Istanbul");
        signUpPage.zipcodeBox.sendKeys("34340");
        signUpPage.mobileNumberBox.sendKeys("05554442200");
        signUpPage.createAccountButton.click();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();

        Assert.assertTrue(accountCreatedPage.accountCreatedText.isDisplayed());
        accountCreatedPage.continueButton.click();

        Assert.assertTrue(homePage.loggedInText.isDisplayed());
        homePage.deleteAccountButton.click();

        DeleteAccountPage deleteAccountPage = new DeleteAccountPage();
        Assert.assertTrue(deleteAccountPage.accountDeletedText.isDisplayed());
        deleteAccountPage.continueButton.click();




        Driver.closeDriver();
    }


}

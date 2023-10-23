package tests;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class T01_Register {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        SignUpPage signUpPage = new SignUpPage();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage();
        ContactUsPage contactUsPage = new ContactUsPage();
        ProductsPage productsPage = new ProductsPage();
        ProductDetailPage productDetailPage = new ProductDetailPage();
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

        Driver.closeDriver();

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

        Driver.closeDriver();

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

        Driver.closeDriver();

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

        Driver.closeDriver();

    }

    @Test
    public void uploadFile () throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.contactUsButton.click();

        String actualGetInTouchText = contactUsPage.getInTouchText.getText();
        String expectedGetInTouchText = "GET IN TOUCH" ;

        Assert.assertEquals(actualGetInTouchText, expectedGetInTouchText);

        contactUsPage.nameBox.sendKeys(ConfigReader.getProperty("userName"));
        contactUsPage.emailBox.sendKeys(ConfigReader.getProperty("email"));
        contactUsPage.subjectBox.sendKeys("Somewhere elsewhere anywhere");
        contactUsPage.messageBox.sendKeys(ConfigReader.getProperty("contactUsMessage"));
        contactUsPage.uploadFileButton.sendKeys("/Users/ibrahimalperyigit/Downloads/IMG_3998.png");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        contactUsPage.submitButton.click();
        Thread.sleep(3000);
        Alert alert = Driver.getDriver().switchTo().alert();

        alert.dismiss();

        js.executeScript("arguments[0].scrollIntoView();", contactUsPage.homeButton);

        contactUsPage.successMessage.isDisplayed();
        contactUsPage.homeButton.click();

        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        Driver.closeDriver();

    }

    @Test
    public void verifyTestCasePage () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.testCasesButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("test_cases"));

        Driver.closeDriver();

    }

    @Test
    public void productsPage () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.productsButton.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("products"));

        String actualAllProductsTitle = productsPage.allProductsText.getText();
        String expectedAllProductsTitle = "ALL PRODUCTS";

        Assert.assertEquals(actualAllProductsTitle, expectedAllProductsTitle);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", productsPage.babyhugBrand);

        productsPage.firstViewProduct.click();
        productDetailPage.productName.isDisplayed();
        productDetailPage.category.isDisplayed();
        productDetailPage.price.isDisplayed();
        productDetailPage.availability.isDisplayed();
        productDetailPage.condition.isDisplayed();
        productDetailPage.brand.isDisplayed();

        Driver.closeDriver();

    }

    @Test
    public void searchProduct () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.productsButton.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("products"));

        String actualAllProductsTitle = productsPage.allProductsText.getText();
        String expectedTitle = "ALL PRODUCTS";

        Assert.assertEquals(actualAllProductsTitle, expectedTitle);

        productsPage.searchProductBox.sendKeys(ConfigReader.getProperty("searchingProduct"));
        productsPage.submitSearch.click();

        String actualSearchedProductsText = productsPage.searchedProductsText.getText();
        String expectedSearchedProductsText = "SEARCHED PRODUCTS";

        Assert.assertEquals(actualSearchedProductsText, expectedSearchedProductsText);

        productsPage.listedProducts.isDisplayed();

        Driver.closeDriver();

    }

    @Test
    public void verifySubscription () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", homePage.footerText);

        String actualSubscriptionText = homePage.subscriptionText.getText();
        String expectedSubscriptionText = "SUBSCRIPTION";

        Assert.assertEquals(actualSubscriptionText, expectedSubscriptionText);

        homePage.subscribeEmail.sendKeys(ConfigReader.getProperty("email"));
        homePage.subscribeButton.click();
        homePage.successSubscribeMessage.isDisplayed();

        Driver.closeDriver();


    }


}

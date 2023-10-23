package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class T11_VerifySubscription {

    HomePage homePage = new HomePage();

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

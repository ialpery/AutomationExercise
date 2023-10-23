package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class T08_VerifyTestCasePage {

    HomePage homePage = new HomePage();

    @Test
    public void verifyTestCasePage () {

        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));

        var homeColor = homePage.homeButton.getCssValue("color");
        Assert.assertEquals(homeColor, "rgba(255, 165, 0, 1)");

        homePage.testCasesButton.click();
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("test_cases"));

        Driver.closeDriver();

    }

}

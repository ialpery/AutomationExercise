package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class RunTest {

    @Test
    public void test01 () {

        Driver.getDriver().get("http://automationexercise.com");

        HomePage homePage = new HomePage();

        var homeColor = homePage.homeButton.getCssValue("color");
        System.out.println(homeColor);

        Driver.closeDriver();
    }


}

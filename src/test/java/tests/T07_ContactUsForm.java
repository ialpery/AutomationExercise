package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class T07_ContactUsForm {

    HomePage homePage = new HomePage();
    ContactUsPage contactUsPage = new ContactUsPage();

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

}

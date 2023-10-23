package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import utilities.Driver;

public class T02_DeleteAccount {

    HomePage homePage = new HomePage();
    DeleteAccountPage deleteAccountPage = new DeleteAccountPage();
    @Test
    public void deleteAccount () {

        homePage.deleteAccountButton.click();


        Assert.assertTrue(deleteAccountPage.accountDeletedText.isDisplayed());
        deleteAccountPage.continueButton.click();

        Driver.closeDriver();
    }

}

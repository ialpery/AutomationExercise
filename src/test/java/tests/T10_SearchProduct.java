package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class T10_SearchProduct {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();

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

}

package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class T09_ProductDetailPage {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
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


}

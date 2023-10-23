package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[text()=\"All Products\"]")
    public WebElement allProductsText ;

    @FindBy (xpath = "//*[text()=\"Babyhug\"]")
    public WebElement babyhugBrand ;

    @FindBy (xpath = "(//*[text()=\"View Product\"])[1]")
    public WebElement firstViewProduct ;

    @FindBy (id = "search_product")
    public WebElement searchProductBox ;

    @FindBy (id = "submit_search")
    public WebElement submitSearch ;

    @FindBy (xpath = "//h2[@class=\"title text-center\"]")
    public WebElement searchedProductsText ;

    @FindBy (xpath = "//div[@class=\"col-sm-4\"]")
    public WebElement listedProducts ;



}

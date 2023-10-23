package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductDetailPage {

    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[text()=\"Blue Top\"]")
    public WebElement productName ;

    @FindBy (xpath = "//*[contains(text(),\"Category:\")]")
    public WebElement category ;

    @FindBy (xpath = "//div[@class=\"product-information\"]/span/span")
    public WebElement price ;

    @FindBy (xpath = "//*[contains(text(),\"Availability:\")]")
    public WebElement availability ;

    @FindBy (xpath = "//*[contains(text(),\"Condition:\")]")
    public WebElement condition ;

    @FindBy (xpath = "//*[contains(text(),\"Brand:\")]")
    public WebElement brand ;

}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private final By productName =
            By.xpath("//div[@class='product-information']//h2");

    private final By category =
            By.xpath("//div[@class='product-information']//p[contains(text(),'Category:')]");

    private final By price =
            By.xpath("//div[@class='product-information']//span[contains(text(),'Rs.')]");

    private final By availability =
            By.xpath("//div[@class='product-information']//b[contains(text(),'Availability:')]/parent::p");

    private final By condition =
            By.xpath("//div[@class='product-information']//b[contains(text(),'Condition:')]/parent::p");

    private final By brand =
            By.xpath("//div[@class='product-information']//b[contains(text(),'Brand:')]/parent::p");

    private final By quantityInput =
            By.id("quantity");

    private final By addToCartButton =
            By.xpath("//button[contains(@class,'cart')]");

    private final By viewCartButton =
            By.xpath("//u[contains(text(),'View Cart')]");

    private final By continueShoppingButton =
            By.xpath("//button[contains(text(),'Continue Shopping')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getCategory() {
        return getText(category);
    }

    public String getPrice() {
        return getText(price);
    }

    public String getAvailability() {
        return getText(availability);
    }

    public String getCondition() {
        return getText(condition);
    }

    public String getBrand() {
        return getText(brand);
    }

    public boolean isProductDetailsDisplayed() {
        return isDisplayed(productName)
                && isDisplayed(category)
                && isDisplayed(price)
                && isDisplayed(availability)
                && isDisplayed(condition)
                && isDisplayed(brand);
    }

    public void enterQuantity(String quantity) {
        type(quantityInput, quantity);
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }

    public void clickViewCart() {
        click(viewCartButton);
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }
}

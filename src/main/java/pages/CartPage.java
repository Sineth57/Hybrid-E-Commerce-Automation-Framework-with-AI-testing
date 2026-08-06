package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By cartRows =
            By.cssSelector("#cart_info_table tbody tr");

    private final By productNames =
            By.cssSelector("#cart_info_table tbody tr .cart_description h4 a");

    private final By productPrices =
            By.cssSelector("#cart_info_table tbody tr .cart_price p");

    private final By productQuantities =
            By.cssSelector("#cart_info_table tbody tr .cart_quantity button");

    private final By productTotals =
            By.cssSelector("#cart_info_table tbody tr .cart_total p");

    private final By removeButtons =
            By.cssSelector("#cart_info_table tbody tr .cart_quantity_delete");

    private final By proceedToCheckoutButton =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    private final By registerLoginLink =
            By.xpath("//u[contains(text(),'Register / Login')]");

    private final By emptyCartMessage =
            By.xpath("//b[contains(text(),'Cart is empty')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return driver.findElements(cartRows).size();
    }

    public boolean isProductDisplayed(String expectedProductName) {
        List<WebElement> names = driver.findElements(productNames);

        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(expectedProductName)) {
                return true;
            }
        }

        return false;
    }

    public String getFirstProductName() {
        List<WebElement> names = driver.findElements(productNames);

        if (names.isEmpty()) {
            throw new RuntimeException("No product is available in the cart.");
        }

        return names.get(0).getText();
    }

    public String getFirstProductPrice() {
        List<WebElement> prices = driver.findElements(productPrices);

        if (prices.isEmpty()) {
            throw new RuntimeException("No product price is available in the cart.");
        }

        return prices.get(0).getText();
    }

    public String getFirstProductQuantity() {
        List<WebElement> quantities = driver.findElements(productQuantities);

        if (quantities.isEmpty()) {
            throw new RuntimeException("No product quantity is available in the cart.");
        }

        return quantities.get(0).getText();
    }

    public String getFirstProductTotal() {
        List<WebElement> totals = driver.findElements(productTotals);

        if (totals.isEmpty()) {
            throw new RuntimeException("No product total is available in the cart.");
        }

        return totals.get(0).getText();
    }

    public void removeFirstProduct() {
        List<WebElement> buttons = driver.findElements(removeButtons);

        if (buttons.isEmpty()) {
            throw new RuntimeException("No remove button is available in the cart.");
        }

        buttons.get(0).click();
    }

    public void removeProductByIndex(int index) {
        List<WebElement> buttons = driver.findElements(removeButtons);

        if (index < 0 || index >= buttons.size()) {
            throw new IllegalArgumentException("Invalid product index: " + index);
        }

        buttons.get(index).click();
    }

    public void clickProceedToCheckout() {
        click(proceedToCheckoutButton);
    }

    public boolean isRegisterLoginLinkDisplayed() {
        return isDisplayed(registerLoginLink);
    }

    public void clickRegisterLogin() {
        click(registerLoginLink);
    }

    public boolean isCartEmpty() {
        return isDisplayed(emptyCartMessage);
    }
}

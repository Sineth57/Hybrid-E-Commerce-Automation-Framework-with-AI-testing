package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By allProductsTitle =
            By.xpath("//h2[contains(text(),'All Products')]");

    private final By searchedProductsTitle =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    private final By searchInput =
            By.id("search_product");

    private final By searchButton =
            By.id("submit_search");

    private final By productCards =
            By.xpath("//div[contains(@class,'productinfo')]");

    private final By productNames =
            By.xpath("//div[contains(@class,'productinfo')]//p");

    private final By addToCartButtons =
            By.xpath("//div[contains(@class,'productinfo')]//a[contains(@class,'add-to-cart')]");

    private final By continueShoppingButton =
            By.xpath("//button[contains(text(),'Continue Shopping')]");

    private final By viewCartButton =
            By.xpath("//u[contains(text(),'View Cart')]");

    private final By viewProductLinks =
            By.xpath("//a[contains(text(),'View Product')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsDisplayed() {
        return isDisplayed(allProductsTitle);
    }

    public boolean isSearchedProductsDisplayed() {
        return isDisplayed(searchedProductsTitle);
    }

    public void searchProduct(String productName) {
        type(searchInput, productName);
        click(searchButton);
    }

    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    public List<String> getProductNames() {
        List<String> names = new java.util.ArrayList<>();

        for (WebElement productName : driver.findElements(productNames)) {
            names.add(productName.getText());
        }

        return names;
    }

    public void addFirstProductToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);

        if (buttons.isEmpty()) {
            throw new RuntimeException("No Add to Cart buttons were found.");
        }

        WebElement firstProductButton = buttons.get(0);

        Actions actions = new Actions(driver);
        actions.moveToElement(firstProductButton).perform();

        waitForClickable(addToCartButtons).click();
    }

    public void addSecondProductToCart() {
        List<WebElement> buttons = driver.findElements(addToCartButtons);

        if (buttons.size() < 2) {
            throw new RuntimeException("At least two products are required.");
        }

        WebElement secondProductButton = buttons.get(1);

        Actions actions = new Actions(driver);
        actions.moveToElement(secondProductButton).perform();

        secondProductButton.click();
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }

    public void clickViewCart() {
        click(viewCartButton);
    }

    public void clickFirstViewProduct() {
        List<WebElement> viewProductButtons =
                driver.findElements(viewProductLinks);

        if (viewProductButtons.isEmpty()) {
            throw new RuntimeException("No View Product links were found.");
        }

        viewProductButtons.get(0).click();
    }
}

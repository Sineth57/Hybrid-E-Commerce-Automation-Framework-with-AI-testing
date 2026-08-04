package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By productsLink = By.xpath("//a[contains(text(),'Products')]");
    private By cartLink = By.xpath("//a[contains(text(),'Cart')]");
    private By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignupLogin() {
        click(signupLoginLink);
    }

    public void clickProducts() {
        click(productsLink);
    }

    public void clickCart() {
        click(cartLink);
    }

    public boolean isLoggedInAsDisplayed() {
        return isDisplayed(loggedInAsText);
    }

}

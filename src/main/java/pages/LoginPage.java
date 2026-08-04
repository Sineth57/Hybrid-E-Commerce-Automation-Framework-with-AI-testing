package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    private By signupNameInput = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By newUserSignupText = By.xpath("//h2[contains(text(),'New User Signup!')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewUserSignupDisplayed() {
        return isDisplayed(newUserSignupText);
    }

    public void enterSignupName(String name) {
        type(signupNameInput, name);
    }

    public void enterSignupEmail(String email) {
        type(signupEmailInput, email);
    }

    public void clickSignupButton() {
        click(signupButton);
    }

    public void enterLoginEmail(String email) {
        type(loginEmailInput, email);
    }

    public void enterLoginPassword(String password) {
        type(loginPasswordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMessage);
    }

    public void login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }

    public void signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        clickSignupButton();
    }

}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By logoutLink =
            By.xpath("//a[contains(text(),'Logout')]");

    private final By deleteAccountLink =
            By.xpath("//a[contains(text(),'Delete Account')]");

    private final By accountDeletedText =
            By.xpath("//b[@data-qa='account-deleted']");

    private final By continueButton =
            By.xpath("//a[@data-qa='continue-button']");

    private final By loggedInUserText =
            By.xpath("//a[contains(text(),'Logged in as')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedInUserDisplayed() {
        return isDisplayed(loggedInUserText);
    }

    public void logout() {
        click(logoutLink);
    }

    public void deleteAccount() {
        click(deleteAccountLink);
    }

    public boolean isAccountDeletedDisplayed() {
        return isDisplayed(accountDeletedText);
    }

    public void clickContinue() {
        click(continueButton);
    }

}

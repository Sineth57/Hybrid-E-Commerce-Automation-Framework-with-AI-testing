package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {

    // Initial signup section
    private final By signupNameInput =
            By.xpath("//input[@data-qa='signup-name']");

    private final By signupEmailInput =
            By.xpath("//input[@data-qa='signup-email']");

    private final By signupButton =
            By.xpath("//button[@data-qa='signup-button']");

    // Account information section
    private final By enterAccountInformationText =
            By.xpath("//b[contains(text(),'Enter Account Information')]");

    private final By titleMrRadio =
            By.id("id_gender1");

    private final By titleMrsRadio =
            By.id("id_gender2");

    private final By passwordInput =
            By.id("password");

    private final By daysDropdown =
            By.id("days");

    private final By monthsDropdown =
            By.id("months");

    private final By yearsDropdown =
            By.id("years");

    private final By newsletterCheckbox =
            By.id("newsletter");

    private final By specialOffersCheckbox =
            By.id("optin");

    private final By firstNameInput =
            By.id("first_name");

    private final By lastNameInput =
            By.id("last_name");

    private final By companyInput =
            By.id("company");

    private final By addressInput =
            By.id("address1");

    private final By address2Input =
            By.id("address2");

    private final By countryDropdown =
            By.id("country");

    private final By stateInput =
            By.id("state");

    private final By cityInput =
            By.id("city");

    private final By zipCodeInput =
            By.id("zipcode");

    private final By mobileNumberInput =
            By.id("mobile_number");

    private final By createAccountButton =
            By.xpath("//button[@data-qa='create-account']");

    // Account confirmation section
    private final By accountCreatedText =
            By.xpath("//b[@data-qa='account-created']");

    private final By continueButton =
            By.xpath("//a[@data-qa='continue-button']");

    public SignupPage(WebDriver driver) {
        super(driver);
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

    public boolean isAccountInformationDisplayed() {
        return isDisplayed(enterAccountInformationText);
    }

    public void selectTitleMr() {
        click(titleMrRadio);
    }

    public void selectTitleMrs() {
        click(titleMrsRadio);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select daySelect = new Select(waitForVisibility(daysDropdown));
        daySelect.selectByVisibleText(day);

        Select monthSelect = new Select(waitForVisibility(monthsDropdown));
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(waitForVisibility(yearsDropdown));
        yearSelect.selectByVisibleText(year);
    }

    public void selectNewsletter() {
        if (!isSelected(newsletterCheckbox)) {
            click(newsletterCheckbox);
        }
    }

    public void selectSpecialOffers() {
        if (!isSelected(specialOffersCheckbox)) {
            click(specialOffersCheckbox);
        }
    }

    public void enterFirstName(String firstName) {
        type(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameInput, lastName);
    }

    public void enterCompany(String company) {
        type(companyInput, company);
    }

    public void enterAddress(String address) {
        type(addressInput, address);
    }

    public void enterAddress2(String address2) {
        type(address2Input, address2);
    }

    public void selectCountry(String country) {
        Select countrySelect = new Select(waitForVisibility(countryDropdown));
        countrySelect.selectByVisibleText(country);
    }

    public void enterState(String state) {
        type(stateInput, state);
    }

    public void enterCity(String city) {
        type(cityInput, city);
    }

    public void enterZipCode(String zipCode) {
        type(zipCodeInput, zipCode);
    }

    public void enterMobileNumber(String mobileNumber) {
        type(mobileNumberInput, mobileNumber);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }

    public boolean isAccountCreatedDisplayed() {
        return isDisplayed(accountCreatedText);
    }

    public void clickContinue() {
        click(continueButton);
    }

    private boolean isSelected(By locator) {
        return waitForVisibility(locator).isSelected();
    }
}

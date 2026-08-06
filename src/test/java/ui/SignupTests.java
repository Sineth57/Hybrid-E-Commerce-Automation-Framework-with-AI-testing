package ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;

public class SignupTests extends BaseTest {

    @Test
    public void verifyUserRegistration() {

        String name = "Test User";
        String email = "testuser" + System.currentTimeMillis() + "@example.com";
        String password = "Password@123";

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        SignupPage signupPage = new SignupPage(driver);

        signupPage.enterSignupName(name);
        signupPage.enterSignupEmail(email);
        signupPage.clickSignupButton();

        Assert.assertTrue(
                signupPage.isAccountInformationDisplayed(),
                "Account information section is not displayed."
        );

        signupPage.selectTitleMr();
        signupPage.enterPassword(password);
        signupPage.selectDateOfBirth("10", "May", "2000");
        signupPage.selectNewsletter();
        signupPage.selectSpecialOffers();

        signupPage.enterFirstName("Test");
        signupPage.enterLastName("User");
        signupPage.enterCompany("Test Company");
        signupPage.enterAddress("123 Main Street");
        signupPage.enterAddress2("Apartment 4");
        signupPage.selectCountry("India");
        signupPage.enterState("Western");
        signupPage.enterCity("Negombo");
        signupPage.enterZipCode("11500");
        signupPage.enterMobileNumber("0771234567");

        signupPage.clickCreateAccount();

        Assert.assertTrue(
                signupPage.isAccountCreatedDisplayed(),
                "ACCOUNT CREATED confirmation is not displayed."
        );

        signupPage.clickContinue();

        Assert.assertTrue(
                homePage.isLoggedInAsDisplayed(),
                "Logged-in user text is not displayed."
        );
    }
}

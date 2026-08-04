package ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {


    @Test
    public void verifyLoginWithInvalidCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wronguser@gmail.com", "wrongpassword");

        String actualError = loginPage.getLoginErrorMessage();
        String expectedError = "Your email or password is incorrect!";

        Assert.assertEquals(actualError, expectedError, "Error message mismatch for invalid login.");
    }

    @Test
    public void verifySignupLoginPageIsDisplayed() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLogin();

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isNewUserSignupDisplayed(), "New User Signup text is not displayed.");
    }

}

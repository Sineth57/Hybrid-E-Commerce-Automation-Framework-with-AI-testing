package base;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    protected ConfigReader configReader;

    @BeforeMethod
    public void setUp() {
        configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        DriverFactory.setDriver(browser);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(configReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();

    }

}
package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir")
                + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

        try {
            FileUtils.copyFile(source, new File(destinationPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
        return destinationPath;
    }
}

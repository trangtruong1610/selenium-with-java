package utils.Driver;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {
    public static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    public static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void initWebdriverObject(){
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webdriverThread = new DriverFactory();
            webDriverThreadPool.add(webdriverThread);
            return webdriverThread;
        });
    }

    public static WebDriver getChromedriver(){
        return driverThread.get().getChromeDriver();
    }

    public static WebDriver getWebdriver(String browserName){
        return driverThread.get().getWebdriver(browserName);
    }

    @AfterSuite(alwaysRun = true)
    public void afterMethod(){
        for (DriverFactory driver : webDriverThreadPool){
            driver.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenShotIfFail(ITestResult result){
        getChromedriver().manage().deleteAllCookies();

        long millisecond = ZonedDateTime.now().toInstant().toEpochMilli();
        if (result.getStatus() == ITestResult.FAILURE) {
            // Get the test method name
            String testName = result.getName();

            // Declare file location
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testName + millisecond + ".png";

            // Save screenshot
            File screenshot = ((TakesScreenshot) driverThread.get().getChromeDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                try (InputStream is = Files.newInputStream(content)) {
                    Allure.addAttachment(testName, is);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

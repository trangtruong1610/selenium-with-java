package utils.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
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

    public static WebDriver getWebdriver(){
        return driverThread.get().getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterMethod(){
        for (DriverFactory driver : webDriverThreadPool){
            driver.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void takeScreenShotIfFail(ITestResult result){
        getWebdriver().manage().deleteAllCookies();

        long millisecond = ZonedDateTime.now().toInstant().toEpochMilli();
        if (result.getStatus() == ITestResult.FAILURE) {
            // Get the test method name
            String testName = result.getName();

            // Declare file location
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testName + millisecond + ".png";

            // Save screenshot
            File screenshot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(fileLocation));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

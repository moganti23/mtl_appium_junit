package com.saucelabs.appium;

import cucumber.junit.Cucumber;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by sriramangajala on 06/05/2014.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(
        format = {"html:target/cucumber"},
        tags = "@new")
public class RunTests {
    static boolean IOS = StepDefs.IOS;
    static WebDriver driver;
    @BeforeClass
    public static void start() throws MalformedURLException {

        if(IOS)
        {
        // set up appium
        File appDir = new File("/Users/sriramangajala/Documents/Mobile Test Lab/DerivedData/Mobile Test Lab/Build/Products/Debug-iphoneos");
        //   System.getProperty("user.dir"), "../../../apps/TestApp/build/Products/Debug-iphonesimulator");
        File app = new File(appDir, "Mobile Test Lab.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iPhone");
        //  capabilities.setCapability(CapabilityType.VERSION, "6.0");
//        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
//       capabilities.setCapability("device", "f4b142312f145977759228c1fdb5eb8d8b7cd40e");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("appium-version", "1.0");
//          capabilities.setCapability("appium-version", "1.0");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "7.1");
            capabilities.setCapability("deviceName", "iPhone Retina (4-inch)");
//        driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
            try {
                driver = new SwipeableWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium-version", "1.0");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "3.2");
            capabilities.setCapability("app", "/Users/sriramangajala/Downloads/TestLab_11_06_14.apk");
            capabilities.setCapability("appPackage", "com.tvishi.testlab");
            capabilities.setCapability("appActivity", "MainActivity");
            driver = new SwipeableWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }
    public static class SwipeableWebDriver extends RemoteWebDriver implements HasTouchScreen {
        private RemoteTouchScreen touch;

        public SwipeableWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
            super(remoteAddress, desiredCapabilities);
            touch = new RemoteTouchScreen(getExecuteMethod());
        }

        public TouchScreen getTouch() {
            return touch;
        }
    }

    @AfterClass
    public static void stop()
    {
       // driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}

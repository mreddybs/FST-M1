package activities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    //declare Android driver
    AndroidDriver<MobileElement>driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "05cb4df10405");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
    }
    @Test
    public void additiontest() {
        driver.findElementById("btn_2_s").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("btn_6_s").click();
        driver.findElementByAccessibilityId("equals").click();
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("8"));
    }
    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}
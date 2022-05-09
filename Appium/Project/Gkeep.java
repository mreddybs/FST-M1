package Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Gkeep {
    //declare Android driver
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "05cb4df10405");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver ,5);
    }
    @Test
    public void GoogleKeep() {
        //locating the Create New Note
        driver.findElementByAccessibilityId("New text note").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
       //Adding the Title for Note
        driver.findElementById("editable_title").click();
        driver.findElementById("editable_title").setValue("Task1");

      //Adding the Description for the added Task
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
        driver.findElementById("edit_note_text").click();
        driver.findElementById("edit_note_text").setValue("NotesDescription");

        //clicking back button
       driver.findElementByAccessibilityId("Navigate up").click();

       //Adding assertions

        String Notes = driver.findElementById("index_note_title").getText();
        Assert.assertEquals(Notes,"Task1");
        System.out.println("the Notes added is:"+Notes);

    }
    @AfterClass
    public void tearDown() {
        // Close app
         driver.quit();
    }
}
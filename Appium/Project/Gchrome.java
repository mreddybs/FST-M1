package Project;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Gchrome {
    //declare Android driver
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
   // Scanner keyboard = new Scanner(System.in);
   //  System.out.println("enter an integer");
   // int i = keyboard.nextInt();

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "05cb4df10405");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void additiontest() {
        driver.get("https://www.training-support.net/selenium");

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));

        // Scroll element into view and click it
        driver.findElement(
                        MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List\"))"))
                .click();

        // Wait for the AddTask element to load

        for (int x = 0; x < 5; x++) {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText")));
            driver.findElementByXPath("//android.widget.EditText").click();

            driver.findElementByXPath("//android.widget.EditText").setValue("addtask"+x);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text ='Add Task']")));
            driver.findElementByXPath("//android.widget.Button[@text ='Add Task']").click();

            //driver.findElementById("taskInput").setValue("1Taskadded");
        }}
            //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText")));
           // driver.findElementByXPath("//android.widget.EditText").click();

        @AfterClass
        public void tearDown () {
            // Close app
            //  driver.quit();
        }

    }
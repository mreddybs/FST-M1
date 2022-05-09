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

public class Gtask {
           //declare Android driver
            AndroidDriver<MobileElement> driver;
        WebDriverWait wait;
        @BeforeClass
        public void setUp() throws MalformedURLException {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceId", "05cb4df10405");
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.google.android.apps.tasks");
            caps.setCapability("appActivity", ".ui.TaskListsActivity");
            caps.setCapability("noReset", true);

            // Instantiate Appium Driver
            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<>(appServer, caps);
            wait = new WebDriverWait(driver ,5);
        }
        @Test
        public void GoogleTask() {

            for (int x = 0; x < 3; x++){
                driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
                wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
                //adding the Task title
                MobileElement taskcre = driver.findElementById("add_task_title");
                  taskcre .sendKeys("Task"+x)  ;
                wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
                driver.findElementById("add_task_done").click();

              //Checking for the added Notes
                String Notes = driver.findElementById("task_name").getText();
                Assert.assertEquals(Notes,"Task"+x);
                System.out.println("the Notes added is:"+Notes);

             //Moving the added Task to Completed
                wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_item_completed_check")));
                driver.findElementById("tasks_item_completed_check").click();
        }
        }
        @AfterClass
        public void tearDown() {
            // Close app
            driver.quit();
        }
    }

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void CheckMenu() {

        WebElement username=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        WebElement MenuActivities= driver.findElement(By.id("grouptab_3"));
        Boolean Exists= MenuActivities.isDisplayed();
        String Menu = MenuActivities.getText();
        System.out.println("Activities menu exists:"+Exists);
        Assert.assertEquals("ACTIVITIES",Menu);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
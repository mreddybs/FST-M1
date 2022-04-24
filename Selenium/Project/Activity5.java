import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void GetColor() {

        WebElement username=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();
        String color=driver.findElement(By.xpath("//*[@id=\"ajaxHeader\"]/nav/div/div[1]")).getCssValue("color");

        System.out.println("Color of navigation menu:"+color);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
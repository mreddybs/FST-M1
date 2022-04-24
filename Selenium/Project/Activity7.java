import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void ReadAddInfo() {

        WebElement username=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        WebElement sales = driver.findElement(By.id("grouptab_0"));
        sales.click();
        WebElement leads= driver.findElement(By.id("moduleTab_9_Leads"));
        leads.click();
        System.out.println("leads selected");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='suitepicon suitepicon-action-info'])[2]")));
        WebElement addInfo=driver.findElement(By.xpath("(//*[@class='suitepicon suitepicon-action-info'])[2]"));
        addInfo.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-15")));

        WebElement number = driver.findElement(By.xpath(".//div[@id='ui-id-5']/span"));
        String mobile = number.getText();
        System.out.println("MobileNo is:" + mobile);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
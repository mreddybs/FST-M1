import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity9 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void TraversingTables2() {

        WebElement username=driver.findElement(By.id("user_name"));
        WebElement password= driver.findElement(By.id("username_password"));

        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        driver.findElement(By.id("grouptab_0")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr/td"));
        for (int i = 1; i <= rows.size(); i++) {
            for (int j = 1; j <= rows.size(); j++) {
                if (i <= 10)
                {
                    if (j == 3 || j == 8) {
                        WebElement row = driver.findElement(
                                By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr[" + i + "]/td[" + j + "]"));
                        System.out.println("Row " + i + ": " + row.getText());
                    }
                }
            }
        }
        }

        @AfterMethod
        public void afterMethod() {
            //Close the browser
            driver.close();
        }

    }
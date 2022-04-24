import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void HeaderImageUrl() {

            WebElement header=driver.findElement(By.className("//a[@title='SuiteCRM']"));

            String url=header.getAttribute("href");

            //Print the Header Image URL
            System.out.println("Header URL:"+url);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
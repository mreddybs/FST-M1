import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.gmail.com");

        driver.close();
    }
}

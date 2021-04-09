import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Setup {
    //Set up the tests in Selenium

    public FirefoxDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait up to 10 seconds before throwing an error for missing elements
        driver.manage().window().maximize();
    }

    @After
    public void takedown() {
        driver.quit();
    }
}

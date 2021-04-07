import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Setup {
    //Set up the tests in Selenium

    public FirefoxDriver driver;
    //public ChromeDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait up to 10 seconds before throwing an error for missing elements
        //about WebDriver Wait in Selenium 4: https://stackoverflow.com/questions/58993667/webdriverwait-is-deprecated-in-selenium-4
        //driver.manage().window().maximize();
    }

    @After
    public void takedown() {
        driver.quit();
    }
}

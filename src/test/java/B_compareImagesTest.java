import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class B_compareImagesTest {
    @Test
    public void testAgainstBaseline() throws InterruptedException {
        //create a full-page image of the URLs in the list, but this time in the "observed" folder

        //set-up
        System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");

        for (int i = 0; i < URLs.list.length; i++) {
            FirefoxDriver driver = new FirefoxDriver();//start a new, fresh browser for each web page
            driver.manage().window().maximize();
            String URL = URLs.list[i];
            driver.get(URL);
            Thread.sleep(3000);//wait for the page to fully load
            Screenshot.compareImage(driver);
            driver.quit();

        }
    }
}

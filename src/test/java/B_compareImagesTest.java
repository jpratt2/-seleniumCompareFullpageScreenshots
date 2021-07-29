import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class B_compareImagesTest {
    @Test
    public void testAgainstBaseline() throws InterruptedException {
        //create a full-page image of the URLs in the list, but this time in the "observed" folder

        WebDriverManager.firefoxdriver().setup();// set up the path to the driver

        //////***this variable can be set for a custom list for "retest", etc.*************
        String[] urlList = URLs.mainList;
        ////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < urlList.length; i++) {
            FirefoxDriver driver = new FirefoxDriver();//start a new, fresh browser for each web page
            driver.manage().window().maximize();
            String URL = urlList[i];
            driver.get(URL);
            Thread.sleep(3000);//wait for the page to fully load
            Screenshot.compareImage(driver);
            driver.quit();

        }
    }
}

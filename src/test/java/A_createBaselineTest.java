import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class A_createBaselineTest {

    @Test
    public void createBaselineImages() throws InterruptedException {
        //create a full-page image of the URLs in URLs.list

        WebDriverManager.firefoxdriver().setup();

        for(int i = 0; i < URLs.list.length; i++){
            FirefoxDriver driver = new FirefoxDriver();//start a new, fresh browser for each web page
            driver.manage().window().maximize();
            String URL = URLs.list[i];
            driver.get(URL);
            Thread.sleep(3000); //wait for the page to fully load
            Screenshot.fullpage(driver);
            driver.quit();

        }
    }



}

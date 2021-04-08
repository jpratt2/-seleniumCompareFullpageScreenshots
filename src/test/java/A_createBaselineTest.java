import org.junit.Test;
import java.io.IOException;


public class A_createBaselineTest extends Setup {

    @Test
    public void createBaselineImages() throws InterruptedException {
        //create a full-page image of the URLs in URLs.list
        for(int i = 0; i < URLs.list.length; i++){
            String URL = URLs.list[i];
            driver.get(URL);
            Thread.sleep(3000); //wait for the page to fully load
            Screenshot.fullpage(driver);
        }
    }



}

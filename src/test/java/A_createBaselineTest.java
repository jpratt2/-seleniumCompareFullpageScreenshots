import org.junit.Test;
import java.io.IOException;


public class A_createBaselineTest extends Setup {

    @Test
    public void createBaselineImages() throws IOException, InterruptedException {
        //create a full-page image of the URLs in URLs.list
        for(int i = 0; i < URLs.list.length; i++){
            String URL = URLs.list[i];
            driver.get(URL);
            Thread.sleep(5000);//wait for the page to fully load, which the screenshot tool needs
            Screenshot.fullpage(driver);
        }
    }



}

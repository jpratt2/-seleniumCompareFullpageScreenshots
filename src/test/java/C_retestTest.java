import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C_retestTest {
    @Test
    public void _01_testAgainstBaseline()  {
        //create a full-page image of the URLs in the list in the "observed" folder

        Library.UrlLoop(URLs.retest,Screenshot::compareImage);
        Library.UrlLoopTwiceLoaded(URLs.retestTwiceLoaded,Screenshot::compareImage);

    }

}

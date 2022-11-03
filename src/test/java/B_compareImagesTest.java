import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;


public class B_compareImagesTest {
    @Test
    public void _01_testAgainstBaseline() {
        //create a full-page image of the URLs in the list in the "observed" folder

        Library.UrlLoop(URLs.list,Screenshot::compareImage);
        Library.UrlLoopTwiceLoaded(URLs.listTwiceLoaded,Screenshot::compareImage);

    }

}

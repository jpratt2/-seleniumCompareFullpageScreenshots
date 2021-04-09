import org.junit.Test;


public class B_compareImagesTest extends Setup{
    @Test
    public void testAgainstBaseline() throws InterruptedException {
        //create a full-page image of the URLs in the list, but this time in the "observed" folder

        for (int i = 0; i < URLs.list.length; i++) {
            String URL = URLs.list[i];
            driver.get(URL);
            Thread.sleep(3000);//wait for the page to fully load
            Screenshot.compareImage(driver);
        }
    }
}

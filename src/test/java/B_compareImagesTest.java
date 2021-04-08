import org.junit.Test;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

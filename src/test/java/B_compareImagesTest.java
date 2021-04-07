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
        //Why? because the Shutterbug instance works better at taking images, not comparing them
        //(Why? because it needs more of a wait after taking the 2nd image to compare)

        Integer pixelThreshold = 0;//amount of pixels that can be different and still be reported as a match.

        for (int i = 0; i < URLs.list.length; i++) {
            String URL = URLs.list[i];
            driver.get(URL);
            Thread.sleep(5000);//wait for the page to fully load, which the screenshot tool needs
            Screenshot2.fullpage(driver, "observed");
        }

        //use AShot to compare the 2 images
        //see https://github.com/pazone/ashot for more info

        //read data for baseline image ("expected" folder)
        String url = driver.getCurrentUrl();// in case there was a redirect, get the most recent URL as the filename
        String fileName = Utilities.convertUrlToFileName(url);
        String pathToExpected = System.getProperty("user.dir") + File.separator + "expected" + File.separator + fileName + ".png";
        BufferedImage imgExpected = null;
        try {
            imgExpected = ImageIO.read(new File(pathToExpected));
        } catch (IOException e) {
            //read image resource https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
        }

        //read data for the observed image ("observed" folder)
        String pathToObserved = System.getProperty("user.dir") + File.separator + "observed" + File.separator + fileName + ".png";
        BufferedImage imgObserved = null;
        try {
            imgObserved = ImageIO.read(new File(pathToObserved));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //generate a diff of these 2 images if any difference exists
        ImageDiff diff = new ImageDiffer().makeDiff(imgExpected, imgObserved).withDiffSizeTrigger(pixelThreshold);
        if (diff.hasDiff()) {
            BufferedImage diffImage = diff.getMarkedImage();
            //save the diff image in the diffs folder
            String diffPath = System.getProperty("user.dir") + File.separator + "diffs" + File.separator + fileName + ".png";
            try {
                File outputfile = new File(diffPath);
                ImageIO.write(diffImage, "png", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

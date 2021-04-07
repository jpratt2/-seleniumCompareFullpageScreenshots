import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Screenshot {
    //this uses the full page screenshot from Selenium 4 for Firefox

    public static void fullpage(FirefoxDriver driver) throws IOException {
        byte[] imageBytes = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.BYTES);//source: https://stackoverflow.com/a/66859108/1691651
        String URL = driver.getCurrentUrl();
        String filename = Utilities.convertUrlToFileName(URL);
        String path = System.getProperty("user.dir");
        String separator = File.separator;
        Files.write(Paths.get(path+separator+"expected"+separator+filename+".png"), imageBytes);
    }
}

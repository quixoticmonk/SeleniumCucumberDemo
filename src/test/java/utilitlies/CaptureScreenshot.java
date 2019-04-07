package utilitlies;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import static utilitlies.LoggerUtil.info;

public class CaptureScreenshot {
    public static void captureScreen(Scenario scenario,WebDriver driver){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
         info(System.getProperty("user.dir")+"\\target\\screenshots\\"+scenario.getName().replaceAll("\\s+","")+"\\"+"screenshot.png");

        try {
            ImageIO.write(screenshot.getImage(), "PNG",
                    new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+scenario.getName().replaceAll("\\s+","")+"\\"+"screenshot.png"));
        } catch (IOException e) {
            info(e.getMessage());
        }

    }
}

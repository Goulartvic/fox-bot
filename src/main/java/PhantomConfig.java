import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomConfig {

    private WebDriver phantomDriver;

    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/opt/phantomjs/bin/phantomjs"
        );

         phantomDriver = new PhantomJSDriver(capabilities);
    }

    public WebDriver getPhantomDriver() {
        return phantomDriver;
    }
}

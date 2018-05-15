package configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfig {

    private WebDriver chromeDriver;

    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");

        chromeDriver = new ChromeDriver(chromeOptions);
    }

    public WebDriver getChromeDriver() {
        return chromeDriver;
    }
}

package pure.main.owner.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pure.main.owner.config.DriverConfig;

import java.net.MalformedURLException;


public class WebDriverTest {

    WebDriver driver;

    @BeforeEach
    public void initDriver() throws MalformedURLException{
        System.setProperty("webdriver.remote", "true");
        System.setProperty("webdriver.url", "https://user1:1234@selenoid.autotests.cloud/wd/hub/");
        System.setProperty("webdriver.browser", "CHROME");


        DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());
        initWebDriver(config);
    }

    private void initWebDriver(DriverConfig config){
        if (config.isRemote()) {
            DesiredCapabilities capabilities;
            switch (config.getBrowser()) {
                case CHROME: {
                    capabilities = DesiredCapabilities.chrome();
                    break;
                }
                case FIREFOX: {
                    capabilities = DesiredCapabilities.firefox();
                    break;
                }
                case OPERA: {
                    capabilities = DesiredCapabilities.opera();
                    break;
                }
                default: {
                    capabilities = DesiredCapabilities.chrome();
                }
            }

            driver = new RemoteWebDriver(config.getURL(), capabilities);
        } else {
            driver = new ChromeDriver();
        }
    }
}

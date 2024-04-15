package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.citysprint.qa.defaults.Defaults;
import org.citysprint.qa.model.BookPage;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private WebDriver driver;
    private BookPage bookpage;

    // Methods for creating a new driver or passing the previous one to the next page
    public BookPage getBookPage() {
        if (bookpage == null) {
            bookpage = new BookPage(driver);
        }
        return bookpage;
    }

    //Initialising the driver
    public WebDriver initializeDriver() throws Exception {
        //ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
        String browserType = Defaults.Browser;
        String environment = Defaults.Environment;
        if (environment.equalsIgnoreCase("local")) {

            if (browserType.equalsIgnoreCase("chrome")) {
                 driver = new ChromeDriver();
            }
            else if (browserType.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        }
        if (environment.equalsIgnoreCase("saucelabs")) {
                // Configuration for Sauce Labs
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", Defaults.USERNAME);
                sauceOptions.put("accessKey", Defaults.ACCESS_KEY);
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<CityDespatch>");
                URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");

                if (browserType.equalsIgnoreCase("chrome")) {
                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 10");
                    browserOptions.setBrowserVersion("latest");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, browserOptions);
                    driver = remoteWebDriver;
                }
                else if (browserType.equalsIgnoreCase("edge")) {
                    EdgeOptions browserOptions = new EdgeOptions();
                    browserOptions.setPlatformName("Windows 10");
                    browserOptions.setBrowserVersion("latest");
                    browserOptions.setCapability("sauce:options", sauceOptions);
                    RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, browserOptions);
                    driver = remoteWebDriver;
                }
                else if (driver == null){
                    throw new Exception("Could not create driver for environment:"+ environment+ "and browser:" +browserType);
                }
            }
            // Maximise browser window
            driver.manage().window().maximize();
            // Set Implicit Wait in seconds
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Defaults.ImplicitWait, Long.parseLong("10")));
        return driver;
    }
// Common Methods
    public String getTitle() {
        return driver.getTitle();
    }
}



package selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private WebDriver driver;

    @Before
    public void setup() {
        String pathToChromeDriver = "src/test/resources/chromedriver_win.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void cleanup() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

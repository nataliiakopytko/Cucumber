package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver {

    public static WebDriver driver;

    public ChromeWebDriver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeWebBrowser() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

}

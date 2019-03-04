package pages;

import Helping_elements.Waiter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static drivers.ChromeWebDriver.driver;

public class BehanceHomePage {

    public String loggedUrl = "https://www.behance.net/?isa0=1";

    private Logger log = Logger.getLogger(BehanceLoginPage.class);

    private final String url = "https://www.behance.net/";

    private final By signInButton = By.xpath("//a[contains(@class,'qa-adobeid-signin')]");

    private final By sentence = By.xpath("//h1[@class = 'Nav-navHeader-3xV']");

    private final By userIcon = By.xpath("//a//img[contains(@class, 'rf-primary-nav__avatar')]");

    private final String submenuElement = "//div[contains(@class, 'rf-tooltip--main')]" +
            "//a[contains(@class, 'rf-submenu__link ') and text() = '%s']";

    private WebElement submenuElementSelect(String text) {
        return driver.findElement(By.xpath(String.format(submenuElement, text)));
    }

    public void openHomePage() {
        driver.navigate().to(url);
        log.info("Driver navigated to url");
    }

    public void goToSignInPage() {
        Waiter wait = new Waiter();
        wait.waitForElement(signInButton).click();
        log.info("Sign In button on home page is clicked");
    }

    public String getLoggedUrl() {
        Waiter wait = new Waiter();
        wait.waitForElement(sentence);
        return driver.getCurrentUrl();
    }

    public void moveToSubmenuElement(String element) {
        Actions action = new Actions(driver);
        Waiter wait = new Waiter();
        wait.waitForElement(userIcon);
        WebElement icon = driver.findElement(userIcon);
        action.moveToElement(icon).perform();
        log.info("Action move to element is performed");
        action.moveToElement(submenuElementSelect(element)).click().perform();
        log.info("Action select subElement is performed");
    }
}

package pages;

import Helping_elements.Waiter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static drivers.ChromeWebDriver.driver;

public class BehanceHomePage {

    public String loggedUrl = "https://www.behance.net/?isa0=1";

    private Logger log = Logger.getLogger(BehanceLoginPage.class);

    private final String url = "https://www.behance.net/";

    private final By signInButton = By.xpath("//a[contains(@class,'qa-adobeid-signin')]");

    private final By sentence = By.xpath("//h1[@class = 'Nav-navHeader-3xV']");

    public void openHomePage(){
        driver.navigate().to(url);
        log.info("Driver navigated to url");
    }

    public void goToSignInPage(){
        Waiter wait = new Waiter();
        wait.waitForElement(signInButton).click();
        log.info("Sign In button on home page is clicked");
    }

    public String getLoggedUrl(){
        Waiter wait = new Waiter();
        wait.waitForElement(sentence);
        return driver.getCurrentUrl();
    }
}

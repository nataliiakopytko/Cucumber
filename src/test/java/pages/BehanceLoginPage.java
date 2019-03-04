package pages;

import Helping_elements.Waiter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.ChromeWebDriver.driver;

public class BehanceLoginPage {

    private Logger log = Logger.getLogger(BehanceLoginPage.class);

    private By fakeClick = By.xpath("//body[@id = 'adobesusi' and not (@class = 'container')]");

    private final By usernameInput = By.xpath("//*[@id='adobeid_username']");

    private final By passwordInput = By.xpath("//*[@id='adobeid_password']");

    private final By passwordInputInvisible = By.xpath("//*[@id='adobeid_password' and @readonly='readonly']");

    private final By checkBox = By.xpath("//span[contains(@class, 'checkbox-mark')]");

    private final By signInButton = By.id("sign_in");

    public void enterCredentials(String username, String password) {
        Waiter waiter = new Waiter();
        WebElement usernameField = waiter.waitForElement(usernameInput);
        usernameField.click();
        usernameField.sendKeys(username);
        log.info("Username is entered");

        driver.findElement(fakeClick).click();

        waiter.waitForElementToBeInvisible(passwordInputInvisible);
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.click();
        passwordField.sendKeys(password);
        log.info("Password is entered");
    }

    public void signIn() {
        driver.findElement(checkBox).click();
        log.info("Checkbox is unchecked");

        driver.findElement(signInButton).click();
        log.info("Sign In button is clicked");
    }
}

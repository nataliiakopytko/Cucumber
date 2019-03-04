package pages;

import Helping_elements.Waiter;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static drivers.ChromeWebDriver.driver;

public class BehanceProfilePage {

    private Logger log = Logger.getLogger(BehanceProfilePage.class);

    @Getter
    private By avatar = By.xpath("//div[@class = 'Profile-avatarRoot-2O-']");

    public boolean elementIsDisplayed() {
        Waiter wait = new Waiter();
        wait.waitForElement(avatar);
        try {
            driver.findElement(getAvatar());
            log.info("Avatar is found");
            return true;
        } catch (NoSuchElementException e) {
            log.info("Avatar is not found");
            return false;
        }
    }

}

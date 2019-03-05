package pages;

import Helping_elements.Waiter;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static drivers.ChromeWebDriver.driver;

public class BehanceProfilePage {

    private Logger log = Logger.getLogger(BehanceProfilePage.class);

    @Getter
    private final By avatar = By.xpath("//div[@class = 'Profile-avatarRoot-2O-']");

    private final By addBannerIcon = By.xpath("//div[@class = 'ProfileBanner-dropTarget-3Jq']");

    private final By hiddenInput = By.xpath("//div[contains(@style, 'direction: ltr')]/input[@name = 'qqfile']");

    private final String filePath = "C:\\Users\\Nataliia_Kopytko\\Downloads\\";

    private final By doneButton = By.xpath("//div[text() = 'Done']");

    @Getter
    private By uploadedPicture = By.xpath("//img[@src]//following::div[contains(@class, 'ProfileBanner-hasBanner-1fU')]");

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

    public void addBanner(String image) {
        WebElement elem = driver.findElement(hiddenInput);
        log.info("Searching for hidden input");
        String js = "arguments[0].style.overflow='visible';";
        ((JavascriptExecutor) driver).executeScript(js, elem);
        log.info("Changing overflow to 'visible'");
        elem.sendKeys(filePath + image);
        log.info("File path is inserted");
    }

    public void clickDoneButton() {
        Waiter wait = new Waiter();
        WebElement button = wait.waitForElement(doneButton);
        button.click();
        log.info("Done button is clicked");
    }

    public boolean checkPresenceOfUploadedPicture() {
        try {
            Waiter waiter = new Waiter();
            waiter.waitForElement(getUploadedPicture());
            log.info("Element is found");
            return true;
        } catch (NoSuchElementException e) {
            log.info("Element is not found");
            return false;
        }
    }
}

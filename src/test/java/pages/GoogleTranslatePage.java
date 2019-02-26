package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static drivers.ChromeWebDriver.driver;

public class GoogleTranslatePage {

    private final By moreButtonLeft = By.xpath("//div[@class = 'sl-more tlid-open-source-language-list']");

    private By firstLanguage = By.xpath("//div[@class = 'language_list_section']//div[contains(@onclick, 'sl_list_en')]");

    private By moreButtonRight = By.xpath("//div[@class = 'tl-more tlid-open-target-language-list']");

    private By secondLanguage = By.xpath("//div[@class = 'language_list_section']//div[@class = 'language_list_item_icon tl_list_uk_checkmark']");

    private By inputField = By.xpath("//textarea[@id = 'source']");

    private final By translatedWord = By.xpath("//span[@title]");

    private By definition = By.xpath("//div[@class='gt-def-info'][2]//div[@class='gt-def-row']");

    public void selectEnglish() {
        driver.findElement(moreButtonLeft).click();
        driver.findElement(firstLanguage).click();
    }

    public void selectUkrainian() {
        driver.findElement(moreButtonRight).click();
        driver.findElement(secondLanguage).click();
    }

    public void typeWord(String word) {
        driver.findElement(inputField).click();
        driver.findElement(inputField).sendKeys(word);
        driver.findElement(inputField).sendKeys(Keys.RETURN);
    }

    public String getTranslatedWord() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement waitForWord = wait.until(ExpectedConditions.visibilityOfElementLocated(translatedWord));
        return waitForWord.getText();
    }

    public int getNumberOfCharacters() {
        return getTranslatedWord().length();
    }

    public String getDefinition() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement waitForWord = wait.until(ExpectedConditions.visibilityOfElementLocated(definition));
        return waitForWord.getText();
    }
}
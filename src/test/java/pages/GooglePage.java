package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static drivers.ChromeWebDriver.driver;

public class GooglePage {

    private String url = "https://www.google.com";

    private final By searchField = By.xpath("//input[@name='q']");

    private final By firstLink = By.xpath("//h3[@class='LC20lb']");

    public void openGooglePage() {
        driver.get(url);
    }

    public WebElement getSearchField() {
        return driver.findElement(searchField);
    }

    public WebElement getFirstLink() {
        return driver.findElement(firstLink);
    }

    public void searchText(String text) {
        getSearchField().sendKeys(text);
        getSearchField().sendKeys(Keys.RETURN);
    }
}

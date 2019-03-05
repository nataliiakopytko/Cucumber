package pages;

import Helping_elements.Waiter;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static drivers.ChromeWebDriver.driver;

public class BehanceSearchPage {

    private Logger log = Logger.getLogger(BehanceLoginPage.class);

    @Getter
    private final By searchInput = By.xpath("//input[contains(@class, 'js-search-bar__input')]");

    private final By additionalFiltersButton = By.xpath("//li[contains(@class, 'js-sort-additional-filters')]");

    private final By toolsUsedButton = By.xpath("//a[@data-section = 'tool']");

    private final String popularTools = "//a[@data-value= '%s']";

    private final String filterCrumbs = "//div[@id = 'filter-crumbs']//div[contains(text(), '%s')]";

    public boolean checkSearchInput() {
        Waiter wait = new Waiter();
        try {
            wait.waitForElement(getSearchInput());
            log.info("Search input is found");
            return true;
        } catch (NoSuchElementException e) {
            log.info("Search input is not found");
            return false;
        }
    }

    public void selectAdditionalFilters() {
        driver.findElement(additionalFiltersButton).click();
        log.info("Additional Filters button is clicked");
    }

    public void selectToolsUsed() {
        Waiter wait = new Waiter();
        wait.waitForElement(toolsUsedButton).click();
        log.info("Tools Used button is clicked");
    }

    public void selectPopularTools(String text) {
        Waiter wait = new Waiter();
        wait.waitForElement(By.xpath(String.format(popularTools, text))).click();
        log.info(text + " tool is selected");
    }

    public boolean checkFilterCrumbs(String text) {
        Waiter wait = new Waiter();
        try {
            wait.waitForElement(By.xpath(String.format(filterCrumbs, text)));
            log.info("Filter crumb is found");
            return true;
        } catch (NoSuchElementException e) {
            log.info("Filter crumb is not found");
            return false;
        }
    }
}



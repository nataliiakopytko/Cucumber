package Helping_elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static drivers.ChromeWebDriver.driver;

public class Waiter {

    private Logger log = Logger.getLogger(Waiter.class);

    public WebElement waitForElement(By element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement waitForElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        log.info("Driver waits for element presence");
        return waitForElement;
    }

    public void waitForElementToBeInvisible(By element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        log.info("Driver waits for element invisibility");
    }
}

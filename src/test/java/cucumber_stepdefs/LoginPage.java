package cucumber_stepdefs;

import cucumber_tests.OpenTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPage
{
    @Given("^Open Application and Enter url$")
    public void open_Application_and_Enter_url() throws Throwable {
        OpenTests.driver.get("https://demo.openmrs.org/openmrs/login.htm");

    }

    @When("^enter username$")
    public void enter_username() throws Throwable {
        OpenTests.driver.findElement(By.id("username")).sendKeys("Admin");
    }

    @When("^enter password$")
    public void enter_password() throws Throwable {
        OpenTests.driver.findElement(By.id("password")).sendKeys("Admin123");
        OpenTests.driver.findElement(By.id("Inpatient Ward")).click();
        OpenTests.driver.findElement(By.id("loginButton")).click();
    }

    @Then("^verify Msg$")
    public void verify_Msg() throws Throwable {
        boolean result =  OpenTests.driver.findElement(By.tagName("h4")).getText().contains("Logged");
        Assert.assertTrue(result);
    }
}
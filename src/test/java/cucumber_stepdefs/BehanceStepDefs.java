package cucumber_stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BehanceHomePage;
import pages.BehanceLoginPage;
import pages.BehanceProfilePage;
import lombok.Getter;

public class BehanceStepDefs {

    BehanceHomePage homePage = new BehanceHomePage();
    BehanceLoginPage loginPage = new BehanceLoginPage();
    BehanceProfilePage profilePage = new BehanceProfilePage();

    @Given("^The user is on homepage$")
    public void theUserIsOnHomepage() {
        homePage.openHomePage();
    }

    @And("^The user clicks on Sign in button$")
    public void theUserClicksOnSignInButton() {
        homePage.goToSignInPage();
    }

    @When("^The user enters valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theUserEntersValidCredentialsAnd(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("^The user unchecks the check box - Stay signed in - and clicks on Sign In button$")
    public void theUserUnchecksTheCheckBoxStaySignedInAndClicksOnSignInButton() {
        loginPage.signIn();
    }

    @Then("^The user is logged in$")
    public void theUserIsLoggedIn() {
        Assert.assertEquals(homePage.getLoggedUrl(), homePage.loggedUrl);
    }

    @When("^The user clicks on submenu element \"([^\"]*)\"$")
    public void theUserClicksOnSubmenuElement(String element) {
        homePage.moveToSubmenuElement(element);
    }

    @Then("^the user is on selected page$")
    public void theUserIsOnTheProfilePage() {
        Assert.assertTrue(profilePage.elementIsDisplayed());
    }


}

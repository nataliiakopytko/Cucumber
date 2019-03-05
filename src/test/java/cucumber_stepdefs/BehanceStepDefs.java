package cucumber_stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.BehanceHomePage;
import pages.BehanceLoginPage;
import pages.BehanceProfilePage;
import pages.BehanceSearchPage;

import java.util.List;

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

    @When("^the user clicks on Add Banner Image Button and selects image$")
    public void theUserClicksOnAddBannerImageButtonAndSelectsImage(List<String> image) {
        for (String i : image) {
            profilePage.addBanner(i);
        }
    }

    @And("^the user clicks on Done button$")
    public void theUserClicksOnDoneButton() {
        profilePage.clickDoneButton();
    }

    @Then("^the picture is uploaded$")
    public void thePictureIsUploaded() {
        Assert.assertTrue(profilePage.checkPresenceOfUploadedPicture());
    }

    @When("^The user clicks on Search and Filter button$")
    public void theUserClicksOnSearchAndFilterButton() {
        homePage.openSearchPage();
    }

    @Then("^the user is on the search page$")
    public void theUserIsOnTheSearchPage() {
        BehanceSearchPage searchPage = new BehanceSearchPage();
        Assert.assertTrue(searchPage.checkSearchInput());
    }

    @When("^The user clicks on the Additional Filters button$")
    public void theUserClicksOnTheAdditionalFiltersButton() {
        BehanceSearchPage searchPage = new BehanceSearchPage();
        searchPage.selectAdditionalFilters();
    }

    @And("^the user clicks on Tools Used button$")
    public void theUserClicksOnToolsUsedButton() {
        BehanceSearchPage searchPage = new BehanceSearchPage();
        searchPage.selectToolsUsed();
    }

    @And("^the user clicks on \"([^\"]*)\" button$")
    public void theUserClicksOnButton(String tool)  {
        BehanceSearchPage searchPage = new BehanceSearchPage();
        searchPage.selectPopularTools(tool);

    }

    @Then("^a new filter \"([^\"]*)\" has appeared on filters menu$")
    public void aNewFilterHasAppearedOnFiltersMenu(String tool) {
        BehanceSearchPage searchPage = new BehanceSearchPage();
        Assert.assertTrue(searchPage.checkFilterCrumbs(tool));
    }
}

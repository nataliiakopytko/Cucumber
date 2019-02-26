package cucumber_stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.GooglePage;
import pages.GoogleTranslatePage;

import static org.testng.Assert.assertEquals;

public class MyStepdefs {
    GooglePage googlePage = new GooglePage();
    GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();

    @Given("^the user is on the google translate page$")
    public void theUserIsOnTheGoogleTranslatePage() {
        googlePage.openGooglePage();
        googlePage.searchText("Google Translate");
        googlePage.getFirstLink().click();
    }

    @Given("^selected languages from english to ukrainian$")
    public void selectedLanguagesFromEnglishToUkrainian() {
        googleTranslatePage.selectEnglish();
        googleTranslatePage.selectUkrainian();
    }

    @When("^the user looks up the translation of the word \"([^\"]*)\"$")
    public void theUserLooksUpTheTranslationOfTheWord(String word) {
        googleTranslatePage.typeWord(word);
    }

    @Then("^they should see the translation \"([^\"]*)\"$")
    public void theyShouldSeeTheTranslation(String translated) {
        assertEquals(googleTranslatePage.getTranslatedWord(), translated);
    }

    @Then("^the number of characters must be \"([^\"]*)\"$")
    public void theNumberOfCharactersMustBe(int number) {
        assertEquals(googleTranslatePage.getNumberOfCharacters(), number);
    }

    @Then("^they should see the definition \"([^\"]*)\"$")
    public void theyShouldSeeTheDefinition(String definition) {
        assertEquals(googleTranslatePage.getDefinition(), definition);
    }
}

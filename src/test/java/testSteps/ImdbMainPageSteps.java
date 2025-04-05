package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.ImdbMainPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class ImdbMainPageSteps {

    private final ImdbMainPage imdbMainPage;

    public ImdbMainPageSteps(ImdbMainPage imdbMainPage) {
        this.imdbMainPage = imdbMainPage;
    }

    @When("I accept cookie banner")
    public void acceptCookieBanner() {
        if(imdbMainPage.cookieBanner().exists() && imdbMainPage.cookieBanner().isDisplayed()) {
            imdbMainPage.cookieBannerAcceptButton().shouldBe(visible).click();
        } else {
            System.out.println("Cookie banner is not visible on main page");
        }
    }

    @And("I enter {} in to search field")
    public void typeInSearchField(String searchText) {
        imdbMainPage.searchBar().shouldBe(exist).setValue(searchText);
    }

    @And("I click on the first movie in the list")
    public void selectFirstMovieFromTheList() {
        imdbMainPage.searchResults().shouldBe(visible).click();
    }
}

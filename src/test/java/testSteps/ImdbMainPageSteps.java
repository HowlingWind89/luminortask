package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
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
        if(!imdbMainPage.cookieBanner().shouldBe(visible, exist).isDisplayed()) {
            System.out.println("Cookie banner is not visible on main page");
        } else {
            imdbMainPage.cookieBannerAcceptButton().shouldBe(visible).click();
        }
    }

    @And("I enter {} in to search field")
    public void typeInSearchField(String searchText) {
        imdbMainPage.searchBar().should(exist).sendKeys(searchText);
    }

    @And("I click on the first movie in the list")
    public void selectFirstMovieFromTheList() {
        imdbMainPage.searchResults().shouldBe(visible).click();
    }
}

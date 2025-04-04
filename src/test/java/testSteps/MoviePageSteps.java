package testSteps;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.MoviePage;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class MoviePageSteps {

    private final MoviePage moviePage;

    public MoviePageSteps(MoviePage moviePage) {
        this.moviePage = moviePage;
    }

    @And("Movie {} page is opened")
    public void selectFirstMovieFromTheList(String movieName) {
       Assert.assertEquals(moviePage.movieTitle().should(exist).getText(),
               movieName);
    }

    @And("5 names of top cast is printed to console")
    public void printTopActorNames() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Actor name is : " + moviePage.actorNameList().get(i).getText());
        }
    }
}

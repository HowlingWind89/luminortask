package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoviePage {

    public SelenideElement movieTitle() {
        return $(By.xpath("//span[@data-testid='hero__primary-text']"));
    }

    public ElementsCollection actorNameList() {
        return $$(By.xpath("//a[@data-testid='title-cast-item__actor']"));
    }

}

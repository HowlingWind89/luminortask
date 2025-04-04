package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ImdbMainPage {

    public SelenideElement cookieBanner() {
        return $(By.xpath("//div[@data-testid='consent-banner']"));
    }

    public SelenideElement cookieBannerAcceptButton() {
        return $(By.xpath("//button[@data-testid='accept-button']"));
    }

    public SelenideElement searchBar() {
        return $(By.xpath("//input[@id='suggestion-search']"));
    }

    public SelenideElement searchResults() {
        return $(By.xpath("(//a[@data-testid='search-result--const'])[1]"));
    }
}

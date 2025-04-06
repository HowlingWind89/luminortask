package testSteps;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import environment.EnvironmentConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final EnvironmentConfig environment;


    public Hooks (EnvironmentConfig environment) {
        this.environment = environment;
    }

    @Before
    public void openImdbPage() {
        environment.setUp();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)
                    WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        environment.tearDown();
    }
}

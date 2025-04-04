package testSteps;

import com.codeborne.selenide.logevents.SelenideLogger;
import environment.EnvironmentConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

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
    public void closeBrowser() {
        environment.tearDown();
    }
}

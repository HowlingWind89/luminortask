package environment;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import static com.codeborne.selenide.Selenide.*;

public class EnvironmentConfig {

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        System.setProperty("selenide.browser", "Chrome");

        Configuration.browserSize = "1920x1080";
        //Configuration.headless = false;
        Configuration.timeout = 10000;

        String ciEnv = System.getenv("CI");
        Configuration.headless = "true".equalsIgnoreCase(ciEnv);

        System.out.println("[Browser mode] Headless = " + Configuration.headless);

        open(WebURL.IMDB);
    }

    public void tearDown() {
        closeWebDriver();
    }
}
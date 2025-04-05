package environment;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

public class EnvironmentConfig {

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        boolean isCI = "true".equalsIgnoreCase(System.getenv("CI"));

        if (isCI) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--window-size=1920,1080");

            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                    "(KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36");
        }

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.browserCapabilities = options;

        System.out.println("[Browser mode] Headless = " + isCI);

        open(WebURL.IMDB);
    }

    public void tearDown() {
        closeWebDriver();
    }
}
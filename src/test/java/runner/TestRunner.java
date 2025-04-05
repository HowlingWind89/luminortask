package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        tags = "@Luminor",
        features = "src/test/resources/features",
        glue = "testSteps",
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
        @Test
        public void dummy() {
                // этот метод просто "помечает" класс как тест
        }
}
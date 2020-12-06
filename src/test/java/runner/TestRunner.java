package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinitions_Cucumber"},
        plugin = {"pretty", "summary", "html:target/CucumberReports/reports.html"},
        publish = true
)
public class TestRunner {
}

package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		         features = {"src/test/java/features/IncidentService.feature:8"},
		         glue = {"step.defs.som"},
		         dryRun = false,
		         plugin = {"pretty", "html:reports/cucumber-result.html"}
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
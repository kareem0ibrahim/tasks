package stepsdefinations;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "stepsdefinations",
plugin = {"pretty", "junit:target/JunitReorts/report.xml", "html:target/HtmlReports"})
public class TestRunner {

    }

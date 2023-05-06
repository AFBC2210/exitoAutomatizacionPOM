package exitoRunners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
		features = "src/test/resources/Feature/selecCatSubProd.feature"
        ,glue = {"StepDefinitions"}
        ,monochrome=true
        ,plugin= {"pretty", "json:target/JSONReports/report.json"}
		)
public class exitoRunner {
	
}

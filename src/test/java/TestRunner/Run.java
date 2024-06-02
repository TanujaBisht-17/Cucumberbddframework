package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		//features = ".//Features/LoginFeature.feature",
		features =".//Features",
		glue= "StepDefination",
		dryRun=false,
		monochrome = false,
		tags="@sumil",//can use "and"/"or"/"and not.. etc
		plugin = {"pretty","html:target/cucumber-reports/reports.html"} //all three reports can be added separated by comma
		//plugin = {"pretty","html:target/cucumber-reports/reports1.xml"}
		//plugin = {"pretty","json:target/cucumber-reports/reports_json.json"}
		) 

public class Run extends AbstractTestNGCucumberTests
{

}



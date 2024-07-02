package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features//Login.feature",

dryRun =true,
monochrome=true,
glue="steps",
publish =true)


public class LoginPageRunner extends AbstractTestNGCucumberTests{
	
	

}

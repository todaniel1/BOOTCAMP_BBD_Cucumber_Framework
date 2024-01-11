package runner_files;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = {"src/test/resources/feature_files" },
        glue     = {"step_definitions", "com.bdd.learning.Hooks"},
        tags = "@TutorialsNinjaLogin or @TutorialsNinjaRegister or @TutorialsNinjaSearchProduct or @TutorialsNinjaAddtoCart or @TutorialsNinjaLogout",
       
        plugin = {"pretty", "html:target/site/cucumber-html", 
        		"json:target/cucumber1.json",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		"com.tutorialsninja.bdd.qa.Utilities.MyCucumberListener" 
        }

   )

public class Test_Runner_TestNG extends AbstractTestNGCucumberTests{

}






 
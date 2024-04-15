package org.citysprint.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/org.citysprint.qa.features",
        glue = "org.citysprint.cityDespatchSteps",
        monochrome = true,
        //publish = true,
       // tags = "@smoke",
        plugin = {"pretty",
                "html:test-output/CucumberReport/cucumber-reports.html",
                "json:test-output/CucumberReport/cucumber.json",
                //"rerun:test-output/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)

public class cucumberTestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();
        }
}

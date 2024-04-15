package org.citysprint.cityDespatchSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.TestContext;


public class hooks {
    TestContext testContext;
    WebDriver driver;

    public hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println("Scenario:" + scenario.getName());
        this.driver = testContext.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }

        this.driver.quit();
        System.out.println("End of scenario:" + scenario.getName());

    }
}

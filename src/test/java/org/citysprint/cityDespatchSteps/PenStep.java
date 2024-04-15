package org.citysprint.cityDespatchSteps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.TestContext;

public class PenStep {

    TestContext testContext;
    // Constructor which will load the contents of the TestContext class which can be accessed through its object

    public PenStep(TestContext testContext){
        this.testContext = testContext;
    }
    @Then("I should see links with pens")
    public void i_should_see_links_with_pens() {
        String actualTitle = testContext.getTitle();
        String expectedTitle = "pen - Google Search";
        Assert.assertEquals(actualTitle,expectedTitle, "Titles did not match");
        System.out.println("Assert book");
    }
}

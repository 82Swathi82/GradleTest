package org.citysprint.cityDespatchSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.TestContext;

public class BookStep {
   TestContext testContext;
   // Constructor which will load the contents of the TestContext class which can be accessed through its object

   public BookStep(TestContext testContext){
      this.testContext = testContext;
   }
   @Given("I open the Google url")
   public void i_open_the_google_url() {
      testContext.getBookPage().getURL();
   }
   @When("I type {string}")
   public void i_type(String book) throws InterruptedException {
      testContext.getBookPage().typeBook(book);
   }
   @Then("I should see links with books")
   public void i_should_see_links_with_books() {
      String actualTitle = testContext.getTitle();
      String expectedTitle = "book - Google Search";
      Assert.assertEquals(actualTitle,expectedTitle, "Titles did not match");
      System.out.println("Assert book");
   }

}

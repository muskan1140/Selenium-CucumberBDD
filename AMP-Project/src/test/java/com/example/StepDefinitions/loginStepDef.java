package com.example.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.signature.qual.Identifier;

import static Helpers.helperClass.*;

public class loginStepDef {


    @Before
    public void driver() {
        setDriver();
    }
    @Given("^User is on the (.*) page$")
    public void user_is_on_the_signup_page(String identifier) {
      navigateToHome(identifier);
    }

    @When("^User enters (.*) in the (.*) input field$")
    public void user_enters_in_the_name_input_field(String element,String Identifiervalue){
        inputField(element,Identifiervalue);
    }
    @When("^User clicks on the (.*) button$")
    public void user_clicks_on_the_button(String identifier) {
        click(identifier);
    }
    @Then("^User navigate to the (.*)$")
    public void user_navigate_to_the_homepage(String identifier) {
      navigateToHome(identifier);
    }
}

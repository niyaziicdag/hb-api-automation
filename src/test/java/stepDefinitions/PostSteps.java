package stepDefinitions;

import io.cucumber.java.en.When;
import utils.RestUtils;

import java.io.IOException;

public class PostSteps {

    @When("Perform a POST request with {string} query")
    public void performPostRequestWithQuery(String queryValue) {
        RestUtils.performPostRequestWithQuery(queryValue);
    }
}

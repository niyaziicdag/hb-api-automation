package stepDefinitions;

import io.cucumber.java.en.When;
import utils.RestUtils;

import java.io.IOException;

public class PostSteps {

    @When("Perform a POST request with query")
    public void performPostRequestWithQuery() throws IOException {
        RestUtils.performPostRequestWithQuery();
    }
}

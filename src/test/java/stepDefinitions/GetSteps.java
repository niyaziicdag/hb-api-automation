package stepDefinitions;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.RestUtils;

public class GetSteps {

    private Response response;

    @When("perform a GET request")
    public void getRequest() {
        response = RestUtils.performGetRequest();
    }
}

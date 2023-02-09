package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.restUtil;

import java.io.IOException;

public class RestApi {
    restUtil rest=new restUtil();

    @Given("^User hits Hitachi page endpoint using the (.*)$")
    public void hitEndpoint(String keyword) throws IOException {
        rest.hitrequest(keyword);
    }

    @Then("^User verifies the (.*) for (.*) search$")
    public void verifyResult(String result,String keyword)
    {
    assert(rest.getStatus()==200);
    assert(rest.getMessage(keyword).equals(result));
    }

}

package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class restUtil {
    Response response;
    RequestSpecification request;
    propertyFileLoader prop=new propertyFileLoader();
    int Statuscode;

    boolean message;

    public void hitrequest(String keyword) throws IOException {
        request= RestAssured.given().log().all();
        response=request.post(constructEndpoint(keyword));
    }

    public String constructEndpoint(String keyword) throws IOException {
        String url=prop.getURL();
        String baseURL=url+"?s="+keyword+"&post_type=page";
        return baseURL;
    }

    public int getStatus()
    {
        return Statuscode=response.getStatusCode();
    }

    public String getMessage(String keyword)
    {
        String value;
        if(response.getBody().asString().contains("Sorry, your search didn't return any results."))
        {
            System.out.println("Search for keyword:"+keyword+" is not present");
            return "not present";
        }
        else
        {
            System.out.println("Search result for keyword:"+keyword);
            return "present";
        }
    }
}

package stepDefinitions;

import POM.landingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.propertyFileLoader;

import java.io.IOException;

public class keywordSearch {
    WebDriver driver;
    propertyFileLoader p=new propertyFileLoader();
    landingPage lp=new landingPage();


    @Given("User navigates to the Hitachi page")
    public void url_navigation() throws IOException {

        lp.launchBrowser();
        lp.navigateToURL();
    }

    @When("^User searches the product details using (.*)$")
    public void keyword_Search(String keyword)
    {
        System.out.println("Searching the keyword");
        lp.searchKeyword(keyword);

    }

    @Then("^search returns the (.*) for (.*)$")
    public void verify_Result(String result,String keyword)
    {

        System.out.println("Verify the search result");
        assert (lp.verifyKeyword(result,keyword).equals(result));
        lp.closeBrowser();

    }

}

package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;

public class hooks {
    @Before()
    public void beforeMethod(Scenario scenario)
    {

        System.out.println("Starting the execution of "+scenario.getName());
    }



    @After()
    public void afterMethod(Scenario scenario)
    {
       System.out.println("Ending the execution of "+scenario.getName());
    }
}

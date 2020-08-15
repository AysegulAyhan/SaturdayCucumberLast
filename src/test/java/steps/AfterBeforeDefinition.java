package steps;

import cucumber.api.java.After;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BaseDriver;

public class AfterBeforeDefinition {

    @After
    public void afterSuite() {
        System.out.println("Ending scnerio!");
        BaseDriver.quitDriver();
    }
}

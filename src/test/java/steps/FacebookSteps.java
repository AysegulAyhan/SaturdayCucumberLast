package steps;

import Poms.BasePOM;
import Poms.SocialMediaPom;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.Set;

public class FacebookSteps {
    WebDriver driver;
    BasePOM page=new BasePOM();
    SocialMediaPom icons=new SocialMediaPom();
    @When("^Click on Facebook icon$")
    public void click_on_Facebook_icon() {
        driver= BaseDriver.getDriver();
        page.waitAndClick(icons.facebookIcon);
    }

    @Then("^Appears Facebok login page$")
    public void appears_Facebok_login_page()  {
        String mainWindow = driver.getWindowHandle();
        Set<String> twoWindow = driver.getWindowHandles();
        for (String handle : twoWindow) {
            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        driver.switchTo().window(mainWindow);
//        page.waitAndClick(icons.logOut);
    }
   }

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

public class GooglePlusSteps {
    WebDriver driver;
    BasePOM page= new BasePOM();
    SocialMediaPom icons=new SocialMediaPom();
    @When("^Click on GooglePlus icon$")
    public void click_on_GooglePlus_icon()  {
        driver= BaseDriver.getDriver();
        page.waitAndClick(icons.googlePlusIcon);
    }

    @Then("^Appears GooglePlus login page$")
    public void appears_GooglePlus_login_page()  {
        String mainWindow1 = driver.getWindowHandle();
        Set<String> twoWindow1 = driver.getWindowHandles();
        for (String handle1 : twoWindow1) {
            if (!handle1.equals(mainWindow1)){
                driver.switchTo().window(handle1);
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("google"));
        driver.switchTo().window(mainWindow1);
//        page.waitAndClick(icons.logOut);
//        driver.quit();
    }
}

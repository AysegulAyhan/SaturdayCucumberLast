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

public class YouTubeSteps {
    WebDriver driver;
    BasePOM page= new BasePOM();
    SocialMediaPom icons=new SocialMediaPom();
    @When("^Click on YouTube icon$")
    public void click_on_YouTube_icon()  {
        driver= BaseDriver.getDriver();
        page.waitAndClick(icons.youtubeIcon);
    }

    @Then("^Appears YouTube login page$")
    public void appears_YouTube_login_page()  {
        //Thread.sleep(2000);
        String mainWindow1 = driver.getWindowHandle();
        Set<String> twoWindow1 = driver.getWindowHandles();
        for (String handle1 : twoWindow1) {
            if (!handle1.equals(mainWindow1)){
                driver.switchTo().window(handle1);
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
        driver.close();
        driver.switchTo().window(mainWindow1);
        page.waitAndClick(icons.logOut);

    }
}

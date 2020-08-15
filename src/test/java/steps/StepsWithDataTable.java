package steps;

import Poms.BasePOM;
import Poms.SocialMediaPom;
import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.Map;
import java.util.Set;

public class StepsWithDataTable {
    WebDriver driver=BaseDriver.getDriver();
    BasePOM page=new BasePOM();
    SocialMediaPom icon=new SocialMediaPom();
    @When("^Succesfuly navigate to following pages and verify$")
    public void succesfulyNavigateToFollowingPagesAndVerify(DataTable table) throws InterruptedException {
        //driver= BaseDriver.getDriver();
        Map<String, String> icons = table.asMap(String.class, String.class);
        for (String keys:icons.keySet()) {
            String mainWindow1 = driver.getWindowHandle();
            icon.waitAndClick(icon.clickPage(keys));
            Set<String> twoWindow1 = driver.getWindowHandles();
            for (String handle1 : twoWindow1) {
                if (!handle1.equals(mainWindow1)){
                    driver.switchTo().window(handle1);
                }
            }
            Assert.assertTrue(driver.getCurrentUrl().contains(icons.get(keys)));
            driver.switchTo().window(mainWindow1);
        }

    }
}

package steps;

import Poms.BasePOM;
import Poms.SocialMediaPom;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.List;

public class Replit1 {

    WebDriver driver= BaseDriver.getDriver();
    BasePOM page=new BasePOM();
    SocialMediaPom icon=new SocialMediaPom();
    WebDriverWait wait=new WebDriverWait(driver,10);
    @Given("^Navigate to the \"([^\"]*)\" and enter your credentials$")
    public void navigate_to_the_and_enter_your_credentials(String arg1)  {
        page.navigateTo(arg1);
        page.waitAndSendKeys(icon.loginInput,"Tester");
        page.waitAndSendKeys(icon.passwordInput,"test");
        page.waitAndClick(icon.loginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SampleTable")));

    }

    @Given("^I am logged in and verify eight items$")
    public void i_am_logged_in_and_verify_eight_items() throws InterruptedException {
        List<WebElement> rows = icon.rows;
        Assert.assertEquals(rows.size(), 8);
        List<WebElement> checkBoxes = icon.checkBox;
        for (WebElement checkBox : checkBoxes) {
            page.waitAndClick(checkBox);
        }
        page.waitAndClick(icon.deleteButton);
        Thread.sleep(2000);
        Assert.assertTrue(icon.orderLink.getText().contains("link"));
    }


}

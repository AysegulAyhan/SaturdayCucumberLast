package steps;

import Poms.BasePOM;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

public class LoginSteps {

   protected WebDriver driver;
   BasePOM page =new BasePOM();
    @Given("^Navigate to the website$")
    public void navigate_to_the_website() {
//        driver.manage().window().maximize();
        driver= BaseDriver.getDriver();
        driver.get("http://automationpractice.com/index.php ");
    }
    @When("^I use legit username and password$")
    public void i_use_legit_username_and_password() {
        page.waitAndClick(By.cssSelector(".login"));
        page.waitAndSendKeys(By.id("email"), "qwerty0123@gmail.com");
        page.waitAndSendKeys(By.id("passwd"), "123456789");
        page.waitAndClick(By.cssSelector(".icon-lock.left"));
    }
    @Then("^I am logged in$")
    public void i_am_logged_in() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("My account - My Store"));
    }
}

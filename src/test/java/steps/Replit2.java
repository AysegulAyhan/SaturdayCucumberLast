package steps;

import Poms.BasePOM;
import Poms.SocialMediaPom;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

public class Replit2 {
    WebDriver driver= BaseDriver.getDriver();
    BasePOM page=new BasePOM();
    SocialMediaPom icon=new SocialMediaPom();
    WebDriverWait wait=new WebDriverWait(driver,10);

    @Given("^Fill  out form$")
    public void fill_out_form() {
        page.waitAndClick(icon.orderForm);
        wait.until(ExpectedConditions.visibilityOf(icon.selectButton));
        Select select=new Select(icon.selectButton);
        select.selectByIndex(0);
        page.waitAndSendKeys(icon.quantity,"1");
        page.waitAndSendKeys(icon.customerName,"Aysegul");
        page.waitAndSendKeys(icon.streetName,"Portland");
        page.waitAndSendKeys(icon.cityName,"Columbus");
        page.waitAndSendKeys(icon.state,"US");
        page.waitAndSendKeys(icon.zipCode,"45666");
        page.waitAndClick(icon.masterCard);
        page.waitAndSendKeys(icon.cardNo,"4444555888999");
        page.waitAndSendKeys(icon.cartDate,"08/2022");
        page.waitAndClick(icon.processButton);

    }

    @Given("^Find this order in order list$")
    public void find_this_order_in_order_list()  {
    page.navigateTo("View All Orders");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SampleTable")));
        page.verifyAllInformation("Aysegul","MyMoney","1","08/21/2020","Portland","Columbus","US","45666","MasterCard","4444555888999","08/20");
    }

    @Then("^Verify the list count is increased$")
    public void verify_the_list_count_is_increased() {


    }

}

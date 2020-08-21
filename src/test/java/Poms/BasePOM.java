package Poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasePOM {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePOM() {
        driver = BaseDriver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public void waitAndSendKeys(By locator, String text) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void waitAndSendKeys(WebElement locator, String text) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(locator));
        locator.clear();
        locator.sendKeys(text);
    }
    public void navigateTo(String name){
        switch (name){
            case"weborders":
                driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
                break;
            case"View All Orders":
                driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
                break;
        }
    }
    public void verifyAllInformation(String name,String product,String quantity,String todayDate,String street,String city,String state,String zip,String card,String cardNumber,String cartdate){
        ////*[text()='Aysegul']/following-sibling::td
        WebElement name1 = driver.findElement(By.xpath("//*[text()='" + name + "']"));
        List<WebElement> informationList=driver.findElements(By.xpath("//*[text()='"+name+"']/following-sibling::td"));
        List<String> output=new ArrayList<>();
        for (WebElement element : informationList) {
            if (!element.getText().isEmpty()){
                output.add(element.getText());
            }
        }
        List<String> inputs=new ArrayList<>(Arrays.asList(product,quantity,todayDate,street,city,state,zip,card,cardNumber,cartdate));
        if (name1.getText().equals(name)){
            Assert.assertEquals(inputs,output);
        }
    }
}

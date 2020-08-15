package Poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;

import java.util.List;

public class SocialMediaPom extends BasePOM {
    public SocialMediaPom(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }
    @FindBy(css = "#social_block>ul>.facebook")
    public WebElement facebookIcon;
    @FindBy(css = "#social_block>ul>.twitter")
    public WebElement twitterIcon;
    @FindBy(css = "#social_block>ul>.youtube")
    public WebElement youtubeIcon;
    @FindBy(css = "#social_block>ul>.google-plus")
    public WebElement googlePlusIcon;
    @FindBy(css = ".logout")
    public WebElement logOut;
    public By loginInput= By.cssSelector("#ctl00_MainContent_username");
    public By passwordInput= By.cssSelector("#ctl00_MainContent_password");
    public By loginButton=By.cssSelector("#ctl00_MainContent_login_button");
    @FindBy(css = ".SampleTable>tbody>tr:nth-child(n+2)")
    public List<WebElement> rows;
    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkBox;
    @FindBy(css = "#ctl00_MainContent_btnDelete")
    public WebElement deleteButton;
    @FindBy(css = "#ctl00_MainContent_orderLInk")
    public WebElement orderLink;

    public WebElement clickPage(String pageName){
        WebElement element=null;
        switch (pageName){
            case "twitter":
              element= twitterIcon;
                break;
            case "youtube":
                element=youtubeIcon;
                break;
            case"googleplus":
               element=googlePlusIcon;
                break;
            case "facebook":
                element=facebookIcon;
                break;


        } return element;

    }
}

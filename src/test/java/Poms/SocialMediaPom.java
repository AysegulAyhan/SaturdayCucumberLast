package Poms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;

public class SocialMediaPom {
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
}

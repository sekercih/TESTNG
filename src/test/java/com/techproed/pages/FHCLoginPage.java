package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FHCLoginPage {
    WebDriver driver;
    public FHCLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "UserName")
    public WebElement username;
    @FindBy(id = "Password")
    public WebElement passWord;
    @FindBy(id = "btnSubmit")
    public WebElement login;
    @FindBy(xpath = "//*[@id=\"divMessageResult\"]/div/span")
    public WebElement error;
    @FindBy(xpath = "//*[@id=\"add-form\"]/div[3]/button")
    public WebElement loggin;

    public void login2(){
        username.sendKeys("manager2");
        passWord.sendKeys("Man1ager2!");
        loggin.click();
    }

}

package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {
    public GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "email")
    public WebElement mail;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "mobile")
    public WebElement telefon;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "re_password")
    public WebElement repassword;
    @FindBy(xpath = "/html/body/section[1]/div/div/div[2]/div/form/button")
    public WebElement login;
   @FindBy(xpath = "/html/body/section[1]/div/div/div[2]/div/form/div[1]/strong")
    public WebElement sucmesaj;
}

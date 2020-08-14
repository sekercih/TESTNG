package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FaceLoginPage {
   WebDriver driver;
   public FaceLoginPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);

   }



   @FindBy(id="email")
   public WebElement email;
   @FindBy(id = "pass")
   public WebElement password;
   @FindBy(id = "u_0_b")
    public WebElement login;
    @FindBy(xpath = "//*[@id=\"globalContainer\"]/div[3]/div/div/div")
  public WebElement error;
}

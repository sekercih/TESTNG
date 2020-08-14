package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FHCLoginNegativeTest extends TestBase {
    @Test(groups = "group test1")
    public void gecersizUserName(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);

        fhcLoginPage.username.sendKeys("manager");
        fhcLoginPage.passWord.sendKeys("Man1ager2!");
        fhcLoginPage.login.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement tryAgain=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divMessageResult\"]/div/span")));
       Assert.assertTrue(fhcLoginPage.error.getText().contains("Try again please"));
    }
    @Test
    public void gecersizPassword(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.passWord.sendKeys("11111");
        fhcLoginPage.login.click();
        Assert.assertTrue(fhcLoginPage.error.getText().contains("Try again please"));
    }
    @Test
    public void gecersizler(){
        driver.get("http://fhctrip-qa.com/Account/Logon");
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys("manager232");
        fhcLoginPage.passWord.sendKeys("11111");
        fhcLoginPage.login.click();
        Assert.assertTrue(fhcLoginPage.error.getText().contains("Try again please"));

    }

}

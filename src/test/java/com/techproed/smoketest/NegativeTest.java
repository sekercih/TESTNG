package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    @Test
    public void gecersizUserName(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);

        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        fhcLoginPage.passWord.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.login.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement tryAgain=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"divMessageResult\"]/div/span")));
        Assert.assertTrue(fhcLoginPage.error.getText().contains(ConfigReader.getProperty("login_error_mesaj")));
    }
    @Test(groups = "group test1")
    public void gecersizPassword(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.passWord.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        fhcLoginPage.login.click();
        Assert.assertTrue(fhcLoginPage.error.isDisplayed());
    }
    @Test(groups = "gropstest2")
    public void gecersizler(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        fhcLoginPage.passWord.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        fhcLoginPage.login.click();
        Assert.assertTrue(fhcLoginPage.error.getText().contains(ConfigReader.getProperty("login_error_mesaj")));

    }

}

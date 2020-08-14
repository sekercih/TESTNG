package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.techproed.utilities.Driver.closeDriver;

public class FirstDriverTest {
    @Test
    public void gecersizPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.passWord.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        fhcLoginPage.login.click();
        Assert.assertTrue(fhcLoginPage.error.isDisplayed());
        closeDriver();
    }

}

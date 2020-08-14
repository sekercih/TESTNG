package com.techproed.smoketest;

import com.techproed.pages.GlbHomeAnaPage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
    GlbHomeAnaPage glbHomeAnaPage=new GlbHomeAnaPage();
    @Test
    public void signUpTest() throws InterruptedException {
       // Driver.getDriver().get(ConfigReader.getProperty("glb_signup_url"));
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        glbHomeAnaPage.join.click();
        glbSignUpPage.mail.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        glbSignUpPage.telefon.sendKeys(ConfigReader.getProperty("test_phone"));
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignUpPage.login.click();
        Thread.sleep(4000);
        System.out.println("SuccMesaj = "+glbSignUpPage.sucmesaj.getText());
        Assert.assertFalse(glbSignUpPage.sucmesaj.getText().equals("Success! !"));
        Driver.closeDriver();
    }
}

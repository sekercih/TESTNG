package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestGlbSignIn {

    @Test
    public void negativeTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signin_url"));
        GlbHomePage glbHomePage = new GlbHomePage();
        glbHomePage.email.sendKeys(ConfigReader.getProperty("gecersiz_email"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        glbHomePage.login.click();



        Driver.closeDriver();
    }
}
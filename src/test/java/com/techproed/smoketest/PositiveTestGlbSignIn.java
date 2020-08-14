package com.techproed.smoketest;

import com.techproed.pages.GlbHomePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PositiveTestGlbSignIn {
    @Test
    public void gecerliTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_signin_url"));
        GlbHomePage glbHomePage=new GlbHomePage();
        glbHomePage.email.sendKeys(ConfigReader.getProperty("test_email"));
        glbHomePage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbHomePage.login.click();

    }

}

package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPozitiveTest extends TestBase {
    @Test
    public void pozitiveTestLogin(){
       driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.passWord.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.login.click();

    }


}

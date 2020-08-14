package com.techproed.tests;

import com.mongodb.DBRefCodecProvider;
import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReports2 extends TestBaseFinal {
    @Test
    public void negativeTest(){
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        extentTest=extentReports.createTest("FHC login test","FHC login fonksiyonun Testi");
        extentTest.info("url ye git");
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));

        extentTest.info("geçersiz user name gonder");
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecersiz_username"));
        extentTest.info("geçersiz password gonder");
        fhcLoginPage.passWord.sendKeys(ConfigReader.getProperty("gecersiz_password"));
        extentTest.info("login butonuna tıkla");
        fhcLoginPage.login.click();

        extentTest.info("doğrulama yap");
        Assert.assertFalse(fhcLoginPage.error.getText().contains("Try again please"));
        extentTest.pass("PASS try again please");
        Driver.closeDriver();
        extentTest.pass("Driver kapatıldı");



    }
}

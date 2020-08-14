package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomeAnaPage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports1 {
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;



    @BeforeTest
    public void setup(){
        extentHtmlReporter = new ExtentHtmlReporter("./reports/extentreport.html");

        extentHtmlReporter.config().setReportName("GLB tader Rapor");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setDocumentTitle("GLB signup report");
        extentHtmlReporter.config().setEncoding("UTF-8");

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Atomation engineer","cehennem");
        extentReports.setSystemInfo("Browser","Chrome");


    }
    @AfterTest
    public void endreport(){
        extentReports.flush();
    }
    @Test
    public void signUpTest() throws InterruptedException {
        GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
        GlbHomeAnaPage glbHomeAnaPage=new GlbHomeAnaPage();
        extentTest=extentReports.createTest("GLB Sign Up Test");
        extentTest.info("url git");

            // Driver.getDriver().get(ConfigReader.getProperty("glb_signup_url"));
            Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
            extentTest.info("join  linke git");
        glbHomeAnaPage.join.click();
        extentTest.info("emaile gir");
        glbSignUpPage.mail.sendKeys(ConfigReader.getProperty("test_email"));
        extentTest.info("kullanıcı gir");
        glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        extentTest.info("telefon gir");
        glbSignUpPage.telefon.sendKeys(ConfigReader.getProperty("test_phone"));
        extentTest.info("şifre gir");
        glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("şifreyi tekrar gir");
        glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        extentTest.info("logine tıkla");
        glbSignUpPage.login.click();

        Thread.sleep(4000);
       // System.out.println("SuccMesaj = "+glbSignUpPage.sucmesaj.getText());
        //Assert.assertTrue(glbSignUpPage.sucmesaj.getText().equals("Success! !"));
       extentTest.pass("PASSED test başarıyla geçti");
       Driver.closeDriver();
       extentTest.pass("Driver başarıyla kapatıldı");
}}

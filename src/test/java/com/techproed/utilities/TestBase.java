package com.techproed.utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public  abstract class  TestBase  {
    protected WebDriver driver;
    protected Actions actions;
    protected  Faker faker;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       actions=new Actions(driver);
       Locale locale=new Locale("ja_JP");
        faker=new Faker(locale);
    }
    @AfterMethod
    public void tearDown(){


    }


}


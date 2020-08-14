package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class CreateHotel extends TestBase {


    //Tests packagenin altina class olusturun: CreateHotel
    //Bir method olusturun: createHotel
    //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //Save butonuna basin.
    //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin
    @Test
    public void createHotel(){
        Locale local=new Locale("ja_JP");
        Faker faker=new Faker(local);
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("manager2");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"Code\"]")).sendKeys(faker.artist().name()+" Butik Star");
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//*[@id=\"Address\"]")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//*[@id=\"Phone\"]")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(faker.name().fullName()+"@gmail.com");

        WebElement IdDrop=driver.findElement(By.xpath("//*[@id=\"IDGroup\"]"));
        Select select=new Select(IdDrop);
        select.selectByIndex(2);
        //Save butonuna basin.
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        saveButton.click();
        //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,10);
       // boolean isTrue =  wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"Hotel was inserted successfully"));
      //  Assert.assertTrue(isTrue);
        //OK butonuna tiklayin.
       // WebElement okButton = driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
        //okButton.click();











    }
}

package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//Tests packagenin altina class olusturun: HotelRoomCreation
//Bir method olusturun:  RoomCreateTest()
//http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
//Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
//Username : manager2
//Password : Man1ager2!
//Login butonuna basin.
//Acilan sayfadaki butun textboxlara istediginiz verileri girin
//Save butonuna basin.
//“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
//OK butonuna tiklayin.
//Hotel rooms linkine tiklayin.
//"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.

public class HotelRoomCreation  extends TestBase {
    @Test
    public void  RoomCreateTest() throws InterruptedException {
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys("manager2");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Man1ager2!");
        driver.findElement(By.xpath("//*[@id=\"add-form\"]/div[3]/button")).click();
        WebElement addHotel=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[2]/a/span"));
        addHotel.click();

       WebElement otel= driver.findElement(By.xpath("//*[@id=\"IDHotel\"]"));
        Select select=new Select(otel);
        select.selectByIndex(5);
        driver.findElement(By.xpath("//*[@id=\"Code\"]")).sendKeys("Deniz Yıldızı");
        driver.findElement(By.xpath("//*[@id=\"Name\"]")).sendKeys(faker.number().digits(4));
        driver.findElement(By.xpath("//*[@id=\"Location\"]")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/textarea")).sendKeys(faker.shakespeare().kingRichardIIIQuote());
        WebElement kaynek=driver.findElement(By.xpath("//*[@id=\"products\"]/div/ul/li[4]/a"));
        WebElement hedef=driver.findElement(By.xpath("//*[@id=\"Price\"]"));
        actions.dragAndDrop(kaynek,hedef).perform();
        WebElement option=driver.findElement(By.xpath("//*[@id=\"IDGroupRoomType\"]"));
        Select select1=new Select(option);
        select1.selectByIndex(5);
        driver.findElement(By.xpath("//*[@id=\"MaxAdultCount\"]")).sendKeys("4");
        driver.findElement(By.xpath("//*[@id=\"MaxChildCount\"]")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[2]/button"))).click();
        //WebElement hotelList=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[2]/a"));

        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.HOME).perform();
        WebElement hotelList=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[2]/a")));
        hotelList.click();

        WebElement listHotel=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/div[1]/span"));
        Assert.assertTrue(listHotel.isDisplayed());
      










    }

}

package com.techproed.tests;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.Random;

public class ftnet extends TestBase {
   @Test
    public void mesaj() throws InterruptedException {
      driver.get("https://www.ftnet.com/");
       Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"mainNav\"]/li[7]/a")).
              click();
       driver.switchTo().frame(0);

       Locale local=new Locale("tr-TR");
       Faker faker=new Faker(local);



       WebElement isim= driver.findElement(By.id("first_3"));
       isim.sendKeys(faker.artist().name());
       WebElement soyisim=driver.findElement(By.xpath("//*[@id=\"last_3\"]"));
       Random random=new Random();
       soyisim.sendKeys(faker.name().lastName());


      driver.findElement(By.xpath("//*[@id=\"input_4\"]")).
              sendKeys(faker.name().lastName()+"@gmail.com");
      driver.findElement(By.xpath("//*[@id=\"input_5_area\"]")).
              sendKeys("001");
      driver.findElement(By.xpath("//*[@id=\"input_5_phone\"]")).
              sendKeys(faker.phoneNumber().cellPhone());


       WebElement mesaj=driver.findElement(By.xpath("//*[@id=\"input_6\"]"));
       mesaj.sendKeys("Bu site buna hazır mı?"+Keys.ENTER+Keys.ENTER);
       Thread.sleep(4000);
       mesaj.sendKeys("Göndere basılsın mı??"+Keys.ENTER+Keys.ENTER);

       Thread.sleep(3000);
       mesaj.sendKeys("      Gözünü kırpman yeter..??"+Keys.ENTER);
       Thread.sleep(3000);

       driver.switchTo().parentFrame();

       WebElement anaSayfa=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
       anaSayfa.click();


       mesaj();











   }
}

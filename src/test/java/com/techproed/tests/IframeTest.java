package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
    //Bir class olusturun: IframeTest
    //https://the-internet.herokuapp.com/iframe  adresine gidin.
    //Bir metod olusturun: iframeTest
    //“An IFrame containing….” textini konsolda yazdirin.
    //Text Box’a “Merhaba Dunya!” yazin.
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
    @Test
    public void iframeTest (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        System.out.println(driver.findElement(By.xpath("//h3")).getText());



       driver.switchTo().frame(0);
        WebElement textbox= driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        textbox.clear();
        textbox.sendKeys("merhaba pc si soğumayan arkadaş");
        driver.findElement(By.cssSelector("#tinymce"));
        driver.switchTo().parentFrame();

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        // locate Elemental selenium text
        //Parent frame geri gelelim
        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();   // default page gider.
        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());

        //iframe  ==========>Buraya gelmek istiyorum. defaultContent();
        //     iframe  =====>Buraya gelmek istiyorum. parentFrame();
        //        iframe   => buradayim
        //            iframe





    }
}

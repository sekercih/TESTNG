package com.techproed.tests;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReviewClass {
    //https://www.airbnb.co.in/ adresine git
    //Sayfa basligini(title) al ve konsolda yazdir.
    //Sayfanin mevcut url’ ini (current url) al
    //Sayfanin source(page source) ‘u al.

    @Test
    public void airbnb(){
        Driver.getDriver().get("https://www.airbnb.co.in/");

        String title=Driver.getDriver().getTitle();
        System.out.println("Sayfa basligi =" +title);

        String currenUrl=Driver.getDriver().getCurrentUrl();
        System.out.println("Sayfanin mevcut url =" +currenUrl);
        String pageSoutce=Driver.getDriver().getPageSource();
        System.out.println("Sayfanin source ="+pageSoutce);

    }
    @Test
    public void ebayTest(){
        //http://ebay.com adresine git
        //Search box’a “Selenium” yaz
        //Search butonuna tikla
        //Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
        //Sayfa basligini(title) al ve konsolda yazdir.
        //Sayfanin mevcut url’ini (current url) al
        //Sayfanin source(page source) ‘u al.

        Driver.getDriver().get("http://ebay.com");
        WebElement searcButton=Driver.getDriver().findElement(By.id("gh-ac"));
        searcButton.sendKeys("Selenium");
        WebElement searcButtonTikla=Driver.getDriver().findElement(By.id("gh-btn"));
       searcButtonTikla.click();

        WebElement result=Driver.getDriver().findElement(By.className("BOLD"));

        System.out.println("Selenium icin kac sonuc var <<<<<<<<= "+result.getText());

        String currenUrl=Driver.getDriver().getCurrentUrl();
        System.out.println("Sayfanin mevcut url <<<<<<<<=" +currenUrl);
        String pageSoutce=Driver.getDriver().getPageSource();
        System.out.println("Sayfanin source <<<<<<<<="+pageSoutce);



    }

}

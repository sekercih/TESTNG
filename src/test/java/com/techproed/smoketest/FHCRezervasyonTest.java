package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.pages.FHCRezervasyonPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class FHCRezervasyonTest extends TestBase {

    @Test
    public void fhcRezervasyonTest() throws InterruptedException {
       driver.get("http://fhctrip-qa.com/admin/RoomReservationAdmin/Create");
        //FHCLoginPage de bulunan login2() metodunu cagirmak icin obje olusturuyoruz.
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        //olusturdugumuz fhcLoginPage objesi ile login2() metodunu cagir.
        fhcLoginPage.login2();


        //fhcRezervasyonPage objesini olustur
        FHCRezervasyonPage fhcRezervasyonPage=new FHCRezervasyonPage(driver);

        //fhcRezervasyonPage objesini kullanarak classtaki elemenleri cagir.
        Select idUserSelect = new Select(fhcRezervasyonPage.idUser);   //dropdown(idUser)
        idUserSelect.selectByIndex(1);

        Select idHotelRoomSelect = new Select(fhcRezervasyonPage.idHotelRoom);  //dropdown(idHotelRoom)
        idHotelRoomSelect.selectByIndex(4);

        fhcRezervasyonPage.price.sendKeys("500");  //price
        fhcRezervasyonPage.dateStart.sendKeys("08/15/2020");
        fhcRezervasyonPage.dateEnd.sendKeys("08/25/2020");
        fhcRezervasyonPage.adultAmount.sendKeys("2");
        fhcRezervasyonPage.childrenAmount.sendKeys("3");
        fhcRezervasyonPage.surname.sendKeys(faker.name().lastName());
        fhcRezervasyonPage.phone.sendKeys(faker.phoneNumber().cellPhone());
        fhcRezervasyonPage.email.sendKeys(faker.name().lastName()+"@hotmail.com");
        fhcRezervasyonPage.notes.sendKeys("Deniz manzarali");
        fhcRezervasyonPage.isApproved.click();
        fhcRezervasyonPage.isPaid.click();
        fhcRezervasyonPage.saveButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(fhcRezervasyonPage.succeMesaj.isDisplayed());
        fhcRezervasyonPage.ok.click();











    }
}
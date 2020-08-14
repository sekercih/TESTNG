package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
//Bir class oluşturun : WebTables
//
//printCells() metodu oluşturun
//table body’sinde bulunan toplam hücre(cell) sayısını bulun.
//Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.
//printColumns() metodu oluşturun
//table body’sinde bulunan toplam sutun(column) sayısını bulun.
//Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
//5.column daki elementleri  konsolda yazdırın.

public class WebTables extends TestBase {
    @Test
    public void login(){
        //  login() metodun oluşturun ve oturum açın.
        //http://www.fhctrip.com/admin/HotelRoomAdmin
        //Username : manager2
       //Password : Man1ager2!
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");     //Username : manager2;
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");   //Password : Man1ager2!;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Test
    public void table() throws InterruptedException {
        login();
        // tbody'deki datalari konsolda yazdirin
        Thread.sleep(3000);
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        //        Tüm table body’sinin boyutunu(size) bulun. kac tane hucre var(cell)
        List<WebElement> table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("TABLE BODY SIZE : " + table.size());

//        Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement> allHeaders = driver.findElements(By.tagName("th"));
        for (WebElement header : allHeaders) {
            System.out.println(header.getText());
        }
    }
    @Test
    public void printRows() throws InterruptedException {
        login();
        Thread.sleep(3000);
    //printRows() metodu oluşturun
//table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("Table body'de toplam " +driver.findElements(By.xpath("//tbody//tr")).size()+ " tane satir(row) vardir.");
//Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row:allRows){
            System.out.println(row.getText()); ////tbody//tr//td
        }
//4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> elementsRow4=driver.findElements(By.xpath("//tr[4]//td"));
        for(WebElement row4:elementsRow4){
            System.out.println("row4 = "+row4.getText());
        }
}
@Test
    public void printCells(){
        login();

        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    System.out.println("table body’sinde bulunan toplam hücre(cell) sayısı= "+driver.findElements(By.xpath("//tbody//td")).size());


    //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    List<WebElement>allcell=driver.findElements(By.xpath("//tbody//td"));
    for (WebElement cell:allcell){
        System.out.println(cell.getText());
    }
}
@Test
    public void printColumns(){
        login();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
    System.out.println(driver.findElements(By.xpath("//tr[3]//td")).size());
    //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
    System.out.println(driver.findElements(By.xpath("//th")).size());
    //○ 5.column daki elementleri konsolda yazdırın.
    List<WebElement>collum5=driver.findElements(By.xpath("//tbody//td[5]"));
    for (WebElement coll:collum5){
        System.out.println(coll.getText());

}
    }

    public void  printData(int row, int column){
        //kodlari bu metodun icine yazalim
        //   //tbody//tr[8]//td[3]
        //dinamik bir xpath yazalim
        String xpath = "//tbody//tr[" +row+ "]//td[" +column+ "]";
        //elementleri xpath'i kullanarak bulalim
        WebElement data = driver.findElement(By.xpath(xpath));
        //data lari yazdiralim
        System.out.println(data.getText());
    }

    @Test
    public void printDataTest(){
        login();
        printData(8,3);     // 1234
        printData(5,2);    //kalem
        printData(9,5);    //London

    }

}

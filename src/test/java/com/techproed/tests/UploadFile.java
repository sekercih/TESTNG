package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {
    @Test
    public void UploadFileMethod(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        String filepath="D:\\VIRUS BAŞARIYLA YUKLENDI.bat";
        // sendKeys() kullanabilmek icin choose file elementinin tag = input ve type="file" olmali
        chooseFileButton.sendKeys(filepath);
        //Upload butonuna basin.
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        //“File Uploaded!” textinin goruntulendigini dogrulayin.
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");

    }
}

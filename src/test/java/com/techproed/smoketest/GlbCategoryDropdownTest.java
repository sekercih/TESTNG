package com.techproed.smoketest;

import com.techproed.pages.GlbHomeAnaPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ConcurrentModificationException;

public class GlbCategoryDropdownTest {
    GlbHomeAnaPage glbHomeAnaPage=new GlbHomeAnaPage();
    @Test
    public void glbDrobdownTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        Select options=new Select(glbHomeAnaPage.drobdown);
        boolean flag=false;
        for (WebElement option:options.getOptions()){
            if (option.getText().equals("Furniture")){
                System.out.println("Dropdownda Furniture vardır.");
                flag=true;
                break;

            }
        }
        Assert.assertTrue(flag);
        Driver.closeDriver();





    }


}

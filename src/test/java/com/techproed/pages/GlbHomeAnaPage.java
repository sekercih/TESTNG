package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GlbHomeAnaPage {
    public GlbHomeAnaPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(id = "header_search_category")
    public WebElement drobdown;
    @FindBy(linkText = "Join Now")
    public WebElement join;

    }


package com.techproed.tests;


    import java.io.File;
import java.io.IOException;

    import com.techproed.utilities.Driver;
    import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deneme {

        public static void main(String[] args) throws IOException {

            Driver.getDriver().get("https://www.twoplugs.com/");



            // Syntax
            // -------------
            // JavascriptExecutor js = (JavascriptExecutor)driver;
            // js.executeScript(script, args);

            // flash
            // ---------------------
            WebElement joinfree = Driver.getDriver().findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));
            // JavaScriptUtil.flash(joinfree,driver);

            // Drawing border & take screenshot
            // ------------------
            JavaScriptUtil.drawBorder(joinfree, Driver.getDriver());

            File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("C://screenshot/twoplugs.png"));

            // Getting title of the page
            // ---------------------------
            String title = JavaScriptUtil.getTitleByJS(Driver.getDriver());
            System.out.println(title);

            // Clicking on element
            // --------------------------
            // WebElement
            // loginBtn=driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a/span"));
            // JavaScriptUtil.clickElementByJS(loginBtn,driver);

            // Generate alert
            // --------------
            // JavaScriptUtil.generateAlert(driver, "Clicked on Login Button");

            // Refreshing page
            // ----------------
            JavaScriptUtil.refreshBrowserByJS(Driver.getDriver());

            // get page inner text
            // -------------
            // System.out.println(JavaScriptUtil.getPageInnerText(driver));

            // Scrolling down page
            // JavaScriptUtil.scrollPageDown(driver);

            // Scroll we find element on page
            WebElement image = Driver.getDriver().findElement(By.id("rslides3_s0"));
            JavaScriptUtil.scrollIntoView(image, Driver.getDriver());

        }

    }


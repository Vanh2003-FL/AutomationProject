package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day16_AutomationTesting_Alert_Test extends CommonBase {
   @BeforeMethod
   @Parameters("browser")

    public void openBrowser(String browser){
       driver =  setupBrowser(browser);
       driver.get(URL.Auto_URL);
//    driver = initChromeBrowser(URL.Auto_URL);
    }
   @Test
    public void Alert_OK(){
       click(By.xpath("//button[@class='btn btn-danger']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.switchTo().alert().accept();
       assertTrue(isElementPresent(By.xpath("//button[@class='btn btn-danger']")));
    }
    @Test
    public void Alert_Ok_Cancel(){
       click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
       click(By.xpath("//button[text()='click the button to display a confirm box ']"));
       driver.switchTo().alert().dismiss();
       assertTrue(isElementPresent(By.xpath("//p[text()='You Pressed Cancel']")));
    }
    @Test
    public void Alert_With_Textbox(){
       click(By.xpath("//a[text()='Alert with Textbox ']"));
       click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
       String actualText = driver.switchTo().alert().getText();
       String expectedText = "Please enter your name";
       assertEquals(actualText,expectedText);
       driver.switchTo().alert().sendKeys("My Class April");
       driver.switchTo().alert().accept();
       assertTrue(isElementPresent(By.xpath("//p[text()='Hello My Class April How are you today']")));
    }
    @AfterMethod
    public void closeDriver(){
       driver.close();
    }


}

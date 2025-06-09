package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class Day15_DatePicker_Test extends CommonBase {
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeBrowser(URL.GURU_URL);
}
    @Test
    public void inputPicker(){
        WebElement txtBday = driver.findElement(By.name("bdaytime"));
        txtBday.sendKeys("10152025");
        txtBday.sendKeys(Keys.TAB);
        txtBday.sendKeys("1030AM");
        txtBday.sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        assertTrue(driver.findElement(By.xpath("//div[text()='Your Birth Date is 2025-10-15']")).isDisplayed());
    }
}

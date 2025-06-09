package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day16_DeleteCustomer_Alert extends CommonBase {
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeBrowser(URL.DemoGURU);
    }
    @Test
    public void deleteCustomer(){
        type(By.name("cusid"),"adf123");
        click(By.name("submit"));
        driver.switchTo().alert().accept();
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "Customer Successfully Delete!";
        assertEquals(actualText,expectedText);
        driver.switchTo().alert().accept();
        assertTrue(isElementPresent(By.xpath("//td[text()='Delete Customer Form']")));
    }
}

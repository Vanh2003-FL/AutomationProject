package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Day16_DeleteCustomer_Alert extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(@Optional("firefox") String browser) {
        driver = setupBrowser(browser);
        driver.get(URL.DemoGURU);
    }
    @Test
    public void deleteCustomer(){
        type(By.name("cusid"),"adf123");
        click(By.name("submit"));
        driver.switchTo().alert().accept();
        isAlertPresent();
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "Customer Successfully Delete!";
        assertEquals(actualText,expectedText);
        driver.switchTo().alert().accept();
        assertTrue(isElementPresent(By.xpath("//td[text()='Delete Customer Form']")));
    }
}

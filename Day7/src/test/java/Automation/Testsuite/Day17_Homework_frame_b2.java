package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Day17_Homework_frame_b2 extends CommonBase {

    @BeforeMethod
    public void openChromeBrowser() {
        driver = initChromeBrowser(URL.Media);
    }

    @Test
    public void IframeZalo() {
        assertTrue(isElementPresent(By.xpath("//iframe[contains(@src, 'zalo')]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'zalo')]")));
        click(By.xpath("//img[contains(@src,'Logo.svg')]"));
        assertTrue(isElementPresent( By.xpath("//p[normalize-space()='Siêu thị điện máy MediaMart']")));
    }
}

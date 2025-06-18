package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Day18_DienMay_HW extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(@Optional("chrome") String browser) {
        driver = setupBrowser(browser);
        driver.get(URL.DienMay);
    }

    @Test
    public void clickZalo() {
//        assertTrue(isElementPresent(By.cssSelector("iframe[src*='zalo']")));
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='zalo']")));

        click(By.xpath("//img[@alt='Zalo' and contains(@src,'zalo.png')]"));
        Set<String> listOpenWindows = driver.getWindowHandles();
        for (String tab : listOpenWindows) {
            driver.switchTo().window(tab);
            if (driver.getCurrentUrl().contains("zalo")) {
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.startsWith("https://id.zalo.me/account"));
        assertTrue(currentUrl.contains("0988169282"));
    }
}
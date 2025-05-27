package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import Automation.pageLocator.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class RegisterTest extends CommonBase {

    @BeforeMethod
    public void openBrowser() {
        driver = initChromeBrowser(URL.ALADA_URLdk);
    }

    @Test
    public void RegisterSuccess() {
        RegisterPage register = new RegisterPage(driver);
        register.RegisterFunction("User", "haha@gmail.com", "Test123", "Test123", "0356223117");
        WebElement successElement = driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and contains(@class,'khct')]"));
        assertTrue(successElement.isDisplayed(), "that bai");
    }
}

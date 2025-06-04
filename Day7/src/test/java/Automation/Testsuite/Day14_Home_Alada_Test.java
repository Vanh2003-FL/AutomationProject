package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import Automation.pageLocator.Day14_Home_Alada;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class Day14_Home_Alada_Test extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver =initChromeBrowser(URL.ALADA_URLdk);
    }
    @Test
    public void RegisterSuccess() throws InterruptedException{
        Day14_Home_Alada factory = new Day14_Home_Alada(driver);
        factory.RegisterFunction("VietAnh", "hihi@gmail.com","hihi@gmail.com", "abc123","abc123","0399215503");
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and contains(@class,'khct')]")).isDisplayed());
    }
}

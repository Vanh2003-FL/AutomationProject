package Automation.Testsuite;

import Automation.common.CommonBase;
import Automation.pageLocator.Day14_LoginPageFactory;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import Automation.Constant.URL;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class Day14_LoginTest extends CommonBase {
    @BeforeMethod
    public void openBrowser(){
        driver = initChromeBrowser(URL.ALADA_URL);
    }
    @Test
    public void LoginSuccess(){
        Day14_LoginPageFactory Login = new Day14_LoginPageFactory(driver);
        Login.LoginFunction("demoemail@gmail.com", "123456");
        assertTrue(driver.findElement(By.xpath("//div[@class='login']/child::a[text()='Khoá học của tôi']")).isDisplayed());


    }
}

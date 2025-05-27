package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import Automation.pageLocator.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends CommonBase {
    @BeforeMethod
    public void openChrome(){
        driver = initChromeBrowser(URL.ALADA_URL);
    }
    @Test
    public void LoginSuccessfully(){
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("va25012003@gmail.com","vietanh25012003");
        WebElement khctText = driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and contains(@class,'khct')]"));
        assertTrue(khctText.isDisplayed(), "That Bai");
    }
    @Test
    public void LoginFail_incorrectEmail(){
        LoginPage login = new LoginPage(driver);
        login.LoginFunction("abc@gmail.com","123456");
        WebElement emailSai = driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']"));
        assertTrue(emailSai.isDisplayed());
    }
}

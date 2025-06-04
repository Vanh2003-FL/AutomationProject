package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import Automation.pageLocator.CRMStar_Factory_Page;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CRMStar_Factory_Test extends CommonBase {
    @BeforeMethod
    public void initChromeBrowserTest()
    {
        driver = initChromeBrowser(URL.CRMSTAR_URL);
    }

    @Test
    public void loginSuccessfully()
    {
        CRMStar_Factory_Page factory = new CRMStar_Factory_Page(driver);
        factory.LoginFunction("admin@gmail.com", "12345678");
        assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
    }
    @Test
    public void loginFail_IncorrectEmail() throws InterruptedException
    {
        CRMStar_Factory_Page factory = new CRMStar_Factory_Page(driver);
        factory.LoginFunction("admin_incorrect@gmail.com", "12345678");
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
    }

    @Test
    public void loginFail_IncorrectPassword() throws InterruptedException
    {
        CRMStar_Factory_Page factory = new CRMStar_Factory_Page(driver);
        factory.LoginFunction("admin@gmail.com", "12345678abc");
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//span[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
    }
}


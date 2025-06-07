package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import Automation.pageLocator.TEDU_Login_Page;
import Automation.pageLocator.TEDU_Search_Page;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
public class TEDU_Search_Test extends CommonBase {
    String pass1 = "vietanh25012003";
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeBrowser(URL.TEDU_URL);
        TEDU_Login_Page login=  new TEDU_Login_Page(driver);
        login.loginFunction("va25012003@gmail.com", pass1);
    }
    @Test
    public void SearchSuccess() throws InterruptedException {
        TEDU_Search_Page search = new TEDU_Search_Page(driver);
        search.SearchFunction("ASP Net");
        assertTrue(driver.findElement(By.xpath("//a[@title='Bài 52: Gửi phản hồi và gửi mail trong ASP NET sử dụng SMTP']")).isDisplayed());
    }
}

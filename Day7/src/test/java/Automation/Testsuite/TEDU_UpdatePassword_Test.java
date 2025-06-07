package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import Automation.pageLocator.TEDU_Login_Page;
import Automation.pageLocator.UpdatePassword_Page;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TEDU_UpdatePassword_Test extends CommonBase {
    String pass1 = "vietanh25012003";
    String pass2 = "abcdef";
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeBrowser(URL.TEDU_URL);
        TEDU_Login_Page login=  new TEDU_Login_Page(driver);
        login.loginFunction("va25012003@gmail.com", pass1);
    }
    @Test
    public void updatePass_NotSuccessfully() throws InterruptedException {
        UpdatePassword_Page updatepass = new UpdatePassword_Page(driver);
        updatepass.updatePasswordFunction(pass1, pass2);
        assertTrue(driver.findElement(By.xpath("//legend[text()='Đổi mật khẩu']")).isDisplayed());
//        String tmp;
//        tmp = pass1;
//        pass1 = pass2;
//        pass2 = tmp;
    }
//    public void updatePass_Fail_InvalidOldPass(){
//
//    }
//    public void updatePass_Fail_InvaliConfirmPass(){
//
//    }
}

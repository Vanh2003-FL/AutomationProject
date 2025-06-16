package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Day16_CRMStar_Test extends CommonBase {
    @BeforeMethod
    public void OpenFirefoxBrowser(){
        driver = initFirefoxBrowser(URL.CRMSTAR_URL);
    }
    @Test
    public void LoginSuccess(){
        type(By.name("email"),"admin@gmail.com");
        type(By.name("password"),"12345678");
        click(By.name("signin"));
        isAlertPresent();
        driver.switchTo().alert().accept();
        assertTrue(isElementPresent(By.xpath("//p[text()='Quản lý người dùng']")));
    }
    @Test
    public void AddKLV(){
        click(By.xpath("//a[contains(text(),'Quản lý khu làm việc')]"));
        click(By.xpath("//button[contains(text(),'Thêm mới')]"));
        type(By.name("work_areas_code"),"KL0gfdf");
        type(By.name("name"), "tutri");
        click(By.xpath("//button[contains(text(),'Lưu')]"));
        click(By.xpath(""));
        assertTrue(isElementPresent(By.xpath("//td[contains(text(),'')]")));
    }
}

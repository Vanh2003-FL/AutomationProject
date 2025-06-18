package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Day18_BepAT_HW extends CommonBase {
    @BeforeMethod
    @Parameters("browser")
    public void openBrowser(@Optional("chrome") String browser){
        driver = setupBrowser(browser);
        driver.get(URL.BepAT);
    }
    @Test
    public void chat(){
            click(By.xpath("//a[contains(@href,'zalo.me/0912331335')]/span[text()='Chat với chúng tôi']"));
        String mainWindow = driver.getWindowHandle();
        Set<String>listOpenWindows = driver.getWindowHandles();
        for (String childWindow:listOpenWindows){
            if(!childWindow.equals(mainWindow)){
                driver.switchTo().window(childWindow);
                System.out.println("Driver has been swtiched to child window");
                click(By.xpath("//i[contains(@class, 'fa-bars')]"));
                click(By.xpath("//span[text()='Đăng nhập với mật khẩu']"));
                type(By.name("phone_num"),"0356223117");
                type(By.xpath("//input[@placeholder='Mật khẩu']"),"Vietanh2501");
                click(By.xpath("//a[text()='Đăng nhập với mật khẩu']"));
                assertTrue(isElementPresent(By.xpath("//div[text()='Select all images with: traffic sign']")));
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println("Driver has been switched to first window!!");
    }
}


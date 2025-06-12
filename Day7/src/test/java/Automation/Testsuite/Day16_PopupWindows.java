package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.util.Set;

public class Day16_PopupWindows extends CommonBase {
    @BeforeMethod
    public void openChromeBrowser(){
        driver = initChromeBrowser(URL.DemoGuru2);
    }
    @Test
    public void handleTabs(){
        click(By.xpath("//a[text()='Click Here']"));
        String mainWindow = driver.getWindowHandle();
        Set<String>listOpenWindows = driver.getWindowHandles();
        for (String childWindow:listOpenWindows){
            if(!childWindow.equals(mainWindow)){
                driver.switchTo().window(childWindow);
                System.out.println("Driver has been swtiched to child window");
                type(By.name("emailid"),"testEmail@gmail.com");
                click(By.name("btnLogin"));
                assertTrue(isElementPresent(By.xpath("//h2[contains(text(),'Access details')]")));
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println("Driver has been switched to first window!!");
    }
}

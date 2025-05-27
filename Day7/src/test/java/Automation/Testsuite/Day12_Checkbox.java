package Automation.Testsuite;
import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class Day12_Checkbox extends CommonBase
{
    @BeforeMethod
    public void openChrome(){
        driver = initChromeBrowser(URL.DemoKQ_URL);
    }
    @AfterMethod
    public void closeMethod(){
        driver.close();
    }

    @Test
    public void clickCheckbox_cach1(){

        WebElement chbSport = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        scrollToElement(chbSport);
        if(chbSport.isSelected()==false){
            chbSport.click();
            System.out.println("The sport checkbox has been checked");
        }
    }
    @Test
    public void clickcheckBox_cach2(){
        List<WebElement> listlabelcheckBox = driver.findElements(By.xpath("//label[contains(@for,'hobbies-checkbox')]"));
        scrollToElement(listlabelcheckBox.get(0));
        for (WebElement item:listlabelcheckBox){
            if(item.isSelected()==false){
                item.click();
                System.out.println("checkbox "+item +"has beeb clicked");
            }
        }
    }

}

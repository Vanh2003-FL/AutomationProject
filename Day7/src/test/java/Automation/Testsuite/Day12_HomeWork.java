package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day12_HomeWork extends CommonBase {
    @Test
    public void DDL(){
        driver = initChromeBrowser(URL.DemoSelect_URL);
       Select SLcountry = new Select(driver.findElement(By.xpath("//select")));
        SLcountry.selectByVisibleText("Viet Nam");
        System.out.println("Gia tri sau khi chon la: "+  SLcountry.getFirstSelectedOption().getText());
    }
}

package Automation.Testsuite;

import Automation.Constant.URL;
import Automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day12_Radio extends CommonBase {
    @Test
    public void clickRadio(){
        driver = initChromeBrowser(URL.DemoKQ_URL);
        WebElement radioMale = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        radioMale.click();
        System.out.println("Radio has been clicked");
    }
}

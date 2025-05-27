package Automation.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CT_Account {
    public static By TEXT_Email = By.id("txtLoginUsername");
    public static By TEXT_PASS= By.id("txtLoginPassword");
    public static By BTN_DANGNHAP = By.xpath("//button[text()='ĐĂNG NHẬP' and contains(@class,'btn_submit')]");

}

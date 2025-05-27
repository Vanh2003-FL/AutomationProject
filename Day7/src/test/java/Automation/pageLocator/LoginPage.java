package Automation.pageLocator;

import Automation.Constant.CT_Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver _driver) {
        this.driver = _driver;
    }
    public void LoginFunction(String email, String pass){
      WebElement txtEmail= driver.findElement(CT_Account.TEXT_Email);
      if(txtEmail.isDisplayed()){
          txtEmail.sendKeys(email);
      }
      WebElement txtPass = driver.findElement(CT_Account.TEXT_PASS);
      if(txtPass.isDisplayed()){
          txtPass.sendKeys(pass);
      }
      WebElement btnDangnhap = driver.findElement(CT_Account.BTN_DANGNHAP);
      if(btnDangnhap.isEnabled()){
          btnDangnhap.click();
      }
    }
}

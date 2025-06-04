package Automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Day14_LoginPageFactory {
    private WebDriver driver;
    //dùng FindBy annotation thay cho findElement:
    @FindBy(id="txtLoginUsername") WebElement txtEmail;
    @FindBy(id="txtLoginPassword") WebElement txtPassword;
    @FindBy(xpath = "//button[text()='ĐĂNG NHẬP' and @type='submit']") WebElement buttonLogin;
    @FindBy(xpath = "//div[@class='avatar2']/child::i") WebElement avatar;
    @FindBy(xpath = "//a[text()='Thoát'") WebElement buttonLogout;

    public Day14_LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void LoginFunction(String email, String password){
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        buttonLogin.click();
    }
    public void LogoutFunction(){
        avatar.click();
        buttonLogout.click();
    }

}

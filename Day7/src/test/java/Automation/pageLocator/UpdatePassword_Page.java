package Automation.pageLocator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatePassword_Page {
    private WebDriver driver;
    @FindBy(name="UseName") WebElement txtUseName;
    @FindBy(name="Password") WebElement txtPassword;
    @FindBy(xpath = "//button[text()=Đăng nhập']") WebElement btnDangnhap;
    @FindBy(id="my_account") WebElement buttonTaikhoan;
    @FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement buttonDoimatkhau;
    @FindBy(id="OldPassword") WebElement txtOldpass;
    @FindBy(id="NewPassword") WebElement txtNewpass;
    @FindBy(id="ConfirmNewPassword") WebElement txtConfirmPassword;
    @FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnCapNhat;

    public UpdatePassword_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void updatePasswordFunction(String odlPass, String newPass) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonTaikhoan);
        js.executeScript("arguments[0].click();", buttonDoimatkhau);
        Thread.sleep(1000);
        js.executeScript("document.getElementById('OldPassword').setAttribute('value','123456');");
        Thread.sleep(1000);
        js.executeScript("document.getElementById('NewPassword').setAttribute('value','123456');");
        Thread.sleep(1000);
        txtNewpass.sendKeys(newPass);
        Thread.sleep(1000);
        txtConfirmPassword.sendKeys(newPass);
        Thread.sleep(1000);
        btnCapNhat.click();
        Thread.sleep(1000);

    }

}

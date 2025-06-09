package Automation.pageLocator;

import Automation.Constant.CT_Account1;
import Automation.common.CommonBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions; // Thêm import này
import org.openqa.selenium.support.ui.WebDriverWait; // Thêm import này
import java.time.Duration; // Thêm import này

public class RegisterPage extends CommonBase {
    public RegisterPage(WebDriver _driver) {
        CommonBase.driver = _driver;
    }

    public void RegisterFunction(String name, String email, String pass, String confirmPass, String phone) {
        WebElement txtName = driver.findElement(CT_Account1.txtFirstname);
        txtName.sendKeys(name);

        WebElement txtEmail = driver.findElement(CT_Account1.txtEmail);
        txtEmail.sendKeys(email);

        WebElement txtConfirmEmail = driver.findElement(CT_Account1.txtCEmail);
        txtConfirmEmail.sendKeys(email);

        WebElement txtPassword = driver.findElement(CT_Account1.txtPassword);
        txtPassword.sendKeys(pass);

        WebElement txtConfirmPassword = driver.findElement(CT_Account1.txtCPassword);
        txtConfirmPassword.sendKeys(confirmPass);

        WebElement txtPhone = driver.findElement(CT_Account1.txtPhone);
        txtPhone.sendKeys(phone);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(CT_Account1.btnRegister)); // Chờ cho nút có thể click được
        btnRegister.click();
    }
}
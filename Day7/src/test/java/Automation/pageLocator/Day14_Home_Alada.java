package Automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_Home_Alada {
    private WebDriver driver;
    //Dang Ki ===
    @FindBy(id = "txtFirstname") WebElement txtfullName;
    @FindBy(id = "txtEmail") WebElement txtemail;
    @FindBy(id = "txtCEmail") WebElement txtconfirmEmail;
    @FindBy(id = "txtPassword") WebElement txtpassword;
    @FindBy(id = "txtCPassword") WebElement txtconfirmPassword;
    @FindBy(id = "txtPhone") WebElement txtphone;
    @FindBy(xpath = "//button[text()='ĐĂNG KÝ']") WebElement ButtonDK;

    public Day14_Home_Alada(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void RegisterFunction(String name, String email,String confirmemail, String pass, String confirmPass, String phone) throws InterruptedException {
        txtfullName.sendKeys(name);
        txtemail.sendKeys(email);
        txtconfirmEmail.sendKeys(confirmemail);
        txtpassword.sendKeys(pass);
        txtconfirmPassword.sendKeys(confirmPass);
        txtphone.sendKeys(phone);
        Thread.sleep(2000);
        ButtonDK.click();
    }
}

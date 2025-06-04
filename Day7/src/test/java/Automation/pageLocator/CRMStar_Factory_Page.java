package Automation.pageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMStar_Factory_Page {
    private WebDriver driver;
    // Dùng PageFactory thông qua chú thích FindBy để thay thế cho hàm findElement()
    @FindBy(id="email") WebElement txtEmail;
    @FindBy(id="password") WebElement txtPassword;
    @FindBy(name="signin") WebElement btnSignin;

    public CRMStar_Factory_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void LoginFunction(String email, String pass)
    {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(pass);
        btnSignin.click();
    }
}


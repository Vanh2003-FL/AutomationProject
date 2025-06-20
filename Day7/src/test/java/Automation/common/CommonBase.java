package Automation.common;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
    private int  initWaitTime = 15;
    public static WebDriver driver;
    private int pageLoadTimeout = 50;

    public WebDriver initChromeBrowser(String URL) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        return driver;
    }
    public WebDriver initFirefoxBrowser(String URL) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        driver = new org.openqa.selenium.firefox.FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        return driver;
    }
    public WebDriver initEdgeBrowser(String URL) {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\edgedriver.exe");
        driver = new EdgeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        return driver;
    }



    public WebElement getElementPresentDOM(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Thay cho hàm isDisplayed
    public boolean isElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
            wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
            return getElementPresentDOM(locator).isDisplayed();//true
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } catch (org.openqa.selenium.TimeoutException e2) {
            return false;
        }
    }
    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    // Thay cho webelement.click()
    public void click(By locator) {
        WebElement element = getElementPresentDOM(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Thay cho webelement.sendKeys()
    public void type(By locator, String value) {
        WebElement element = getElementPresentDOM(locator);
        element.clear();
        element.sendKeys(value);
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = getElementPresentDOM(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    private WebDriver initChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        return driver;
    }
    private WebDriver initFirefoxBrowser() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        return driver;
    }
    private WebDriver initEdgeBrowser() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\edgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        return driver;
    }
    public WebDriver setupBrowser(String browserName){
        switch (browserName.trim().toLowerCase()){
            case "chrome":
                driver = initChromeBrowser();
                System.out.println("Initilize chrome browser successfully...");
                break;
            case "firefox":
                driver = initFirefoxBrowser();
                System.out.println("Initilize firfox browser successfully...");
                break;
            case "edge":
                driver = initEdgeBrowser();
                System.out.println("Initilize edge browser successfully...");
                break;
            default:
                driver = initChromeBrowser();
                System.out.println("Invalid browser name => Initilize chrome browser successfully...");
        }
        return driver;
    }
}
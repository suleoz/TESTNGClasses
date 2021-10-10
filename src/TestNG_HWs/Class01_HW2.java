package TestNG_HWs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class01_HW2 {
    //Open chrome browser
    //Go to http://hrm.stest\.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    //Enter valid username and password
    //Click on login button
    //Then verify Syntax Logo is displayed
    //Close the browser
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void logIn() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

    }
    @Test(priority = 2)
public void logoDisplayed(){
        WebElement logo=driver.findElement(By.id("divLogo"));
        logo.isDisplayed();

        if(logo.isDisplayed()){
            System.out.println("Logo is Displayed");
        }else{
            System.out.println("Logo is not Displayed");
        }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

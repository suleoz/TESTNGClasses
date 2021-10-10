package TestNG_HWs;

import com.sun.xml.internal.ws.api.ImpliesWebServiceFeature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Class01_HW3 {
    //HRMS Application Negative Login:
    //Open chrome browser
    //Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    //Enter valid username
    //Leave password field empty
    //Verify error message with text “Password cannot be empty” is displayed.
    //:white_check_mark:
    //
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

        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

    }

    @Test(priority = 2)
    public void emptyPassword(){
        WebElement password = driver.findElement(By.id("txtPassword"));
String expectedValue="Password cannot be empty";
String actualValue= password.getText();
        Assert.assertEquals(expectedValue,actualValue,"displayed text is incorrect");

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

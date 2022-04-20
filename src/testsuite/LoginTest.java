package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        //opening browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username element and send value
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("siya012");
        //find password element and send value
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("spatel123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        //this is requirment
        String expectedText = "Accounts Overview";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualText = actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not Match", expectedText, actualText);


    }

    @Test
    public void verifyErrorMessage() {
        //send invalid value in username element
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("siya01");
        //send invalid value in password element
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Spatel12");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        //this is requirment
        String expectedErrorMessage = "The username and password could not be verified.";
        WebElement actualErrorMessageElement = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualErrorMessage = actualErrorMessageElement.getText();
        //verify expected and acctual result
        Assert.assertEquals("Text not Match", expectedErrorMessage, actualErrorMessage);

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //set valid value for username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("siya012");
        //set valid value for password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("spatel123");
        //login successfully
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        //click on log out
        driver.findElement(By.linkText("Log Out")).click();
        //this is requirment
        String expectedText = "Customer Login";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualText = actualTextElement.getText();
        //verify expected and actual resutl
        Assert.assertEquals("Text not Match", expectedText, actualText);

    }
}
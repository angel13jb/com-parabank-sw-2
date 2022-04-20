package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setup(){
    openBrowser(baseUrl);}
    @Test
    public void verifyThatSigingUPPageDisplay(){
        //find element register and click
        WebElement register=driver.findElement(By.linkText("Register"));
        register.click();
        //this is requirment
        String expectedtext="Signing up is easy!";
        WebElement actualTextElement= driver.findElement(By.xpath("//h1[@class='title']"));
        String actualText=actualTextElement.getText();
        //verify expected and actual result match
        Assert.assertEquals("Text not match",expectedtext,actualText);

        }
        @Test
    public void userSholdRegisterAccountSuccessfully(){
            driver.findElement(By.linkText("Register")).click();
            //find firstname element and send value
            driver.findElement(By.id("customer.firstName")).sendKeys("Siya");
            //find lastname element and send value
            driver.findElement(By.id("customer.lastName")).sendKeys("Patel");
            //find address element and send value
            driver.findElement(By.name("customer.address.street")).sendKeys("Swati Bunglows");
            //find city element and send value
            driver.findElement(By.name("customer.address.city")).sendKeys("Ahmedabad");
            //find state elemnet and send value
            driver.findElement(By.name("customer.address.state")).sendKeys("Gujrat");
            //find zipcod element and send value
            driver.findElement(By.id("customer.address.zipCode")).sendKeys("380009");
            //find phonenumber element and send value
            driver.findElement(By.id("customer.phoneNumber")).sendKeys("9956077940");
            //find ssn number element and send value
            driver.findElement(By.name("customer.ssn")).sendKeys("345-45-6575");
            //find username,password element and send value
            driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("siya012");
            driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("spatel123");
            driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("spatel123");
            driver.findElement(By.xpath("//input[@value='Register']")).click();
            //this is from requirment
            String expectedMessage="Your account was created successfully. You are now logged in.";
            WebElement actualMessageElement= driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
            String actualMessage=actualMessageElement.getText();
            //verify expected nad actual resutl match
            Assert.assertEquals("Message not displayed",expectedMessage,actualMessage);
        }
        @After
    public void tearDown(){
        closeBrowser();
        }

}












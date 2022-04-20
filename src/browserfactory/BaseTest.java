package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
   public void openBrowser(String baseUrl) {
       //set property of chrome driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(baseUrl);//get Url
        driver.manage().window().maximize();//maximize window size
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicity wait


    }
    public void closeBrowser(){
       driver.quit();//closing browser
    }
    }


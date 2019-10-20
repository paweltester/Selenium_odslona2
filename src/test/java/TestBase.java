import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.Random;

public class TestBase {
    public WebDriver driver; //przegladarka
    public ChromeOptions options; //instrukcje dla przegladarki
    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tester\\Desktop\\SeleniumBasic\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-extension");
        driver = new ChromeDriver(options);    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

    public WebElement getRandomElement(List<WebElement> elements){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size()-1);
        return elements.get(randomNumber);
    }

    public int getRandom(){
        List<WebElement> years = driver.findElements(By.xpath("//input[@name='gridRadiosExperience']"));
        Random rand = new Random();
        int randomYear = rand.nextInt(years.size());
        return randomYear;
    }
}

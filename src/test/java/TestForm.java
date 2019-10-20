
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class TestForm extends TestBase{

    Random r = new Random();




    @Test
    public void TestBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tester\\Desktop\\SeleniumBasic\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("http://seleniumui.tc-sii.com/form.php");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.id("inputFirstName3")).sendKeys(Keys.TAB);
        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputLastName3")).sendKeys(Keys.TAB);
        driver.findElement(By.id("inputEmail3")).sendKeys("poczta@poczta.eu");
        driver.findElement(By.id("inputEmail3")).sendKeys(Keys.TAB);
        //int a = r.nextInt(8);
        WebElement radio1 = driver.findElement(By.id("gridRadiosFemale"));
        radio1.click();
        driver.findElement(By.id("inputAge3")).sendKeys("54");
        driver.findElement(By.id("inputAge3")).sendKeys(Keys.TAB);
        WebElement radio2 = driver.findElement(By.xpath("//input[@value='"+getRandom()+"']"));
        radio2.click();
        driver.findElement(By.id("gridCheckAutomationTester")).click();

        //I Metoda
        WebElement element = driver.findElement(By.id("selectContinents"));
        Select drpContinents = new Select(driver.findElement(By.id("selectContinents")));
        drpContinents.selectByVisibleText("Europe");
        // II Metoda
        Random rand = new Random();
        List<WebElement> lista = driver.findElements(By.cssSelector("#selectContinents option"));
        int selectContinent = rand.nextInt(lista.size()-2);// np dla 8 chcemy od 2 do 8, czyli losowanie od 0 do 6(size-2) + 2 po loswaniu
        selectContinent+=2;
        System.out.println("wylosowany kontynet to: "+selectContinent +" z "+lista.size());
        driver.findElement(By.cssSelector("#selectContinents option:nth-child("+selectContinent+")")).click(); //wybierz child

        //III Metoda
        //znajdz element selecta
        WebElement continentsElement = driver.findElement(By.id("selectContinents"));

        //stworz obiekt typu Select
        Select continentsSelect = new Select(continentsElement);

        //pobierz wszystkie dostępne opcje selektu
        List<WebElement> allOptions = continentsSelect.getOptions();

        //wybierz losową opcję z listy
        WebElement randomOption = getRandomElement(allOptions);

        //wybierz element z selecta po tekscie
        //jako tekst podajemy tekst z losowo wybranej opcji
        continentsSelect.selectByVisibleText(randomOption.getText());

        driver.findElement(By.xpath("//option[@value='switch-commands']")).click();
        driver.findElement(By.id("chooseFile")).sendKeys("C:\\Users\\Tester\\Documents\\test.txt");
        driver.findElement(By.id("additionalInformations")).sendKeys("Hello World!");
        driver.findElement(By.linkText("Test File to Download")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String messageText = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(messageText, "Form send with success");

    }

    @AfterMethod
    public void Zamknij(){

       // driver.close();
    }
}

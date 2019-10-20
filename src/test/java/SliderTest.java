import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class SliderTest extends TestBase {

    public void move(int number, Keys key){


        while(Integer.parseInt(driver.findElement(By.xpath("//div[@id='custom-handle']")).getText())!= number) {
            driver.findElement(By.xpath("//div[@id='custom-handle']")).sendKeys(key);

        }
    }


    public void moveTo(int number){
        int position = Integer.parseInt(driver.findElement(By.xpath("//div[@id='custom-handle']")).getText());
        if (number == position){

        }
        if (number > position){
            move(number, Keys.ARROW_RIGHT);
        }
        if (number < position){
            move(number,Keys.ARROW_LEFT);
        }
    }

    @Test
    public void Test(){

        driver.get("http://seleniumui.tc-sii.com/slider.php");
        WebElement slider = driver.findElement(By.id("slider"));
        moveTo(50);
        moveTo(20);
        moveTo(70);
        moveTo(20);
/*
       //Using Action Class
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 50%, 0).perform();
        move.dragAndDropBy(slider, 20%, 0).perform();
        move.dragAndDropBy(slider, 70%, 0).perform();
*/
    }
}

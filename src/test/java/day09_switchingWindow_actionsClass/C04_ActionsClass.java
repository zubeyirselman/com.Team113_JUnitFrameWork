package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElementi = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement dropHereElementi = driver.findElement(By.xpath("(//*[@class='drop-box ui-droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();
        Thread.sleep(4000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedYazi = "Dropped!";
        String actualYazi = droppedElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }
}

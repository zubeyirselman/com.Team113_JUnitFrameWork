package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionsClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 2- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElementi = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlanElementi).perform();
        Thread.sleep(3000);

        // 3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        // 4- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // 5- Elemental Selenium linkine tiklayalim
        //  linki tikladigimizda yeni window acildigindan
        //  tiklamadan once ilk window'un WHD almamiz gerekir
        String ilkHandleDegeri = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // 2. sayfa biz newWindow() demeden acildigindan
        // 2. sayfanin windowHandle degerini Java kullanarak bulmaliyiz
        String ikinciHandleDegeri = "";
        Set<String> handleDegerleriSeti = driver.getWindowHandles(); // bunun icinde 2 tane WH degeri var
        // ilk handle degerini bildigimiz icin; ilkine esit olmayan deger de ikinci handle degeridir.

        for (String eachHandle : handleDegerleriSeti
        ) {
            if (!eachHandle.equals(ilkHandleDegeri)){
                ikinciHandleDegeri = eachHandle;
            }
        }
        driver.switchTo().window(ikinciHandleDegeri);

        // 6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedYazi = "Elemental Selenium";
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi, actualYazi);

    }
}

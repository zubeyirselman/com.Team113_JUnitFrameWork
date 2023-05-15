package day11_seleniumWaits_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_SeleniumWaits {
    /*
        Otomasyon yaparken,
        sayfanin yuklenmesi ve webelementlerin bulunmasi icin gerekli sureyi
        implicitly wait ile ayarlariz.

        Implicitly wait sayfanin yuklenmesi ve
        her bir webelementin bulunmasi icin tanimlanan
        max. bekleme suresidir.
        Her islem icin sifirdan baslar ve max sure doluncaya kadar gorevi tamamlamaya calisir.
        max sure icerisinde gorev tamamlanamazsa
        exception verip calismayi durdurur

        Testlerin buyuk cogunlugunda
        implicitly wait suresi
        senkronizasyonu saglamak icin yeterli olur
        ANCAK
        ozel bir gorev icin implicitly wait'de tanimlanan
        max. bekleme suresinden daha fazla beklememiz gerekirse
        O GOREVE OZGU, TEK SEFERLIK bir wait olusturabiliriz

     */

    // 1. Iki tane metod olusturun : implicitWait() , explicitWait() Iki metod icin de asagidaki adimlari test edin.
    // 2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 3. Remove butonuna basin.
    // 4. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 5. Add buttonuna basin
    // 6. It’s back mesajinin gorundugunu test edin

    @Test
    public void test01(){

        // implicitly wait'in rolunu gorebilmek icin
        // baslangic ayarlarini bu test method'unda yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYazisiElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYazisiElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackYazisiElementi.isDisplayed());

        driver.close();
    }

    @Test
    public void explicitlyWaitTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
            Burada testi manuel olarak yapip
            bir karar vermemiz gerekiyor
            1- Test etmek istedigimiz webelement zaten gorunuyorsa;
                webelement'i locate yapip sonra ozel beklemeyi tanimlarim

            2- Test etmek istedigimiz elementin ulasilabilir olmasi icin beklemek gerekiyorsa;
               locatar'i verip, "bu locator ile bir element locate edene kadar
               exception firlatma bekle" diyebiliriz.
         */

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // 4. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackMesajiElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackMesajiElementi.isDisplayed());

        driver.close();

    }
}

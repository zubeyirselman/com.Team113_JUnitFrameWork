package day06_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {

     /*
        Bu class icerisinde 3 test calistiralim
        1- google anasayfaya gidip, url'in google icerdigini test edin
        2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
     */

    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur.

        ***Junit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

        Diyelim ki; bir @Test methodu uzerinde calisiyorsunuz ve
        o method' un toplu calistirilmalarda kullanilmasini istemiyorsunuz,
        bu durumda @Ignore kullanabilirsiniz.
     */

    WebDriver driver;

    @Test @Ignore // tum class' i run ettigimizde ignore ettigimiz google testini calistirmayacak (yok sayacak).
    public void googleTest(){
        // 1- google anasayfaya gidip, url'in google icerdigini test edin
        mahserin4Atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("google testi PASSED");
        }else {
            System.out.println("Url google icermiyor, google testi FAILED");
        }
        driver.close();
    }

    @Test
    public void wiseTest(){
        //2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        mahserin4Atlisi();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Wise testi PASSED");
        }else {
            System.out.println("Url wisequarter icermiyor, wise testi FAILED");
        }
        driver.close();
    }
    @Test
    public void amazonTest(){
        //3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));
        if (amazonLogoElementi.isDisplayed()){
            System.out.println("Amazon testi PASSED");
        }else {
            System.out.println("Amazon testi FAILED");
        }
        driver.close();
    }

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}

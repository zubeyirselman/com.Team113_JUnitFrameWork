package day13_ExcelOtomasyonu_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon anasayfaya gidelim
        // Nutella aratalim
        // Sonuclarin Nutella icerdigini test edelim
        // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim


        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // Nutella aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        WebElement sonucElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String expectedIcerik = "Nutella";
        String actualSonucYazisi= sonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim

        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaFoto = new File("target/ekranFotolari/tumSayfaFoto.png");

        File geciciFoto = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciFoto,tumSayfaFoto);

    }
}

package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReusableMethods {
    public static void tumSayfaFotoCek(WebDriver driver) {
        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        String tarihEtiketi = "TumSayfa"+ldt.getYear()+ldt.getMonth()+ldt.getDayOfMonth()
                +ldt.getHour()+ldt.getMinute()+ldt.getSecond()+".png";

        String path = "target/EkranFotolari/" + tarihEtiketi;
        File tumSayfaFotograf = new File(path);

        File geciciFoto = tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciFoto,tumSayfaFotograf);
        } catch (IOException e) {
        }
    }

    public static void webElementFotoCek(WebDriver driver, WebElement webElement){

        LocalDateTime ldt = LocalDateTime.now();
        String tarihEtiketi = "WebElement"+ldt.getYear()+ldt.getMonth()+ldt.getDayOfMonth()
                                          +ldt.getHour()+ldt.getMinute()+ldt.getSecond()+".png";

        String path = "target/EkranFotolari/" + tarihEtiketi;
        File tumSayfaFotograf = new File(path);

        File geciciFoto = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciFoto,tumSayfaFotograf);
        } catch (IOException e) {
        }

    }
}

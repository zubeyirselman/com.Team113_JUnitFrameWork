package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_KlavyeActions extends TestBase {

    //1- https://www.amazon.com sayfasina gidelim
    //2- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin
    //   ve Enter’a basarak arama yaptirin
    //3- aramanin gerceklestigini test edin

    @Test
    public void test01() throws InterruptedException {

        //1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //2- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin
        //   ve Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(3000);

        //3- aramanin gerceklestigini test edin
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Samsung A71";
        String actualSonuc = sonucYazisiElementi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

    }

}

package TakimCalismasi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_test05 extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        // 1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 2. Verify that home page is visible successfully
        WebElement homePageHtmlElementi = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePageHtmlElementi.isDisplayed());

        // 3. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 4. Verify 'New User Signup!' is visible
        WebElement newUserElementi = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserElementi.isDisplayed());

        // 5. Enter name and already registered email address
        WebElement isimKutusuElementi = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        isimKutusuElementi.sendKeys("derya");
        WebElement emailKutusuElementi = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        emailKutusuElementi.sendKeys("derdrs11@gmail.com");

        // 6. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        // 7. Verify error 'Email Address already exist!' is visible
        WebElement errorElementi = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(errorElementi.isDisplayed());
        Thread.sleep(3000);
    }
}

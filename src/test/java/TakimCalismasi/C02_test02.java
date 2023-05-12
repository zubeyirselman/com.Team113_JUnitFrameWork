package TakimCalismasi;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_test02 extends TestBase {

    @Test
    public void test01(){

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement sayfaElementi = driver.findElement(By.xpath("//html[@lang='en']"));
        sayfaElementi.isDisplayed();

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginYazisiElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        loginYazisiElementi.isDisplayed();

        // 6. Enter correct email address and password
        WebElement emailKutucuguElementi = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailKutucuguElementi.sendKeys("zsk@zsk.com");

        WebElement passwordKutucuguElementi = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordKutucuguElementi.sendKeys("123456");

        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        // 8. Verify that 'Logged in as username' is visible
        WebElement loggedYazisiElementi = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        loggedYazisiElementi.isDisplayed();

        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deletedElementi = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        deletedElementi.isDisplayed();

    }
}

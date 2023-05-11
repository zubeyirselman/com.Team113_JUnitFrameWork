package TakimCalismasi;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_RegisterUser {
       //1. Launch browser
       //2. Navigate to url 'http://automationexercise.com'
       //3. Verify that home page is visible successfully
       //4. Click on 'Signup / Login' button
       //5. Verify 'New User Signup!' is visible
       //6. Enter name and email address
       //7. Click 'Signup' button
       //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       //9. Fill details: Title, Name, Email, Password, Date of birth
       //10. Select checkbox 'Sign up for our newsletter!'
       //11. Select checkbox 'Receive special offers from our partners!'
       //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       //13. Click 'Create Account button'
       //14. Verify that 'ACCOUNT CREATED!' is visible
       //15. Click 'Continue' button
       //16. Verify that 'Logged in as username' is visible
       //17. Click 'Delete Account' button
       //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    WebDriver driver;
    @Before
    public void setup(){
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void RegisterUserTesti() throws InterruptedException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePageElementi = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(homePageElementi.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupElementi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignupElementi.isDisplayed());

        //6. Enter name and email address
        WebElement nameElementi = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameElementi.sendKeys("ZSK");
        WebElement emailElementi = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailElementi.sendKeys("zsk@zsk.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement kayitBasariliElementi = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(kayitBasariliElementi.isDisplayed());

        //9. Fill details: Title, Password, Date of birth
        WebElement titleElementi = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        titleElementi.click();
        WebElement passwordElementi = driver.findElement(By.xpath("//input[@id='password']"));
        passwordElementi.sendKeys("123456654321");
        Thread.sleep(2000);
        WebElement dogumTarihiGunElementi = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(dogumTarihiGunElementi);
        select.selectByIndex(3);
        Thread.sleep(2000);
        WebElement dogumTarihiAyElementi = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1 = new Select(dogumTarihiAyElementi);
        select1.selectByIndex(1);
        Thread.sleep(2000);
        WebElement dogumTarihiYilElementi = driver.findElement(By.xpath("//select[@id='years']"));
        Select select2 = new Select(dogumTarihiYilElementi);
        select2.selectByValue("1964");
        Thread.sleep(2000);

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        Thread.sleep(2000);

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        Thread.sleep(2000);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameElementi = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstNameElementi.sendKeys("zubeyir");
        Thread.sleep(2000);

        WebElement lastNameElementi = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastNameElementi.sendKeys("kahraman");
        Thread.sleep(2000);

        WebElement companyElementi = driver.findElement(By.xpath("//input[@id='company']"));
        companyElementi.sendKeys("wiseQuarter");
        Thread.sleep(2000);

        WebElement adress1Elementi = driver.findElement(By.xpath("//input[@id='address1']"));
        adress1Elementi.sendKeys("Manavgat");
        Thread.sleep(2000);

        WebElement adress2Elementi = driver.findElement(By.xpath("//input[@id='address2']"));
        adress2Elementi.sendKeys("İzmir");
        Thread.sleep(2000);

        WebElement countryElementi = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry = new Select(countryElementi);
        selectCountry.selectByValue("Canada");
        Thread.sleep(2000);

        WebElement stateElementi = driver.findElement(By.xpath("(//input[@class='form-control'])[9]"));
        stateElementi.sendKeys("Akdeniz");
        Thread.sleep(2000);

        WebElement cityElementi = driver.findElement(By.xpath("(//input[@class='form-control'])[10]"));
        cityElementi.sendKeys("Antalya");
        Thread.sleep(2000);

        WebElement zipcodeElementi = driver.findElement(By.xpath("(//input[@class='form-control'])[11]"));
        zipcodeElementi.sendKeys("073526");
        Thread.sleep(2000);

        WebElement mobileNumberElementi = driver.findElement(By.xpath("(//input[@class='form-control'])[12]"));
        mobileNumberElementi.sendKeys("05423330707");
        Thread.sleep(2000);

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        Thread.sleep(2000);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedElementi = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedElementi.isDisplayed());
        Thread.sleep(2000);

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        Thread.sleep(2000);

        //16. Verify that 'Logged in as username' is visible
        WebElement loggedYazisiElementi = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(loggedYazisiElementi.isDisplayed());
        Thread.sleep(2000);

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        Thread.sleep(2000);

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedElementi = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeletedElementi.isDisplayed());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Continue']")).click();
    }
}

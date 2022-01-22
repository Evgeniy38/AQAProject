package BBC1Tests.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertTrue;

public class Task2Tests {

    private WebDriver driver;
    private static final String URL = "https://www.bbc.com/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void testCheckIsEmptyFieldForQuestion() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();
        isVisiblePopupWindow();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Name']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@aria-label='Email address']")).sendKeys("email@mail.com");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        assertTrue(driver.findElement(By.xpath("//div[@class='input-error-message']"))
                .getText().contains("can't be blank"));
    }

    @Test
    public void testCheckIsEmptyNameField() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();
        isVisiblePopupWindow();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='What questions would you like us to answer?']"))
                .sendKeys("some text");
        driver.findElement(By.xpath("//input[@aria-label='Email address']")).sendKeys("email@mail.com");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        assertTrue(driver.findElement(By.xpath("//div[@class='input-error-message']"))
                .getText().contains("Name can't be blank"));
    }

    @Test
    public void testCheckIsEmptyEmailField() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();
        isVisiblePopupWindow();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='What questions would you like us to answer?']"))
                .sendKeys("some text");
        driver.findElement(By.xpath("//input[@aria-label='Name']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        assertTrue(driver.findElement(By.xpath("//div[@class='input-error-message']"))
                .getText().contains("Email address can't be blank"));
    }

    @Test
    public void testCheckWithoutPressingCheckbox() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")).click();
        isVisiblePopupWindow();
        driver.findElement(By.xpath("//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='What questions would you like us to answer?']"))
                .sendKeys("some text");
        driver.findElement(By.xpath("//input[@aria-label='Name']")).sendKeys("Name");
        driver.findElement(By.xpath("//input[@aria-label='Email address']")).sendKeys("email@mail.com");
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        assertTrue(driver.findElement(By.xpath("//div[@class='input-error-message']"))
                .getText().contains("must be accepted"));
    }

    private void isVisiblePopupWindow() {
        if (driver.findElement(By.xpath("//div[@class='tp-iframe-wrapper tp-active']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[@class='tp-close tp-active']")).click();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

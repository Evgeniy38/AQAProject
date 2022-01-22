package BBC1Tests.task3.pageobject.tests;

import BBC1.pageobject.pages.HomePage;
import BBC1.pageobject.pages.NewsPage;
import BBC1.pageobject.pages.YourCoronavirusStoriesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String BBC_URL = "https://www.bbc.com/";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BBC_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public NewsPage getNewsPage() {
        return new NewsPage(getDriver());
    }

    public YourCoronavirusStoriesPage getYourCoronavirusStoriesPage() {
        return new YourCoronavirusStoriesPage(getDriver());
    }
}

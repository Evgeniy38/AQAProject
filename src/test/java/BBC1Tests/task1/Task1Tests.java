package BBC1Tests.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task1Tests {

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
    public void checkTheNameOfTheHeadlineArticle() {
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        WebElement webElement = driver.findElement(By
                .xpath("//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]"));
        String text = webElement.getText();
        assertTrue(text.contains("Tonga says tsunami was 'unprecedented disaster'"));
    }

    @Test
    public void checkSecondaryArticleTitles() {
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        List<WebElement> elements = driver.findElements(By
                .xpath("//div[contains(@class, 'top-stories__secondary-item')]//h3[contains(@class, 'heading__title')]"));
        List<String> titlesList = new ArrayList<>();
        titlesList.add("Tonga tsunami: Before and after eruption");
        titlesList.add("Nobody told me drinks event broke rules - Johnson");
        titlesList.add("Saudis warned of jail time for posting rumours");
        titlesList.add("'World's most valuable house' - which no one wanted to buy");
        titlesList.add("AT&T agrees another 5G delay at US airports");
        List<String> textsElements = elements.stream().map(WebElement::getText).collect(Collectors.toList());
        assertTrue(textsElements.containsAll(titlesList));
    }

    @Test
    public void checkTheNameOfTheFirstArticleAgainstASpecifiedValue() {
        driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom']")).click();
        WebElement webElement = driver.findElement(By
                .xpath("//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]"));
        String text = webElement.getText();
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(text, Keys.ENTER);
        List<WebElement> webElementsList = driver.findElements(By
                .xpath("//p[@class='ssrcss-6arcww-PromoHeadline e1f5wbog4']"));
        assertTrue(webElementsList
                .get(0)
                .getText()
                .contains("Tonga tsunami sparks 'unprecedented disaster', government says"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

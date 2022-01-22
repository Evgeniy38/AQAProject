package BBC1.pageobject.pages;

import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String NEWS_BUTTON = "//li[@class='orb-nav-newsdotcom']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewsButton() {
        driver.findElement(xpath(NEWS_BUTTON)).click();
    }
}

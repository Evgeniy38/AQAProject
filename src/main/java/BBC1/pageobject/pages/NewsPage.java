package BBC1.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.By.xpath;

public class NewsPage extends BasePage {

    private static final String MAIN_TITLE = "//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]";
    private static final String SECONDARY_TITLES = "//div[contains(@class, 'top-stories__secondary-item')]//h3[contains(@class, 'heading__title')]";

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfMainTitle() {
        return driver.findElement(xpath(MAIN_TITLE)).getText();
    }

    public List<WebElement> getSecondaryTitlesList() {
        return driver.findElements(xpath(SECONDARY_TITLES));
    }
}

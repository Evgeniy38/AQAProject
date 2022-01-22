package BBC1.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.By.xpath;

public class NewsPage extends BasePage {

    private static final String MAIN_TITLE =
            "//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]";
    private static final String SECONDARY_TITLES =
            "//div[contains(@class, 'top-stories__secondary-item')]//h3[contains(@class, 'heading__title')]";
    private static final String CORONAVIRUS_BUTTON =
            "//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']";
    private static final String YOUR_CORONAVIRUS_STORIES =
            "//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']";
    private static final String YOUR_QUESTION_ANSWERED = "//a[@href='/news/52143212']";

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfMainTitle() {
        return driver.findElement(xpath(MAIN_TITLE)).getText();
    }

    public List<WebElement> getSecondaryTitlesList() {
        return driver.findElements(xpath(SECONDARY_TITLES));
    }

    public void clickOnCoronavirusButton() {
        driver.findElement(xpath(CORONAVIRUS_BUTTON)).click();
    }

    public void clickOnYourCoronavirusStoriesButton(){
        driver.findElement(xpath(YOUR_CORONAVIRUS_STORIES)).click();
    }

    public void clickOnYourQuestionAnswered(){
        driver.findElement(xpath(YOUR_QUESTION_ANSWERED)).click();
    }
}

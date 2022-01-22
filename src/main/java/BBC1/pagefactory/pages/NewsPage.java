package BBC1.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'primary__story')]//h3[contains(@class, 'promo-heading')]")
    private WebElement mainTitle;

    @FindBy(xpath = "//div[contains(@class, 'top-stories__secondary-item')]//h3[contains(@class, 'heading__title')]")
    private List<WebElement> secondaryTitles;

    @FindBy(xpath = "//a[@class = 'nw-o-link']/ span[text() = 'Coronavirus']")
    private WebElement coronavirusButton;

    @FindBy(xpath = "//a[@class = 'nw-o-link']/ span[text() = 'Your Coronavirus Stories']")
    private WebElement yourCoronavirusStories;

    @FindBy(xpath = "//a[@href='/news/52143212']")
    private WebElement yourQuestionAnswered;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfMainTitle() {
        return mainTitle.getText();
    }

    public List<WebElement> getSecondaryTitlesList() {
        return secondaryTitles;
    }

    public void clickOnCoronavirusButton() {
        coronavirusButton.click();
    }

    public void clickOnYourCoronavirusStoriesButton() {
        yourCoronavirusStories.click();
    }

    public void clickOnYourQuestionAnswered() {
        yourQuestionAnswered.click();
    }
}

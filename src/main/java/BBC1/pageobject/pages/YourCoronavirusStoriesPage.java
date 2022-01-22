package BBC1.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.By.xpath;

public class YourCoronavirusStoriesPage extends BasePage {

    private static final String NAME_FIELD = "//input[@aria-label='Name']";
    private static final String EMAIL_FIELD = "//input[@aria-label='Email address']";
    private static final String QUESTION_FIELD = "//textarea[@aria-label='What questions would you like us to answer?']";
    private static final String ACCEPT_CHECKBOX = "//input[@type='checkbox']";
    private static final String SUBMIT_BUTTON = "//button[text() = 'Submit']";
    private static final String ERROR_MESSAGE = "//div[@class='input-error-message']";

    public YourCoronavirusStoriesPage(WebDriver driver) {
        super(driver);
    }

    public void fillInTheNameField(String name) {
        driver.findElement(xpath(NAME_FIELD)).sendKeys(name);
    }

    public void fillInTheEmailField(String email) {
        driver.findElement(xpath(EMAIL_FIELD)).sendKeys(email);
    }

    public void fillInTheQuestionField(String question) {
        driver.findElement(xpath(QUESTION_FIELD)).sendKeys(question);
    }

    public void clickAcceptCheckbox() {
        driver.findElement(xpath(ACCEPT_CHECKBOX)).click();
    }

    public void clickSubmitButton() {
        driver.findElement(xpath(SUBMIT_BUTTON)).click();
    }

    public List<WebElement> getErrorMessages() {
        return driver.findElements(xpath(ERROR_MESSAGE));
    }

}

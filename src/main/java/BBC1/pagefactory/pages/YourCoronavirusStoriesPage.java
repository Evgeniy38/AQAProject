package BBC1.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class YourCoronavirusStoriesPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//textarea[@aria-label='What questions would you like us to answer?']")
    private WebElement questionField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement acceptCheckbox;

    @FindBy(xpath = "//button[text() = 'Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private List<WebElement> errorMessage;

    public YourCoronavirusStoriesPage(WebDriver driver) {
        super(driver);
    }

    public void fillInTheNameField(String name) {
        nameField.sendKeys(name);
    }

    public void fillInTheEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillInTheQuestionField(String question) {
        questionField.sendKeys(question);
    }

    public void clickAcceptCheckbox() {
        acceptCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public List<WebElement> getErrorMessages() {
        return errorMessage;
    }
}
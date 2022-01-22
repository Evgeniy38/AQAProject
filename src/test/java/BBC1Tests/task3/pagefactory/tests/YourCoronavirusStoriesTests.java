package BBC1Tests.task3.pagefactory.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class YourCoronavirusStoriesTests extends BaseTest {

    private String NAME = "Name";
    private String EMAIL = "email@mail.com";
    private String QUESTION = "some text";
    private String EMPTY_QUESTION_FIELD_MESSAGE = "can't be blank";
    private String EMPTY_NAME_FIELD_MESSAGE = "Name can't be blank";
    private String EMPTY_EMAIL_FIELD_MESSAGE = "Email address can't be blank";
    private String EMPTY_CHECKBOX_MESSAGE = "must be accepted";


    @Test
    public void testCheckIfEmptyFieldForQuestion() {
        getHomePage().implicitWait(20);
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getNewsPage().clickOnCloseButtonIfVisiblePopupWindow();
        getNewsPage().clickOnYourCoronavirusStoriesButton();
        getNewsPage().clickOnYourQuestionAnswered();
        getYourCoronavirusStoriesPage().fillInTheNameField(NAME);
        getYourCoronavirusStoriesPage().fillInTheEmailField(EMAIL);
        getYourCoronavirusStoriesPage().clickAcceptCheckbox();
        getYourCoronavirusStoriesPage().clickSubmitButton();
        assertTrue(getYourCoronavirusStoriesPage()
                .getErrorMessages()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .contains(EMPTY_QUESTION_FIELD_MESSAGE));
    }

    @Test
    public void testCheckIfEmptyNameField() {
        getHomePage().implicitWait(20);
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getNewsPage().clickOnCloseButtonIfVisiblePopupWindow();
        getNewsPage().clickOnYourCoronavirusStoriesButton();
        getNewsPage().clickOnYourQuestionAnswered();
        getYourCoronavirusStoriesPage().fillInTheQuestionField(QUESTION);
        getYourCoronavirusStoriesPage().fillInTheEmailField(EMAIL);
        getYourCoronavirusStoriesPage().clickAcceptCheckbox();
        getYourCoronavirusStoriesPage().clickSubmitButton();
        assertTrue(getYourCoronavirusStoriesPage()
                .getErrorMessages()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .contains(EMPTY_NAME_FIELD_MESSAGE));
    }

    @Test
    public void testCheckIfEmptyEmailField() {
        getHomePage().implicitWait(20);
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getNewsPage().clickOnCloseButtonIfVisiblePopupWindow();
        getNewsPage().clickOnYourCoronavirusStoriesButton();
        getNewsPage().clickOnYourQuestionAnswered();
        getYourCoronavirusStoriesPage().fillInTheQuestionField(QUESTION);
        getYourCoronavirusStoriesPage().fillInTheNameField(NAME);
        getYourCoronavirusStoriesPage().clickAcceptCheckbox();
        getYourCoronavirusStoriesPage().clickSubmitButton();
        assertTrue(getYourCoronavirusStoriesPage()
                .getErrorMessages()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .contains(EMPTY_EMAIL_FIELD_MESSAGE));
    }

    @Test
    public void testCheckWithoutPressingCheckbox() {
        getHomePage().implicitWait(20);
        getHomePage().clickOnNewsButton();
        getNewsPage().clickOnCoronavirusButton();
        getNewsPage().clickOnCloseButtonIfVisiblePopupWindow();
        getNewsPage().clickOnYourCoronavirusStoriesButton();
        getNewsPage().clickOnYourQuestionAnswered();
        getYourCoronavirusStoriesPage().fillInTheQuestionField(QUESTION);
        getYourCoronavirusStoriesPage().fillInTheNameField(NAME);
        getYourCoronavirusStoriesPage().fillInTheEmailField(EMAIL);
        getYourCoronavirusStoriesPage().clickSubmitButton();
        assertTrue(getYourCoronavirusStoriesPage()
                .getErrorMessages()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .contains(EMPTY_CHECKBOX_MESSAGE));
    }

}

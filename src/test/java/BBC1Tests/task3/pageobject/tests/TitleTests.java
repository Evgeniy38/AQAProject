package BBC1Tests.task3.pageobject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;


public class TitleTests extends BaseTest {

    private String MAIN_TITLE = "Ukraine hits back at Biden amid Russia tensions";
    private List<String> SECONDARY_TITLES = Arrays.asList(
            "Minor incursion or invasion? Biden clarifies on Russia",
            "US piracy charges over Belarus forced landing",
            "I've seen no evidence of blackmailing, says UK PM",
            "Capitol riot inquiry asks Ivanka Trump to testify",
            "Tearful Adele postpones entire Las Vegas residency");


    @Test
    public void checkTheNameOfTheHeadlineArticle() {
        getHomePage().clickOnNewsButton();
        assertTrue(getNewsPage().getTextOfMainTitle().contains(MAIN_TITLE));
    }

    @Test
    public void checkSecondaryArticleTitles() {
        getHomePage().clickOnNewsButton();
        List<String> textsElements = getNewsPage()
                .getSecondaryTitlesList()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertTrue(textsElements.containsAll(SECONDARY_TITLES));
    }

}

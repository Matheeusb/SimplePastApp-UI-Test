package com.simplepastapp.tests;

import static org.testng.Assert.*;

import com.simplepastapp.BaseTest;
import com.simplepastapp.datadriven.SimplePastDataProvider;
import org.testng.annotations.Test;
import com.simplepastapp.pages.SimplePastPage;

public class SimplePastTest extends BaseTest {

    @Test(dataProvider = "score", dataProviderClass = SimplePastDataProvider.class)
    public void validateScore(int digits, String startDigit) {
        SimplePastPage simplePastPage = new SimplePastPage(driver)
                .playGame()
                .typeAnswer(digits, startDigit);

        assertTrue(simplePastPage.getPointsLabel().getText().startsWith(startDigit));
        assertEquals(simplePastPage.getCoinsLabel().getText(), "coins");
        assertTrue(simplePastPage.getRestartButton().isDisplayed());
        assertEquals(simplePastPage.getAnswerInput().getText(), "type the simple past here");
    }
}

package com.simplepastapp.tests;

import static org.testng.Assert.*;

import com.simplepastapp.BaseTest;
import org.testng.annotations.Test;
import com.simplepastapp.pages.SimplePastPage;

public class SimplePastTest extends BaseTest {

    @Test
    public void validatesScoreGreaterThan100() {
        int digits = 3;

        SimplePastPage simplePastPage = new SimplePastPage(driver)
                .playGame()
                .typeAnswer(digits);

        assertTrue(simplePastPage.getPointsLabel().getText().startsWith("10"));
        assertEquals(simplePastPage.getCoinsLabel().getText(), "coins");
        assertTrue(simplePastPage.getRestartButton().isDisplayed());
    }
}

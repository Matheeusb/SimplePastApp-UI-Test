package com.simplepastapp.datadriven;

import lombok.experimental.UtilityClass;
import org.testng.annotations.DataProvider;

@UtilityClass
public class SimplePastDataProvider {

    @DataProvider(name = "score")
    public static Object[][] getLimitScore() {
        return new Object[][] {
                {2, "4"}, {2, "7"}, {3, "1"}
        };
    }
}

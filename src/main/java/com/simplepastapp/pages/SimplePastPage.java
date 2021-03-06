package com.simplepastapp.pages;

import com.simplepastapp.object.SimplePast;
import com.simplepastapp.object.SimplesPastFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class SimplePastPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    private SimplesPastFactory simplesPastFactory;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    private MobileElement playButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[3]")
    @CacheLookup
    private MobileElement wordLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.EditText")
    @CacheLookup
    private MobileElement answerInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
    private MobileElement pointsLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")
    private MobileElement coinsLabel;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    private MobileElement restartButton;

    public SimplePastPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20L);
        this.simplesPastFactory = new SimplesPastFactory();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public SimplePastPage playGame() {
        playButton.click();
        return this;
    }

    public SimplePastPage typeAnswer(int digits, String startDigit) {
        while (pointsLabel.getText().length() != digits || !pointsLabel.getText().startsWith(startDigit)) {
            answerInput.sendKeys(verify(wordLabel.getText()));
        }
        return this;
    }

    private String verify(String workBase) {
        for (SimplePast word : simplesPastFactory.list) {
            if (word.getBaseForm().equals(workBase)) {
                return word.getPastTenseForm();
            }
        }
        return null;
    }
}

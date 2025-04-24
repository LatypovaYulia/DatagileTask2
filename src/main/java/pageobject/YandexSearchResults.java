package pageobject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class YandexSearchResults {

    private SelenideElement noThanksButton = $x(".//button[contains(@class, 'Distribution-ButtonClose_view_button')]");
    private SelenideElement gazIsLink = $x(".//a[contains(@href, 'www.gaz-is.ru') and contains(@class, 'Link_theme_outer')]");

    @Step("Click No,thanks button in pop-up window")
    public void clickNoThanksButton() {
        noThanksButton.shouldBe(visible).click();
    }

    @Step("Click link: www.gaz-is.ru ")
    public void clickGazIsLink() {
        gazIsLink.shouldBe(visible, Duration.ofSeconds(20)).click();
        List<String> tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }
}

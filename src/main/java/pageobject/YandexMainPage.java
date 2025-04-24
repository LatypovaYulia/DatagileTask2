package pageobject;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class YandexMainPage {
    public static String YANDEX_MAIN_PAGE_URL = "https://www.yandex.ru/";

    private SelenideElement searchFrame = $x(".//iframe[contains(@id, 'ya-search-iframe')]");
    private SelenideElement searchInput = $x(".//input[contains(@class, 'arrow__input') and @name='text']");
    private SelenideElement searchButton = $x(".//button[contains(@class, 'arrow__button') and text()=\"Найти\"]");

    @Step("Enter text in Yandex search bar and click search button")
    public void searchTextOnYandexPage(String text) {
        switchTo().frame(searchFrame);
        searchInput.shouldBe(visible).setValue(text);
        searchButton.click();
        switchTo().defaultContent();
        List<String> tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs.get(tabs.size() - 1));
    }
}

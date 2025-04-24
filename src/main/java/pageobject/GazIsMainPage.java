package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GazIsMainPage {

    public static String GAZ_IS_MAIN_PAGE_URL = "https://www.gaz-is.ru/";

    private SelenideElement productsButton = $x(".//a[contains(@class, 'main-nav') and text()='Продукты']");
    private SelenideElement ankeyIdmButton = $x(".//*[@id='div431']//a[text()='Ankey IDM']");

    @Step("Click products button")
    public void clickProductsButton() {
        productsButton.shouldBe(visible).click();
    }

    @Step("Click Ankey IDM button")
    public void clickAnkeyIdmButton() {
        ankeyIdmButton.shouldBe(visible).click();
    }
}

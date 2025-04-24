package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AnkeyIdmPage {
    public static String ANKEY_IDM_MAIN_PAGE_URL = "https://www.gaz-is.ru/produkty/upravlenie-ib/ankey-idm";

    private SelenideElement materialsButton = $x(".//span[text()='Материалы']");
    private SelenideElement userManualLink = $x(".//a[contains(text(), 'Руководство пользователя')]");

    @Step("Click materials button")
    public void clickMaterialsButton() {
        materialsButton.scrollTo();
        materialsButton.shouldBe(visible).click();
    }

    @Step("Click user manual link")
    public void clickUserManualLink() {
        userManualLink.shouldBe(visible).click();
    }

    @Step("Download user manual file")
    public File downloadUserManual() throws FileNotFoundException {
        return userManualLink.shouldBe(visible).download();
    }
}

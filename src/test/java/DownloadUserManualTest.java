import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.AnkeyIdmPage;
import pageobject.GazIsMainPage;
import pageobject.YandexMainPage;
import pageobject.YandexSearchResults;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;
import static pageobject.AnkeyIdmPage.ANKEY_IDM_MAIN_PAGE_URL;
import static pageobject.GazIsMainPage.GAZ_IS_MAIN_PAGE_URL;
import static pageobject.YandexMainPage.YANDEX_MAIN_PAGE_URL;

public class DownloadUserManualTest extends BaseTest {
    YandexMainPage yandexMainPage;
    YandexSearchResults yandexSearchResults;
    GazIsMainPage gazIsMainPage;
    AnkeyIdmPage ankeyIdmPage;

    @Before
    public void setUp() {
        yandexMainPage = new YandexMainPage();
        yandexSearchResults = new YandexSearchResults();
        gazIsMainPage = new GazIsMainPage();
        ankeyIdmPage = new AnkeyIdmPage();
        open(YANDEX_MAIN_PAGE_URL);
        yandexMainPage.searchTextOnYandexPage("Газинформсервис");
        yandexSearchResults.clickNoThanksButton();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Open https://www.gaz-is.ru/")
    @Description("Check that user can open https://www.gaz-is.ru/ through Yandex search bar")
    public void openGazIsWebsiteTest() {

        yandexSearchResults.clickGazIsLink();
        webdriver().shouldHave(WebDriverConditions.url(GAZ_IS_MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Open Ankey IDM page")
    @Description("Check that user can open Ankey IDM page on website https://www.gaz-is.ru/")
    public void openAnkeyIdmPageTest() {

        yandexSearchResults.clickGazIsLink();
        gazIsMainPage.clickProductsButton();
        gazIsMainPage.clickAnkeyIdmButton();

        webdriver().shouldHave(WebDriverConditions.url(ANKEY_IDM_MAIN_PAGE_URL));
    }

    @Test
    @DisplayName("Download user manual")
    @Description("Check that the user manual is downloaded")
    public void downloadUserManualTest() throws FileNotFoundException {

        yandexSearchResults.clickGazIsLink();
        gazIsMainPage.clickProductsButton();
        gazIsMainPage.clickAnkeyIdmButton();

        webdriver().shouldHave(WebDriverConditions.url(ANKEY_IDM_MAIN_PAGE_URL));

        ankeyIdmPage.clickMaterialsButton();
        ankeyIdmPage.clickUserManualLink();

        File downloaded = ankeyIdmPage.downloadUserManual();
        assertTrue("Файл не был скачан", downloaded.exists());
    }
}

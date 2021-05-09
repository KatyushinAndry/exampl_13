
//gradle test -Ddriver=local
//gradle test -Ddriver=remote
package pure.main.owner.tests.pureweb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pure.main.owner.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    @Test
    @Tag("ui")
    @Tag("smoke")
    @DisplayName("Checking the main page of 'pure.app'")
    void openMainPageTest(){

        step("Open page", () -> open(""));

        step("Checking that the main page is opened correctly", () -> {
            $(".intro-title").shouldHave(text("SHAMELESS HOOKUP DATING"));
        });
    }


    @Test
    @Tag("functional")
    @Tag("smoke")
    @DisplayName("Checking Google authorization page")
    void googleLoginPageTest(){

        step("Open page", () -> open(""));

        step("Opening google authorization page", () -> $(".android.login-button").click());

        step("Google authorization page check", () -> {
            $(".Y4dIwd").shouldHave(text("pure.app"));
        });
    }

    @Test
    @Tag("functional")
    @Tag("smoke")
    @DisplayName("Checking Apple authorization page")
    void appleLoginPageTest(){

        step("Open page", () -> open(""));

        step("Opening Apple authorization page", () -> $(".ios.login-button").click());

        step("Apple authorization page check", () -> {
            switchTo().window(1);
            $(".si-container-title").shouldHave(text("Pure"));
        });
    }
}

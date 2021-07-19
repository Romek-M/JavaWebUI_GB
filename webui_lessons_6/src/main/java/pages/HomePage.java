package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import BaseView;
import ru.filenko.views.NavigationBar;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomePage extends BaseView {
    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }
    @Step(value = "Assert that current url equals {url}")
    public void checkUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }
    @Step("In navigation bar")
    public NavigationBar getPageNavigation() {
        return navigationBar;
    }
}

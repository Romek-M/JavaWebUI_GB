package features.navigation;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import base.BaseUITest;
import common.Configuration;
import enums.NavigationBarTabs;
import pages.LoginPage;

import static common.Configuration.BASE_URL;

@Feature("Navigation")
public class NavigationTest extends BaseUITest  {

    @Disabled
    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    public void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .checkUrl(BASE_URL)
                .getPageNavigation()
                .checkTabVisibility(barTab);
    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

}

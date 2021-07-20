package features.navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import base.BaseUITest;
import common.Configuration;
import enums.NavigationBarTabs;
import pages.LoginPage;

public class NavigationTest extends BaseUITest  {

    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    public void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);

    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

}
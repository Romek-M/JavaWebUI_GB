package features.login;

import org.junit.jupiter.api.Test;
import base.BaseUITest;
import pages.LoginPage;

import static common.Configuration.BASE_URL;
import static common.Configuration.STUDENT_LOGIN;
import static common.Configuration.STUDENT_PASSWORD;

public class PositiveLoginTest extends BaseUITest {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);
    }
}

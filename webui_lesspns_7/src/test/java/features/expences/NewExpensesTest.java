package features.expences;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import base.BaseUITest;
import common.Configuration;
import enums.ExpenseSubMenuButtons;
import enums.NavigationBarTabs;
import pages.AllExpensesPage;
import pages.LoginPage;

import java.util.Locale;

@Feature("Expenses")
public class NewExpensesTest extends BaseUITest {

    @Disabled
    @Story("Создание заявки на расход")
    @Test
    public void createNewExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        Faker faker = new Faker(new Locale("ru"));
        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription(faker.name().fullName())
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();
    }
}

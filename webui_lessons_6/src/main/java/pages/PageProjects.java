package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import BaseView;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageProjects extends BaseView {
    @FindBy(xpath = "//a[@title='Создать проект']")
    private WebElement createNewProjectButton;

    @FindBy(xpath = "//a[@title='Создать проект']")
    private WebElement createNewBTProjectButton;

    public PageProjects(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
        return new NewProjectPage(driver);
    }

    public PageProjects checkNewProjectPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Проект сохранен"));
        return this;
    }
}

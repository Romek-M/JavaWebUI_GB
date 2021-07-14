package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import BaseView;

public class NewProjectPage extends BaseView {

    @FindBy(name = "crm_project[name]")
    private WebElement nameTextInput;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnitDropDownSelect;

    @FindBy(name = "crm_project[curator]")
    private WebElement curatorDropDownSelect;

    @FindBy(name = "crm_project[rp]")
    private WebElement choiceTeamLeaderSelect;

    @FindBy(name = "crm_project[manager]")
    private WebElement managerDropDownSelect;

    @FindBy(xpath = ".//button[@data-action='{\\\"route\\\":\\\"crm_project_index\\\"}']")
    private WebElement submitButton;

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage enterDescription(String description) {
        nameTextInput.sendKeys(description);
        return this;
    }

    public NewProjectPage selectBusinessUnit(int value) {
        Select businessUnitDropDown = new Select(businessUnitDropDownSelect);
        businessUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }


    public NewProjectPage selectCurator(int value) {
        Select curatorDropDown = new Select(curatorDropDownSelect);
        curatorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage selectTeamLeader(int value) {
        Select choiceTeamLeader = new Select(choiceTeamLeaderSelect);
        choiceTeamLeader.selectByValue(String.valueOf(value));
        return this;
    }

    public NewProjectPage selectManager(int value) {
        Select managerDropDown = new Select(managerDropDownSelect);
        managerDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public PageProjects clickSubmit() {
        submitButton.clear();
        return new PageProjects(driver);
    }

}

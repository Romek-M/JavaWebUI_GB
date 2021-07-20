
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private final String STUDENT_LOGIN = "user";
    private final String STUDENT_PASSWORD = "1234";
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @BeforeAll
    public static void setupWebDriverManager() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        setUpDriverSession();

    }

    @Test
    public void testLogin() {
        login();
        createProject();


    }

    @Test
    public void testCreatePerson() {
        login();
        editProject();
    }

    private void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));

        loginButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    protected void createProject() {
        WebElement projects = driver.findElement(By.xpath("//a[@class='unclickable']/span[text()='Проекты']"));
        projects.click();

        WebElement myProject = driver.findElement(By.xpath("//li[@data-route='crm_project_my']"));
        myProject.click();

        WebElement createNewProject = driver.findElement(By.xpath("//a[@title='Создать проект']"));
        createNewProject.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement nameForm = driver.findElement(By.name("crm_project[name]"));
        nameForm.sendKeys("Test8087");
        Select choiceDivision = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        choiceDivision.selectByValue("1");

        Select choiceCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        choiceCurator.selectByValue("114");

        Select choiceTeamLeader = new Select(driver.findElement(By.name("crm_project[rp]")));
        choiceTeamLeader.selectByValue("95");

        Select choiceManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        choiceManager.selectByValue("114");

        WebElement buttonSave = driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_project_index\"}']"));
        buttonSave.click();

        Assertions.assertTrue(projects.isDisplayed());

        String message = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Проект сохранен"));



    }

    private void editProject(){
        WebElement projects = driver.findElement(By.xpath("//a[@class='unclickable']/span[text()='Проекты']"));
        projects.click();

        WebElement myProject = driver.findElement(By.xpath("//li[@data-routes='[\"\\/^crm_project_[^bonus]\\/\"]']"));
        myProject.click();

        driver.findElement(By.xpath("//strong[@class='filter-criteria-hint']")).click();

        WebElement findProject = driver.findElement(By.xpath("//input[@name='value']"));
        findProject.sendKeys("Test8085");
        WebElement buttonUpdate = driver.findElement(By.xpath("//div[@class='value-field-frame']/button[@type='button']"));
        buttonUpdate.click();

        driver.findElement(By.xpath("//td[text()='Test8085']")).click();

        driver.findElement(By.xpath("//a[@title='Редактировать']")).click();
        WebElement textArea = driver.findElement(By.name("crm_project_marketing[uniqueDescription]"));
        textArea.clear();
        textArea.sendKeys("New project2");
        WebElement buttonSave = driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_project_index\"}']"));
        buttonSave.click();
        String message = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        Assertions.assertTrue(message.contains("Проект сохранен"));



    }

    private void createContactPerson() {
        WebElement projects = driver.findElement(By.xpath("//a[@class='unclickable']/span[text()='Контрагенты']"));
        projects.click();
        WebElement myProject = driver.findElement(By.xpath("//li[@data-routes='[\"\\/^crm_contact\\/\"]']"));
        myProject.click();
        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement lastName = driver.findElement(By.cssSelector("input[name='crm_contact[lastName]']"));
        lastName.sendKeys("Petrova");

        WebElement firstName = driver.findElement(By.cssSelector("input[name='crm_contact[firstName]']"));
        firstName.sendKeys("Kate");

        WebElement choiceOrganization = driver.findElement(By.xpath("//span[text()='Укажите организацию']"));
        choiceOrganization.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        WebElement jobTitle = driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']"));
        jobTitle.sendKeys("менеджер");

        driver.findElement(By.xpath("//button[@data-action='{\"route\":\"crm_contact_index\"}']")).click();

    }

    private void setUpDriverSession() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        jsExecutor = (JavascriptExecutor) driver;
    }
}

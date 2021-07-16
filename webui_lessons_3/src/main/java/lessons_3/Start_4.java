package lessons_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class Start_4 {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "user";
    private static final String STUDENT_PASSWORD = "1234";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void main(String[] args) throws InterruptedException {
        login();

       // Клик на кнопку "Проекты"
        driver.findElement(By.xpath(".//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a[@class='unclickable']/span[text()='Проекты']")).click();

        // Клик на выпадашку "Все проекты"
        driver.findElement(By.xpath(".//span[@class='title' and text()='Все проекты']")).click();

        // кликаем на кнопку создания проекта
        sleep(5000);
        driver.findElement(By.cssSelector("div[class='pull-left btn-group icons-holder']")).click();

        // ввод в поле "наименование"
        sleep(2000);
        driver.findElement(By.xpath('.//input[@data-ftid="crm_project_name"])).sendKeys("test");

       // работа с Select. Выбор поля "подразделение"
        Select businessUnitDropdown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropdown.selectByValue("1");
        System.out.println("Select: " + businessUnitDropdown.getFirstSelectedOption().getText());


        // работа с Select. Выбор поля "куратор проекта"
        Select curatorDropdown = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorDropdown.selectByValue("6");

        // работа с Select. Выбор поля "руководитель проекта"
        Select rpDropdown = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpDropdown.selectByValue("7");

        // работа с Select. Выбор поля "менеджер"
        Select managerDropdown = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerDropdown.selectByValue("8");

        // Нажимаем 'Сохранить и закрыть'
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();


    }

        private static void login() {
            driver.get(LOGIN_PAGE_URL);

            WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
            loginTextInput.sendKeys(STUDENT_LOGIN);

            WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
            passwordTextInput.sendKeys(STUDENT_PASSWORD);

            WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
            loginButton.click();


        }





}


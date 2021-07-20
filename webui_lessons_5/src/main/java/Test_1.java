

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;


public class Test_1 {

    private static final String STUDENT_LOGIN = "Test@2277";
    private static final String STUDENT_Password = "qwerty@7722";




    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.diary.ru/");

        //Thread.sleep(5000);
        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 20);
        waitFiveSeconds.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id='drop-login']"))));

        //Вход в личный кабинет
        WebElement registration = driver.findElement(By.xpath("//a[@id='drop-login']"));
        registration.click();
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='user_login']"))));


        WebElement loginTextInput = driver.findElement(By.xpath("//input[@name='user_login']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='user_pass']"));
        passwordInput.sendKeys(STUDENT_Password);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.id("signin_btn")).click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='i-menu-newpost']"))));



        //Создание новой записи
        WebElement myDiary = driver.findElement(By.xpath("//span[@class='i-menu-newpost']"));
        myDiary.click();


        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.id("postTitle"))));


        driver.findElement(By.id("postTitle")).sendKeys("Новый день");

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.findElement(By.name("message")).sendKeys("Hello world!");

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.findElement(By.id("rewrite")).click();

        driver.quit();

    }
}

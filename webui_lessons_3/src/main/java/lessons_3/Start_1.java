package lessons_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Start_1 {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";



    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-in-incognito");

        driver = new ChromeDriver(options);
        driver.get(LOGIN_PAGE_URL);
        Thread.sleep(1000);

        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.manage().window().setSize(new Dimension(500, 500));
        Thread.sleep(1000);
    }

}

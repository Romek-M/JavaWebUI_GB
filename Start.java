package lessons_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver(). setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        Thread.sleep(2000);

        driver.close();

        Thread.sleep(2000);

        driver.quit();
    }
}

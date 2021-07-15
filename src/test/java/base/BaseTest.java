package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public static void beforeClass() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeMethod
        protected void beforeMethod() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @AfterMethod
        protected void afterMethod() {
            driver.quit();
        }

        protected WebDriver getDriver() {
            return driver;
        }

        protected WebDriverWait getWait() {
            if (wait == null) {
                wait = new WebDriverWait(driver, 10);
            }
            return wait;
        }
}




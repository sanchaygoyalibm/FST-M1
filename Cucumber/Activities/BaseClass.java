package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    static WebDriver driver=new ChromeDriver();
    static WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
}

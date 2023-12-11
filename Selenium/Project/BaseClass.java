package liveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
    public  static WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = new ChromeDriver();

    }
    @AfterTest(alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}

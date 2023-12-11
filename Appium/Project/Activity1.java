package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Activity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel4Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 20);
    }
    @Test
    public void addTasks() throws InterruptedException {
        addTask("Complete Activity with Google Tasks");
        addTask("Complete Activity with Google Keep");
        addTask("Complete the second Activity Google Keep");
        MobileElement lists=driver.findElementById("tasks_list");
        List<MobileElement> taskList=lists.findElements(MobileBy.xpath("//android.widget.FrameLayout"));
        Assert.assertEquals(taskList.size()/2,3);
    }
    public void addTask(String taskName) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        // Using Accessibility ID
        driver.findElementByAccessibilityId("Create new task").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").sendKeys(taskName);
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Create new task")));
    }

    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}

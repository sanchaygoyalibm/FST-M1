package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 extends BaseClass {
    @Test
    public void menuCheckingTestCase() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        //driver.manage().window().fullscreen();
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        driver.manage().window().fullscreen();
        WebElement navigationActivitiesMenu = driver.findElement(By.id("grouptab_3"));
        String activitiesMenuText = navigationActivitiesMenu.getText();
        Assert.assertEquals(activitiesMenuText, "ACTIVITIES");
    }
}

package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity4 extends BaseClass{
    @Test
    @Parameters({"user", "password"})
    public void loginTestCase(String username, String password) throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        driver.findElement(By.id("bigbutton")).click();

        String homePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(homePageUrl, "https://alchemy.hguy.co/crm/index.php?module=Home&action=index");
    }
}

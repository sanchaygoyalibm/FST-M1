package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

public class Activity5 extends BaseClass {
    @Test
    @Parameters({"user", "password"})
    public void gettingColorsTestCase(String username, String password) throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("bigbutton")).click();

        WebElement navigationMenu=driver.findElement(By.id("toolbar"));
        String colorCode=navigationMenu.getCssValue("background-color");
        System.out.println("Color of navigation menu: " + navigationMenu.getCssValue("background-color"));
    }
}

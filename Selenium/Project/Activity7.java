package liveProject;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity7 extends BaseClass{
    @Test
    public void readingAdditionalInfoTestCase() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        //driver.manage().window().fullscreen();
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        driver.manage().window().fullscreen();

        driver.findElement(By.id("grouptab_0")).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("moduleTab_9_Leads")));
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@title='Additional Details']")));
        driver.findElement(By.xpath("//span[@title='Additional Details']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='phone']")));
        String mobileNumber=driver.findElement(By.xpath("//span[@class='phone']")).getText();
        System.out.println("Mobile number in additional details pop up:" + mobileNumber);
    }
}

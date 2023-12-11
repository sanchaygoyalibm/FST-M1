package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

public class Activity8 extends BaseClass{
    @Test
    public void traversingTableTestCase() throws InterruptedException {
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("moduleTab_9_Accounts")));
        driver.findElement(By.id("moduleTab_9_Accounts")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
        List<WebElement> nameList=driver.findElements(By.xpath("//td[@type='name']"));
        System.out.println("Names of the first 5 odd-numbered rows:");
        for(int i=0;i<nameList.size();i=i+2)
        {
            String name=nameList.get(i).findElement(By.tagName("a")).getText();
            System.out.println(name);
            if(i==8)
                break;
        }
    }
}

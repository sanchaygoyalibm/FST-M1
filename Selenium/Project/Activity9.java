package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 extends BaseClass {
    @Test
    public void traversingTable2TestCase() throws InterruptedException {
        driver.get("http://alchemy.hguy.co/crm");
        //driver.manage().window().fullscreen();
        WebElement usernameField = driver.findElement(By.id("user_name"));
        WebElement passwordField = driver.findElement(By.id("username_password"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        driver.manage().window().fullscreen();

        driver.findElement(By.id("grouptab_0")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("moduleTab_9_Leads")));
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        driver.manage().window().fullscreen();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
        List<WebElement> nameList=driver.findElements(By.xpath("//td[@type='name']"));
        System.out.println("Names of the first 10:");
        for(int i=0;i<nameList.size();i++)
        {
            String name=nameList.get(i).findElement(By.tagName("a")).getText();
            System.out.println(name);
            if(i==9)
                break;
        }
        List<WebElement> userList=driver.findElements(By.xpath("//td[@type='relate']"));
        System.out.println("First 10 users:");
        for(int i=0;i<userList.size();i++)
        {
            String user=userList.get(i).findElement(By.tagName("a")).getText();
            System.out.println(user);
            if(i==9)
                break;
        }
    }
}

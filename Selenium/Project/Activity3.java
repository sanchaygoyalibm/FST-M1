package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Activity3 extends BaseClass {
    @Test
    public void headerUrlTest() {
        driver.get("http://alchemy.hguy.co/crm");
        WebElement copyRightFooter = driver.findElement(By.id("admin_options"));
        String textFooter = copyRightFooter.getText();
        System.out.println("Text of copyright footer: " + textFooter);
    }
}

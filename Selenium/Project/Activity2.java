package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity2 extends BaseClass {
    @Test
    public void headerUrlTest() {
        driver.get("http://alchemy.hguy.co/crm");
        WebElement logo = driver.findElement(By.className("companylogo"));
        WebElement image=logo.findElement(By.tagName("img"));
        String urlHeaderImage=image.getAttribute("src");
        System.out.println("Url of HeaderImage: " + urlHeaderImage);
    }
}

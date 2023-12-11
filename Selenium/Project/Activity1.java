package liveProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 extends BaseClass {
    @Test
    public void pageTitleTest() {
        driver.get("http://alchemy.hguy.co/crm");
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "SuiteCRM");
    }
}

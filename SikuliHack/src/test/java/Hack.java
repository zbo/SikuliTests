/**
 * Created by bob on 17/3/2.
 */
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Pattern;


public class Hack {
    DefaultSelenium selenium;
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver=new ChromeDriver();
        //driver=new FirefoxDriver();
        String source = "http://www.baidu.com";
        driver.get(source);

    }

    @Test
    public void testTest() throws Exception {
        WebElement webElement = driver.findElement(By.xpath("/html"));
        Assert.assertTrue(webElement.getAttribute("outerHTML").length() > 0);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

package org.test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class webpagetest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://meghanajogar.github.io/day2-simple-web/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        String expectedTitle = "simple website";

        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        Assert.assertTrue(actualTitle.contains("simple website"));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
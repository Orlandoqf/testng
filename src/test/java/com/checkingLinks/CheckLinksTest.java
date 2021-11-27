package com.checkingLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

public class CheckLinksTest {
    WebDriver driver;
    CheckingLinksPage page;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        page = new CheckingLinksPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
    }
    @Test
    public void checkingLinks(){
        assertTrue(page.CheckingPageLinks(), "There are broken links");
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

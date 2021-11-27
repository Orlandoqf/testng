package com.qualitystream.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class CrossBrowsertesting {

    private WebDriver driver;
    By searchBox = By.name("q");
    By videoLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");

    @BeforeClass
    @Parameters({"URL", "BrowserType"})
    public void beforeClass(String url, String browserType) {

        if (browserType.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();

        }else if (browserType.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver", "./src/test/resources/chromedriver/geckodriver.exe");
            driver = new FirefoxDriver();

        }else if (browserType.equalsIgnoreCase("Internet Explorer")){

            System.setProperty("webdriver.ie.driver", "./src/test/resources/chromedriver/IEDriverServer");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("Opening: "+ browserType);
        }


    @Test
    public void googlesearch(){
        WebElement searchBoxElement = driver.findElement(searchBox);
        searchBoxElement.clear();
        searchBoxElement.sendKeys("quality-stream Introduccion a la automatizacion de Pruebas de Software");
        searchBoxElement.submit();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.presenceOfElementLocated(videoLocator));

        assertTrue(driver.findElement(videoLocator).isDisplayed());

    }
    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}

package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestConfiguration
{
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser()
    {
        System.setProperty("webdriver.chrome.drive", "C:/work/ioana/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }

    public void navigateToMyAccount()
    {
        driver.get("https://www.catelulgras.ro/my-account/");
    }

    public void navigateToHomePage()
    {
        driver.get("https://www.catelulgras.ro/");
    }
}

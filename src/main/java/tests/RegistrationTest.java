package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import util.TestConfiguration;

public class RegistrationTest extends TestConfiguration
{
    @Test
    public void createAccount()
    {
        navigateToMyAccount();
        driver.findElement(By.id("reg_email")).sendKeys("ana.ionescu@yahoo.com");
        driver.findElement(By.id("reg_password")).sendKeys("ionescu@1234");
    }
}

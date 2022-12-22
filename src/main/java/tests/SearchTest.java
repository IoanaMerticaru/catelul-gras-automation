package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestConfiguration;

import java.util.List;

public class SearchTest extends TestConfiguration
{
    @Test
      public void searchProductbyname()
    {
        navigateToHomePage();
       driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("mancare pisici");
        driver.findElement(By.className("icon-search")).click();
        List<WebElement> listResults = driver.findElements(By.cssSelector(".products > .product-small"));
        Assert.assertNotEquals(listResults.size(), 0, "No products!");
    }

    @Test
    public void searchProductByCodeBar()
    {
        navigateToHomePage();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("100409N");
        driver.findElement(By.className("icon-search")).click();
        List<WebElement> listResults = driver.findElements(By.cssSelector(".products"));
        Assert.assertNotEquals(listResults.size(), 0, "Product not found!");
//        Current bug: There is a bug in product list search by code!
    }
}



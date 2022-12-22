package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.TestConfiguration;

import java.util.List;

public class ShoppingCartTest extends TestConfiguration
{

    @Test
    public void addProductToCart()
    {
        navigateToHomePage();
        WebElement menuList = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div[1]/ul/li[4]/a"));
        WebElement subMenuElement = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div[1]/ul/li[4]/ul/li[2]/a"));
        Actions s = new Actions(driver);
        s.moveToElement( menuList );
        s.click(subMenuElement);
        s.build().perform();
        WebElement products = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/div[1]/a/img"));
        s.click(products);
        s.build().perform();
        driver.findElement(By.className("single_add_to_cart_button")).click();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(),1, "One item in the shopping cart!");
    }

    @Test
    public void removeProductFromCart() throws InterruptedException
    {
        navigateToHomePage();
        WebElement menuList = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div[1]/ul/li[4]/a"));
        WebElement subMenuElement = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div[1]/ul/li[4]/ul/li[2]/a"));
        Actions s = new Actions(driver);
        s.moveToElement( menuList );
        s.click(subMenuElement);
        s.build().perform();

        WebElement products = driver.findElement(By.xpath("/html/body/div[1]/main/div/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/div[1]/a/img"));
        s.click(products);
        s.build().perform();
        driver.findElement(By.className("single_add_to_cart_button")).click();

        Thread.sleep(300);

        navigateToHomePage();
        WebElement menuList1 = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div[1]/ul/li[4]/a"));
        WebElement subMenuElement1 = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div/div[1]/ul/li[4]/ul/li[2]/a"));
        Actions s1 = new Actions(driver);
        s1.moveToElement(menuList1);
        s1.click(subMenuElement1);
        s1.build().perform();
        WebElement product2 = driver.findElement(By.cssSelector("div.has-hover:nth-child(2)"));
        s1.click(product2);
        s1.build().perform();
        driver.findElement(By.className("single_add_to_cart_button")).click();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItems.size(),2, "Two items in the shopping cart!");

        Thread.sleep(300);
        driver.findElement(By.cssSelector("tr.woocommerce-cart-form__cart-item:nth-child(2) > td:nth-child(1) > a:nth-child(1)")).click();
        driver.findElement(By.className("current")).click();
        List<WebElement> cartItem = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(cartItem.size(),1, "Only one  item in the shopping cart!");
    }

}

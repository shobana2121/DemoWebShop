package com.test;



import com.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class CartTest {

    WebDriver driver;
    WebDriverWait wait;
    CartPage cart;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);

        cart = new CartPage(driver);
    }

    @Test
    public void verifyCartPage() throws InterruptedException {

        System.out.println("Adding products...");
        cart.addProducts();

        System.out.println("Opening cart...");
        cart.openCart();

        Thread.sleep(2000);

        String cartText = cart.getCartText();

        if (cartText.contains("Your Shopping Cart is empty")) {
            System.out.println("Cart is EMPTY ❌");
        } else {

            String productName = cart.getProductName();
            String quantity = cart.getQuantity();

            System.out.println("Product: " + productName);
            System.out.println("Quantity: " + quantity);

            Assert.assertTrue(productName.length() > 0);

            cart.updateQuantity();
            System.out.println("Quantity updated!");

            cart.removeProduct();
            System.out.println("Product removed!");
        }
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
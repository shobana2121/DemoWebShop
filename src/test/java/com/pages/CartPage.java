package com.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // ✅ Locators
    By cartTitle = By.xpath("//div[@class='page-title']/h1");
    By productNameTxt = By.xpath("//td[@class='product']/a");
    By emptyCartMsg = By.cssSelector(".order-summary-content");
    By qtyInput = By.cssSelector("input.qty-input");
    By updateCartBtn = By.cssSelector("input[name='updatecart']");
    By removeCheckbox = By.cssSelector("input[name='removefromcart']");
    By cartLink = By.xpath("//span[text()='Shopping cart']");

    // ✅ Add to cart buttons (skip gift cards)
    By firstAddToCart = By.xpath("(//input[@value='Add to cart'])[2]");
    By secondAddToCart = By.xpath("(//input[@value='Add to cart'])[3]");
    By thirdAddToCart = By.xpath("(//input[@value='Add to cart'])[4]");

    // ✅ Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Actions
    public void addProducts() throws InterruptedException {
        driver.findElement(firstAddToCart).click();
        Thread.sleep(2000);

        driver.findElement(secondAddToCart).click();
        Thread.sleep(2000);

        driver.findElement(thirdAddToCart).click();
        Thread.sleep(2000);
    }

    public void openCart() throws InterruptedException {
        driver.findElement(cartLink).click();
        Thread.sleep(3000);
    }

    public String getCartText() {
        return driver.findElement(emptyCartMsg).getText();
    }

    public String getProductName() {
        return driver.findElement(productNameTxt).getText();
    }

    public String getQuantity() {
        return driver.findElement(qtyInput).getAttribute("value");
    }

    public void updateQuantity() throws InterruptedException {
        driver.findElement(qtyInput).clear();
        Thread.sleep(1000);

        driver.findElement(qtyInput).sendKeys("2");
        Thread.sleep(1000);

        driver.findElement(updateCartBtn).click();
        Thread.sleep(2000);
    }

    public void removeProduct() throws InterruptedException {
        driver.findElement(removeCheckbox).click();
        Thread.sleep(1000);

        driver.findElement(updateCartBtn).click();
        Thread.sleep(2000);
    }
}
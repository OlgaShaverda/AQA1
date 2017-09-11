// alt+insert (Generate), Enter
// наводим курсор на название тестового метода и нажимаем Ctrl+Q - можем увидеть наше описание теста во всплывающем окне

package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    /**
     * # CASE 1: LOG IN AS ADMIN
     * # Open site <br/>
     * # Open admin login page <br/>
     * # Enter credentials <br/>
     * # Submit form <br/>
     * # Find element to verify that log in is successful.
     */

    @Test
    public void ValidAdminLoginTest() throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demostore.x-cart.com/");
        driver.findElement(By.xpath("//li/a[@title=\"Admin area\"]")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//div/a[@class='link']/span[text()=\"Sign out\"]"));

    }

    /**
     * # CASE 2: CREATE A NEW USER
     * # Open site <br/>
     * # Open admin login page <br/>
     * # Enter admin credentials <br/>
     * # Submit form <br/>
     * # <b>Expected Result:</b> Admin logged into account
     * # Click on 'Users list' link <br/>
     * # Click on 'Add user' button <br/>
     * # Enter new user credentials <br/>
     * # Click on 'Create account' button <br/>
     * * # <b>Expected Result:</b> User should be created
     */

    @Test
    public void UserCreation() throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demostore.x-cart.com/");
        driver.findElement(By.xpath("//li/a[@title=\"Admin area\"]")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue("Admin should be logged in", false);
        driver.findElement(By.xpath("//a[@title=\"Users list\"]")).click();
        driver.findElement(By.xpath("//button[@class='btn  regular-button']")).click();
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@id='password-conf']")).sendKeys("Confirm password");
        driver.findElement(By.xpath("//div/button[@type='submit']/span[text()='Create account']")).click();

    }

    /**
     * # CASE 3: LOG IN AS USER
     * # Open site <br/>
     * # Open login popup
     * # Enter user credentials <br/>
     * # Submit form <br/>
     * # <b>Expected Result:</b> User logged into account
     */

    @Test
    public void ValidLoginTest() throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demostore.x-cart.com/");
        driver.findElement(By.xpath("//div[@class='header_bar-sign_in']/button")).click();
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Password");
        driver.findElement(By.xpath("//td/button[@type='submit']/span[text()='Sign in']")).click();

    }

    /**
     * # CASE 4: ADD TO CART
     * # Open site <br/>
     * # Click on 'Toys' link <br/>
     * # Click on 'Geek toys' link <br/>
     * # Hover mouse over a product and click on 'Add to Cart' button <br/>
     * # Find element to be sure that product is added
     */

    @Test
    public void AddToCart() throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demostore.x-cart.com/");
        driver.findElement(By.xpath("//li[@class='leaf has-sub']/ul/li/a/span[contains(text(),'Toys')]")).click();
        driver.findElement(By.xpath("//span[@class='subcategory-name'][text()='Geek toys']")).click();
        driver.findElement(By.xpath(".//div[@class='list-container']/div[@class=\"block block-block\"]/div/div/div/ul/li[@class='product-cell box-product'][1]/div/div/div[@class=\"add-to-cart-button\"]/button")).click();
        driver.findElement(By.xpath(".//div[@title=\"Your cart\"]/div/h4[@class='title']/a[text()='1 item in cart']"));

        driver.findElement(By.xpath("//div[@title='Your cart']/div[text()='1']"));


    }
}

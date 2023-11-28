package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. userShouldAddProductSuccessFullyToShoppingCart()
    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() {

        ////Mouse Hover on Gear Menu
        WebElement gear = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
        WebElement bags = driver.findElement(By.xpath("//a[@id='ui-id-25']//span[contains(text(),'Bags')]"));
        Actions a1 = new Actions(driver);
        a1.moveToElement(gear).moveToElement(bags).click().build().perform();

        // Click on Bags
        WebElement overnightDuffle = driver.findElement(By.xpath("//span[@class='product-image-wrapper']//img[@alt='Overnight Duffle']"));
        overnightDuffle.click();

        // Click on Product Name ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Overnight Duffle", expectedText, actualText);

        //Change Qty 3
        WebElement qty = driver.findElement(By.xpath("//input[@id='qty']"));
        qty.sendKeys(Keys.BACK_SPACE);
        qty.sendKeys("3");

        // Click on ‘Add to Cart’ Button.
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
        addToCartButton.click();

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        WebElement actualTextElement1 = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String actualText1 = actualTextElement1.getText();
        Assert.assertEquals("You added Overnight Duffle to your shopping cart.", expectedText1, actualText1);

        // Click on ‘shopping cart’ Link into message
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']//a[contains(text(),'shopping cart')]"));
        shoppingCart.click();

        //Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        WebElement actualTextElement2 = driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        String actualText2 = actualTextElement2.getText();
        Assert.assertEquals( expectedText2, actualText2);

        WebElement qty1 = driver.findElement(By.xpath("//input[@id='cart-237670-qty']"));
        qty1.clear();
        qty1.sendKeys("3");

        // Verify the Qty is ‘3’
        String expectedText3 = "3";
        WebElement actualTextElement3 = driver.findElement(By.xpath("//input[@id='cart-483768-qty' and @value='3']"));
        String actualText3 = actualTextElement3.getText();
        Assert.assertEquals("3", expectedText3, actualText3);

        // Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        WebElement actualTextElement4 = driver.findElement(By.xpath("//span[@class='cart-price']//span[text()='$135.00']"));
        String actualText4 = actualTextElement4.getText();
        Assert.assertEquals("$135.00", expectedText4, actualText4);

        // Change Qty to ‘5’
        WebElement qtyChange = driver.findElement(By.xpath("//input[@id='cart-483768-qty']"));
        qtyChange.sendKeys(Keys.BACK_SPACE);
        qtyChange.sendKeys("5");

        // Click on ‘Update Shopping Cart’ button
        WebElement updateShoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        updateShoppingCart.click();

        // Verify the product price ‘$225.00’
        String expectedText5 = "$225.00";
        WebElement actualTextElement5 = driver.findElement(By.xpath("//span[@class='cart-price']//span[text()='$225.00']"));
        String actualText5 = actualTextElement5.getText();
        Assert.assertEquals("$135.00", expectedText5, actualText5);

    }

    @After
    public void tearDown() {
        closeBrowser();
}


}

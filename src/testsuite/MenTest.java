package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.time.Duration;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));

        //5.1

        WebElement men = driver.findElement(By.xpath("//a[@class='level-top ui-corner-all']//span[.='Men']"));
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[.='Pants']"));
        Actions a1 = new Actions(driver);
        a1.moveToElement(men).moveToElement(bottoms).moveToElement(pants).click().build().perform();
        Thread.sleep(1000);

        WebElement cronusYogaPant =  driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        WebElement size32 = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        a1.moveToElement(cronusYogaPant).moveToElement(size32).click().build().perform();
        Thread.sleep(1000);

        WebElement cronusYogaPant1 =  driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        WebElement blackColour = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        a1.moveToElement(cronusYogaPant1).moveToElement(blackColour).click().build().perform();

        WebElement addToCartButton = driver.findElement(By.xpath("(//div)[77]"));
        a1.moveToElement(cronusYogaPant1).moveToElement(addToCartButton).click().build().perform();
        Thread.sleep(1000);

        String expectedText = "You added Cronus Yoga Pant to your shopping cart";
        Thread.sleep(1000);
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='page messages']//div[@data-bind=\"scope: 'messages'\"]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.", expectedText ,actualText );



        String expectedText1 = "Shopping Cart";
        WebElement actualTextElement1 = driver.findElement(By.xpath("//h1[@class='page-title']//span[contains(.,'Shopping Cart')]"));
        String actualText1 = actualTextElement1.getText();
        Assert.assertEquals("Shopping Cart",expectedText1,actualText1 );

        String expectedText2 = "Cronus Yoga Pant";
        WebElement actualTextElement2 = driver.findElement(By.xpath("(//div[@class='product-item-details'])[2]//strong//a"));
        String actualText2 = actualTextElement2.getText();
        Assert.assertEquals("Cronus Yoga Pant",expectedText2,actualText2 );

        String expectedText3 = "32";
        WebElement actualTextElement3 = driver.findElement(By.xpath("//div[@class='product-item-details']//dd[contains(text(),'32')]"));
        String actualText3 = actualTextElement3.getText();
       Assert.assertEquals("32",expectedText3,actualText3 );

        String expectedText4 = "Black";
        WebElement actualTextElement4 = driver.findElement(By.xpath("//dd[contains(text(),'Black')]"));
        String actualText4 = actualTextElement4.getText();
        Assert.assertEquals("Black",expectedText4,actualText4 );
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}


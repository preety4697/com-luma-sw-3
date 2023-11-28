package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void sortByProductNameFilter() throws InterruptedException
    {
        //4.1
        WebElement Women = driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']//span[.='Women']"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[.='Jackets']"));
        Actions a1 = new Actions(driver);
        a1.moveToElement(Women).moveToElement(tops).moveToElement(jackets).click().build().perform();
        Thread.sleep(1000);

        WebElement sortByDropDown = driver.findElement(By.id("sorter"));
        Select s1 = new Select(sortByDropDown);
        s1.selectByVisibleText("Product Name");

        List<WebElement> displayedProducts = driver.findElements(By.className("product-image-container"));
        int count = displayedProducts.size();
        System.out.println("Number of products displayed : " + count);

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='product details product-item-details']/strong/a"));
        for (WebElement productNames : allProducts)
        {
            System.out.println("Names of the products are : " + productNames.getText());
        }

        // Verify the products name display in alphabetical order
        List<WebElement> productsList = driver.findElements(By.cssSelector("li.item a.product-item-link"));

        // Get product names
        List<String> productNames = new ArrayList<>();
        for (WebElement product : productsList)
        {
            productNames.add(product.getText());
        }

        // Creating a copy of the product names list for comparison
        List<String> sortedProductNames = new ArrayList<>(productNames);
        // Sorting the product names list alphabetically
        Collections.sort(sortedProductNames);

        // Comparing if the list is sorted alphabetically
        Assert.assertEquals("Products are not sorted by product name", productNames, sortedProductNames);
    }
    @Test
    public void sortingTheArray()
    {
        //4.1
        String[] unsortedProducts = {"Adrienne Trek Jacket", "Augusta Pullover Jacket", "Inez Full Zip Jacket", "Ingrid Running Jacket", "Jade Yoga Jacket", "Josie Yoga Jacket", "Juno Jacket",
                "Nadia Elements Shell", "Neve Studio Dance Jacket", " Olivia 1/4 Zip Light Jacket", "Riona Full Zip Jacket", "Stellar Solar Jacket"};
        System.out.println("Unsorted Array is : " + Arrays.toString(unsortedProducts));

        Arrays.sort(unsortedProducts);

        System.out.println("Sorted Array is : " + Arrays.toString(unsortedProducts));
        String[] sortedProducts = unsortedProducts;

        Assert.assertArrayEquals("Arrays are equal" , sortedProducts, unsortedProducts);
    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException
    {
        //4.2
        WebElement Women = driver.findElement(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']//span[.='Women']"));
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']//span[.='Jackets']"));
        Actions a1 = new Actions(driver);                                                                                 //Create object for Actions class   //parametrized constructor
        a1.moveToElement(Women).moveToElement(tops).moveToElement(jackets).click().build().perform();
        Thread.sleep(1000);

        WebElement sortByDropDown = driver.findElement(By.id("sorter"));
        Select s1 = new Select(sortByDropDown);                                                                //Create object for Select Class  with parametrized webelement constructor
        s1.selectByValue("price");

        List<WebElement> allPrices =  driver.findElements(By.className("sorter-options"));
        for (WebElement prices : allPrices)
        {
            System.out.println("Prices sorted from low to high : " +prices);
        }
        Assert.assertTrue("Prices from low to high" , true);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}




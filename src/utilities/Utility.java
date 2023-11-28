package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will verify the text
     */
    public void verifyText(String expectedText, String actualText) {
        Assert.assertEquals(expectedText, actualText);
    }


    //************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will accept to alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text to alert
     */
    public void sendToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //*************************** Select Class Methods ***************************************//
    //Select by value from dropdown
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    //Select index from dropdown
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    //select by visible text from Dropdown
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
//    public void selectAllOptionFromDropDown(){
//        List<WebElement> dropDown = driver.findElement()
//    }


//*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will click action on mouse hover on element
     */
    public void clickMouseHoverOnElements(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
}

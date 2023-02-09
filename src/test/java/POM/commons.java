package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class commons implements seleniumInterface{

    @Override
    public void clickElement(WebDriver driver, By element) {
        driver.findElement(element).click();

    }

    @Override
    public void sendKeys(WebDriver driver, By element,String text) {
        driver.findElement(element).sendKeys(text);

    }
    @Override
    public String getElementText(WebDriver driver,By element)
    {
        return driver.findElement(element).getText();
    }

    public void webDriverWait(WebDriver driver,By element,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

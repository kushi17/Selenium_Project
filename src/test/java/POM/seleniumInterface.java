package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

interface seleniumInterface {
    public void clickElement(WebDriver driver, By element);
    public void sendKeys(WebDriver driver,By element,String text);
    public String getElementText(WebDriver driver,By element);

    public void webDriverWait(WebDriver driver,By element,int time);
}

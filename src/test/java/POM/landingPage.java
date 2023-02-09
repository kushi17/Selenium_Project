package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.propertyFileLoader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class landingPage {
    WebDriver driver;
    propertyFileLoader p=new propertyFileLoader();
    commons c=new commons();
    By searchbutton=By.xpath("//a[contains(text(),'Search')]/i");
    By searchInput=By.xpath("//input[@id='site-search-keyword']");
    By submitsearch=By.xpath("//button[@class='search-form-submit']");
    By results=By.xpath("//h4[@class='results']");
    By searchList=By.xpath("//div[@class='search-result']");
    String notpresent="Sorry, your search didn't return any results.";
    public WebDriver launchBrowser()
    {
        System.out.println("Setting the driver");
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        System.out.println("launching the browser");
        return driver=new ChromeDriver();

    }

    public void navigateToURL() throws IOException {
        driver.manage().window().maximize();
        System.out.println("Navigating to URL");
        driver.get(p.getURL());
    }

    public void searchKeyword(String keyword)
    {
        c.clickElement(driver,searchbutton);
        c.sendKeys(driver,searchInput,keyword);
        c.clickElement(driver,submitsearch);

    }

    public String getResultText()
    {
        c.webDriverWait(driver,results,30);
        return c.getElementText(driver,results);
    }

    public String verifyKeyword(String result,String keyword)
    {
        String status;

        if(getResultText().contains(notpresent))
        {

            System.out.println("Search result for keyword:"+keyword+" is "+result);
            status="not present";
        }
        else
        {
            c.webDriverWait(driver,searchList,30);
            System.out.println("Search results for:"+keyword);
            List<WebElement> lt=driver.findElements(searchList);
            for(int i=1;i< lt.size();i++)
            {

                driver.findElement(By.xpath("//div[@class='search-result']["+i+"]/p/a")).click();
                break;
            }
            return status="present";

        }
        return status;
    }

    public void closeBrowser()
    {
        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BehancePageSearch {

    WebDriver driver;

    public final String URL = "https://www.behance.net";
    private String xpathInputSearch = "//input[@name='search']";
    private String xpathResultText="//*[@id='site-content']/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div/div[2]/div[1]/span/a";

    public final String RESULT_TEXT="Advent Calendar 2022";




    public BehancePageSearch(WebDriver driver){
        this.driver = driver;
    }

    public void typeSearch(String searchInfo){
        By byInputSearch = By.xpath(xpathInputSearch);
        WebElement webElementSearch = driver.findElement(byInputSearch);
        webElementSearch.sendKeys(searchInfo);
    }

    public String getResultText(){
        By byResultText = By.xpath(xpathResultText);
        WebElement elementResultText = driver.findElement(byResultText);
        return elementResultText.getText();
    }

    public void fillSearchAndClick(String searchInfo){
        typeSearch(searchInfo);


    }

}

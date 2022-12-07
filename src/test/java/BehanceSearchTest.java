import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BehanceSearchTest {
    WebDriver driver;
    BehancePageSearch page;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new BehancePageSearch(driver);
        driver.get(page.URL);
        Util.waiter(3);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testBehanceSearch(){

        //TODO WHEN
        page.fillSearchAndClick("Advent Calendar 2022\n");
        Util.waiter(3);
        String actual = page.getResultText();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT, actual);
    }
}

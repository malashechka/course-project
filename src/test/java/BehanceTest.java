import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BehanceTest {
    WebDriver driver;
    BehancePage page;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new BehancePage(driver);
        driver.get(page.URL);
        Util.waiter(10);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testOpenBehance(){

        //TODO WHEN
        String actual = page.getResultTextInMainPage();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_IN_MAIN_PAGE, actual);
    }

    @Test
    public void testOpenBehanceLoginPage(){

        //TODO WHEN
        page.selectButtonLogin();
        Util.waiter(3);
        String actual = page.getResultTextInLoginPage();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_IN_PAGE_LOGIN, actual);
    }

    @Test
    public void testOpenBehanceLoginPageAndFillEmptyEmail() {

        //TODO WHEN
        page.selectButtonLogin();
        Util.waiter(3);
        page.selectButtonContinue();
        Util.waiter(3);
        String actual= page.getResultMessageOfEmptyEmail();

        // TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_ERROR_MESSAGE_EMPTY_EMAIL, actual);
    }

    @Test
    public void testOpenBehanceLoginPageAndFillIncorrectEmail() {

        //TODO WHEN
        page.fillEmailAndClickContinue("jfkdk@mail.ru");
        Util.waiter(3);
        String actual = page.getResultMessageOfIncorrectEmail();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_ERROR_MESSAGE_INCORRECT_EMAIL, actual);
    }

    @Test
    public void testOpenBehanceLoginPageAndValidEmail() {

        //TODO WHEN
        page.fillEmailAndClickContinue("ksenya.malasko@gmail.com");
        Util.waiter(3);
        String actual = page.getResultTextInPasswordPage();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_IN_PAGE_PASSWORD, actual);
    }

    @Test
    public void testOpenBehanceLoginPageAndFillEmptyPassword() {

        //TODO WHEN
        page.fillEmailAndClickContinue("ksenya.malasko@gmail.com");
        Util.waiter(3);
        page.selectButtonContinue();
        Util.waiter(3);
        String actual= page.getResultMessageOfEmptyPassword();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_ERROR_MESSAGE_INCORRECT_PASSWORD, actual);
    }

    @Test
    public void testOpenBehanceLoginPageAndFillIncorrectPassword() {

        //TODO WHEN
        page.fillLoginInfo("ksenya.malasko@gmail.com", "njcnde8a_Ki2");
        Util.waiter(3);
        String actual = page.getResultMessageOfIncorrectPassword();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_ERROR_MESSAGE_INCORRECT_PASSWORD, actual);
    }










    @Test
    public void testOpenBehanceLoginPageAndValidPassword() {

        //TODO WHEN
        page.fillLoginInfo("ksenya.malasko@gmail.com", "Dk20031203");
        Util.waiter(3);
        String actual = page.getResultTextAfterValidLogin();

        //TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_AFTER_VALID_LOGIN, actual);
    }
}

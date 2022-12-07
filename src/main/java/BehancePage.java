import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BehancePage {
    WebDriver driver;
    public final String URL = "https://www.behance.net";
    private String xpathButtonGoToLoginPage = "//button[@class='Btn-button-CqT Btn-tertiary-Z8Q Btn-normal-If5 js-adobeid-signin PrimaryNav-a11yButton-CuL e2e-PrimaryNav-Signin']";
    private String xpathLoginTitle = "//h1[text()='Sign in']";
    private String xpathDiscoverInMenu = "//*[@id='app']/div/div[1]/div/div[1]/div/div[2]/ul[1]/li[3]/a/h3";
    private String xpathButtonContinue = "//span[text()='Continue']";
    private String xpathErrorMessageIncorrectEmail = "//label[@data-id='EmailPage-EmailField-Error']";
    private String xpathInputEmail = "//input[@name='username']";
    private String xpathInputPassword = "//input[@name='password']";
    private String xpathErrorMessageIncorrectPassword = "//label[@data-id='PasswordPage-PasswordField-Error']";
    private String xpathPasswordTitle = "//h1[text()='Enter your password']";
    private String xpathResultTextAfterValidLogin = "//*[@id='site-content']/div/div[1]/h2";

    public final String RESULT_TEXT_IN_PAGE_LOGIN = "Sign in";
    public final String RESULT_TEXT_IN_MAIN_PAGE = "Discover";
    public final String RESULT_TEXT_ERROR_MESSAGE_EMPTY_EMAIL = "Please enter an email address.";
    public final String RESULT_TEXT_ERROR_MESSAGE_INCORRECT_EMAIL = "&quot;We couldn't find an account with that email address. &quot;";
    public final String RESULT_TEXT_IN_PAGE_PASSWORD = "Enter your password";
    public final String RESULT_TEXT_ERROR_MESSAGE_INCORRECT_PASSWORD = "That’s an incorrect password. Try again.";
    public final String RESULT_TEXT_AFTER_VALID_LOGIN = "Today's Work in Progress";

    public BehancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectButtonLogin() {
        By byButtonGoToLoginPage = By.xpath(xpathButtonGoToLoginPage);
        WebElement elementButtonGoToLoginPage = driver.findElement(byButtonGoToLoginPage);
        elementButtonGoToLoginPage.click();
    }

    public void selectButtonContinue() {
        By byXpathButtonContinue = By.xpath(xpathButtonContinue);
        WebElement elementButtonContinue = driver.findElement(byXpathButtonContinue);
        elementButtonContinue.click();
    }

    public String getResultTextInLoginPage() {
        By byLoginText = By.xpath(xpathLoginTitle);
        WebElement elementLoginTitle = driver.findElement(byLoginText);
        return elementLoginTitle.getText();
    }

    public String getResultTextInPasswordPage() {
        By byPasswordText = By.xpath(xpathPasswordTitle);
        WebElement elementPasswordTitle = driver.findElement(byPasswordText);
        return elementPasswordTitle.getText();
    }

    public String getResultTextInMainPage() {
        By byDiscoverText = By.xpath(xpathDiscoverInMenu);
        WebElement elementDiscoverInMenu = driver.findElement(byDiscoverText);
        return elementDiscoverInMenu.getText();
    }

    public String getResultMessageOfEmptyEmail() {
        By byErrorMessageEmptyEmail = By.xpath(xpathErrorMessageIncorrectEmail);
        WebElement elementErrorMessageEmptyEmail = driver.findElement(byErrorMessageEmptyEmail);
        noSuchElementEmailException();
        return elementErrorMessageEmptyEmail.getText();
    }

    public String getResultMessageOfEmptyPassword() {
        By byErrorMessageEmptyPassword = By.xpath(xpathErrorMessageIncorrectPassword);
        WebElement elementErrorMessageEmptyPassword = driver.findElement(byErrorMessageEmptyPassword);
        noSuchElementPasswordException();
        return elementErrorMessageEmptyPassword.getText();
    }

    public String getResultMessageOfIncorrectEmail() {
        By byErrorMessageIncorrectEmail = By.xpath(xpathErrorMessageIncorrectEmail);
        WebElement elementErrorMessageIncorrectEmail = driver.findElement(byErrorMessageIncorrectEmail);
        return elementErrorMessageIncorrectEmail.getText();
    }

    public String getResultMessageOfIncorrectPassword() {
        By byErrorMessageIncorrectPassword = By.xpath(xpathErrorMessageIncorrectPassword);
        WebElement elementErrorMessageIncorrectPassword = driver.findElement(byErrorMessageIncorrectPassword);
        return elementErrorMessageIncorrectPassword.getText();
    }

    public String getResultTextAfterValidLogin() {
        By byResultTextAfterValidLogin = By.xpath(xpathResultTextAfterValidLogin);
        WebElement elementResultTextAfterValidLogin = driver.findElement(byResultTextAfterValidLogin);
        return elementResultTextAfterValidLogin.getText();
    }

    public String noSuchElementEmailException() {
        By byXpathErrorMessageEmptyEmail = By.xpath(xpathErrorMessageIncorrectEmail);
        Duration duration = Duration.ofSeconds(1);
        WebElement elementErrorMessageEmptyEmail = (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.elementToBeClickable(byXpathErrorMessageEmptyEmail));
        return elementErrorMessageEmptyEmail.getText();
    }

    public String noSuchElementPasswordException() {
        By byXpathErrorMessageEmptyPassword = By.xpath(xpathErrorMessageIncorrectPassword);
        Duration duration = Duration.ofSeconds(1);
        WebElement elementErrorMessageEmptyPassword = (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.elementToBeClickable(byXpathErrorMessageEmptyPassword));
        return elementErrorMessageEmptyPassword.getText();
    }

    public void typeEmail(String email) {
        By byInputEmail = By.xpath(xpathInputEmail);
        WebElement elementInputEmail = driver.findElement(byInputEmail);
        elementInputEmail.sendKeys(email);
    }

    public void typePassword(String password) {
        By byInputPassword = By.xpath(xpathInputPassword);
        WebElement elementInputPassword = driver.findElement(byInputPassword);
        elementInputPassword.sendKeys(password);
    }

    public void fillEmailAndClickContinue(String email) {
        selectButtonLogin();
        Util.waiter(3);
        typeEmail(email);
        selectButtonContinue();
        Util.waiter(20);
    }

    public void fillLoginInfo(String email, String password) {
        fillEmailAndClickContinue(email);
        Util.waiter(3);
        typePassword(password);
        selectButtonContinue();
        Util.waiter(15);
    }
}
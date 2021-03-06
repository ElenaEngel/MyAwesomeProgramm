import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class GoogleTest {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "/home/elena/IdeaProjects/MyAwesomeProgramm/src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }


    @Test

    public void test001(){
        String queryText = "portnov computer school";

        openPage();
        typeIn(queryText);
        waitForElement();
        assertResult();

    }

    @Test

    public void test002(){
        String queryText = "#@#@!$!!#!@!";

        openPage();
        typeIn(queryText);
        waitForElement();
        assertResult();

    }

    @Test

    public void test003(){
        String queryText = "портнов компьютерная школа";

        openPage();
        typeIn(queryText);
        waitForElement();
        assertResult();

    }

    private void waitForElement(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultStats\"]")));
    }

    private void assertResult(){
        WebElement getResult = driver.findElement(By.xpath("//*[@id=\"resultStats\"]"));

        assertEquals(getResult.isDisplayed(), true);

    }

    private void openPage() {

        String url = "https://google.com";

        driver.get(url);}



    private void typeIn(String typeInText) {
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        searchInput.sendKeys(typeInText);
        searchInput.submit();

    }






}


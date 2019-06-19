import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class GoogleTestDataProvider {
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

    @DataProvider(name = "addMethodDataProvider")
     public Object[][] dataProvider() {
     return new Object[][] {{"portnov computer school", true}, { "#@#@!$!!#!@!", false}, {"портнов компьютерная школа", true} };
     }

     @Test(dataProvider = "addMethodDataProvider")

      public void testQuery(String testQuery, boolean result) {


         openPage();
         typeIn(testQuery);
         waitForElement();
         assertResult(result);
       }



    private void waitForElement(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultStats\"]")));
    }

    private void assertResult(boolean isDisplayed){
        WebElement getResult = driver.findElement(By.xpath("//*[@id=\"resultStats\"]"));

       assertEquals(getResult.isDisplayed(), isDisplayed);

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


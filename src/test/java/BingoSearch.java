import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BingoSearch {

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


        public void test001() {
            String textValue = "portnov computer school";

            openMainPage();
            typeIn(textValue);
            waitForResults();
            assertResult();

        }

        @Test
        public void test002() {
            String textValue = "#@#@!$!!#!@!";

            openMainPage();
            typeIn(textValue);
            waitForResults();
            assertResult();

        }

        @Test

        public void test003(){
            String queryText = "портнов компьютерная школа";

            openMainPage();
            typeIn(queryText);
            waitForResults();
            assertResult();

        }

        private void waitForResults() {
            By resultsStatsElement = By.xpath("//*[@id=\"b_tween\"]/span[1]");
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(resultsStatsElement));
        }

        //TODO: add more meaningful assertion
        private void assertResult(){
            WebElement getResult = driver.findElement(By.xpath("//*[@id=\"b_tween\"]/span[1]"));

            Assert.assertEquals(getResult.isDisplayed(), true);

        }


        private void typeIn(String typeInText) {
            WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
            searchInput.sendKeys(typeInText);
            searchInput.submit();

        }


        private void openMainPage() {
            String url = "https://bing.com";
            driver.get(url);
        }

}

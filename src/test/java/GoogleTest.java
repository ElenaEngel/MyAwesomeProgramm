import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class GoogleTest {
    WebDriver driver;
    @Test

    public void test001(){
        System.setProperty("webdriver.gecko.driver", "/home/elena/IdeaProjects/MyAwesomeProgramm/src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();

       openPage();
      typeIn();
      assertResult();

    }

    private void assertResult() {


    }

    private void openPage() {

        String url = "https://google.com";

        driver.get(url);}

    private void typeIn() {
        WebElement searchInput = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
        searchInput.sendKeys("portnov computer school");
        searchInput.submit();

    }








}


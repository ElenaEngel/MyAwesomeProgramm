import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "/home/elena/IdeaProjects/MyAwesomeProgramm/src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
    }


    @Test
    public void test001() {
        openCheckBoxesPage();

        List<WebElement> listOfInputs = driver.findElements(By.tagName("input"));

        int listSize = listOfInputs.size();

        WebElement checkBox1 = listOfInputs.get(0);
        WebElement checkBox2 = listOfInputs.get(1);

        Boolean attributeValue1 = checkBox1.isSelected();
        Boolean attributeValue2 = checkBox2.isSelected();

        Assert.assertFalse(attributeValue1);
        Assert.assertTrue(attributeValue2);

       checkBox1.click();

       attributeValue1 = checkBox1.isSelected();
       Assert.assertTrue(attributeValue1);

       checkBox1.click();
       checkBox2.click();
       Assert.assertNull(checkBox1.getAttribute("checked"));
       Assert.assertNull(checkBox2.getAttribute("checked"));


        //String expectedAttributeValue = "true";
       // Assert.assertEquals(expectedAttributeValue, attributeValue1);
    }

    private void openCheckBoxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }


    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

}
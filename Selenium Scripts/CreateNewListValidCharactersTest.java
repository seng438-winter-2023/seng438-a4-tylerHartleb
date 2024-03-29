// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class CreateNewListValidCharactersTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void createNewListValidCharacters() {
    driver.get("https://www.amazon.ca/");
    driver.manage().window().setSize(new Dimension(974, 1080));
    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    driver.findElement(By.linkText("Lists")).click();
    driver.findElement(By.cssSelector(".a-button-input")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".a-button-input"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("list-name")).click();
    driver.findElement(By.id("list-name")).sendKeys("My List");
    driver.findElement(By.id("create-list-form")).click();
    driver.findElement(By.xpath("(//input[@type=\'submit\'])[4]")).click();
    {
      WebElement element = driver.findElement(By.id("nav-link-accountList"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    assertThat(driver.findElement(By.id("profile-list-name")).getText(), is("My List"));
    {
      WebElement element = driver.findElement(By.xpath("//span[2]/a/div/span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.id("editYourList")).click();
    driver.findElement(By.xpath("(//input[@type=\'submit\'])[9]")).click();
    driver.findElement(By.xpath("//input[@name=\'submit.save\']")).click();
  }
}

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
public class SearchvalidTest {
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
  public void searchvalid() {
    // Test name: Search-valid
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://www.amazon.ca/s?k=eraser&crid=2V1R9O4Q1VBZG&sprefix=eraser%2Caps%2C170&ref=nb_sb_noss_1/");
    // 2 | setWindowSize | 906x816 | 
    driver.manage().window().setSize(new Dimension(906, 816));
    // 3 | type | id=twotabsearchtextbox | eraser
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("eraser");
    // 4 | click | id=nav-search-submit-button | 
    driver.findElement(By.id("nav-search-submit-button")).click();
    // 5 | verifyElementPresent | css=.a-carousel-card:nth-child(1) .a-row > .a-size-base-plus | "eraser"
    // Verify "eraser" was searched
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".a-carousel-card:nth-child(1) .a-row > .a-size-base-plus"));
      assert(elements.size() > 0);
    }
    // 6 | close |  | 
    driver.close();
  }
}

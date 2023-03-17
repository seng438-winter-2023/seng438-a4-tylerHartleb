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
public class AddShippingAddressInternationalTest {
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
  public void addShippingAddressInternational() {
    driver.get("https://www.amazon.ca/");
    driver.manage().window().setSize(new Dimension(974, 1087));
    {
      WebElement element = driver.findElement(By.id("icp-nav-flyout"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.id("nav-link-accountList"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList > .nav-line-2"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
    driver.findElement(By.cssSelector(".ya-card-row:nth-child(3) > .ya-card-cell:nth-child(1) .a-color-secondary")).click();
    driver.findElement(By.cssSelector(".a-box-inner")).click();
    driver.findElement(By.cssSelector("#address-ui-widgets-countryCode .a-button-text")).click();
    js.executeScript("window.scrollTo(0,699)");
    driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_223")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("John Doe");
    driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("111-111-1111");
    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Amphitheatre Pkwy");
    driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("1600");
    driver.findElement(By.id("address-ui-widgets-enterAddressCity")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Mountain View");
    driver.findElement(By.cssSelector("#address-ui-widgets-enterAddressStateOrRegion .a-button-text")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_5")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).click();
    driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("94043");
    driver.findElement(By.cssSelector(".a-button-input")).click();
    assertThat(driver.findElement(By.id("address-ui-widgets-FullName")).getText(), is("John Doe"));
    assertThat(driver.findElement(By.id("address-ui-widgets-AddressLineOne")).getText(), is("1600 AMPHITHEATRE PKWY"));
    assertThat(driver.findElement(By.id("address-ui-widgets-CityStatePostalCode")).getText(), is("MOUNTAIN VIEW, CA 94043-1351"));
    assertThat(driver.findElement(By.id("address-ui-widgets-Country")).getText(), is("United States"));
    assertThat(driver.findElement(By.id("address-ui-widgets-PhoneNumber")).getText(), is("Phone number: ‪111-111-1111‬"));
    driver.findElement(By.id("ya-myab-address-delete-btn-0")).click();
    driver.findElement(By.cssSelector(".a-button-input")).click();
  }
}

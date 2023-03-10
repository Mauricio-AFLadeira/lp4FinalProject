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
public class PostCompraTest {
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
  public void postCompra() {
    driver.get("http://127.0.0.1:5500/views/Compra/compraPost.html");
    driver.manage().window().setSize(new Dimension(1440, 774));
    driver.findElement(By.name("idFornecedor")).click();
    driver.findElement(By.name("idFornecedor")).sendKeys("1");
    driver.findElement(By.name("dataDaCompra")).click();
    driver.findElement(By.name("dataDaCompra")).sendKeys("0002-07-16");
    driver.findElement(By.name("dataDaCompra")).sendKeys("0020-07-16");
    driver.findElement(By.name("dataDaCompra")).sendKeys("0202-07-16");
    driver.findElement(By.name("dataDaCompra")).sendKeys("2022-07-16");
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.cssSelector(".box")).click();
    assertThat(driver.findElement(By.cssSelector("p")).getText(), is("COMPRA CADASTRADA!"));
  }
}

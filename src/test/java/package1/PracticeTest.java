package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTest {

	@Test
	public void testMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");

		/*
		 * driver.findElement(By.linkText("Sign in")).click();
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("window.scrollBy(0,500)");
		 * 
		 * driver.findElement(By.id("email_create")).sendKeys("abcddeeff@gmai.com");
		 * driver.findElement(By.id("SubmitCreate")).click();
		 */

		Actions a = new Actions(driver);

		WebElement women = driver.findElement(By.cssSelector("a[title = 'Women']"));

		WebElement tshirts = driver.findElement(By.cssSelector("a[title = 'T-shirts']"));

		a.moveToElement(women).moveToElement(tshirts).click().perform();

		Thread.sleep(2000);

		// Get Product Name
		// String
		// ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
		// System.out.println(ProductName);

		String productName = driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).getText();

		System.out.println(productName);

		driver.findElement(By.name("search_query")).sendKeys(productName);

		driver.findElement(By.name("submit_search")).click();

		String productName1 = driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).getText();
		Assert.assertEquals(productName, productName1);

	}

}

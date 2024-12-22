package test.InputValidation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	WebDriver driver;

	@BeforeTest
	public void before() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://testpages.eviltester.com/styled/validation/input-validation.html");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	@Test
	public void test() throws InterruptedException{
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		firstName.sendKeys("Vishnu");
		Thread.sleep(2000);
		
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"surname\"]"));
		lastName.sendKeys("Jangid");
		Thread.sleep(2000);
		
		WebElement age = driver.findElement(By.xpath("//*[@id=\"age\"]"));	
		age.sendKeys("24");
		Thread.sleep(2000);
		
		WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));	
		country.sendKeys("India");
		Thread.sleep(2000);
		
		WebElement notes = driver.findElement(By.xpath("//*[@id=\"notes\"]"));
		notes.sendKeys("Hello");
		Thread.sleep(2000);
		
		WebElement submit = driver.findElement(By.xpath("/html/body/div/div[3]/form/input[4]"));	
		submit.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement validationReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/form/label[4]")));
	    System.out.println(validationReport.getText());

	}
	
	
	@AfterTest
	public void after() throws InterruptedException{
		driver.quit();
		Thread.sleep(2000);
	}

}

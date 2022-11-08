package selenium_casestudy1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task_Selenium {

		public String orangehrmurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver;
		@BeforeTest
		public void newadministration() throws InterruptedException 
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			driver.get(orangehrmurl);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		@Test
		public void TestCase2() throws InterruptedException {
			
		   driver.findElement(By.name("username")).sendKeys("Admin");
		   driver.findElement(By.name("password")).sendKeys("admin123");
		   driver.findElement(By.xpath("//*[@type='submit']")).click();
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]/a")).click();
		   Thread.sleep(5000);
		   List<WebElement> li=driver.findElements(By.xpath("//*[@class='oxd-table-card']"));
		   System.out.println(li.size());
		   driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(13).click();
		   System.out.println("User Name:"+driver.findElement(By.xpath("//*[@class='oxd-table-card'][6]//div[2]/div")).getText());
			driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(13).click();
			driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
			Thread.sleep(3000);		
	}
		@AfterTest 
		public void TestCase3() throws InterruptedException {
			driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
			driver.close();
			}
	}


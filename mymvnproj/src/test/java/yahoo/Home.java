package yahoo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Home 
{

	WebDriver driver;
	
	{                                               
		 System.setProperty("atu.reporter.config", "C:\\Aravinda\\Projects\\Test\\atu.properties");
		 System.out.println("hello");
	}

       
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.mail.yahoo.com");
		
	}
	
	public void validate_links()
	{  
		open();
	    String arr[]={"About Mail","Features","Get the App","Help"};
	    WebElement w=driver.findElement(By.xpath("ul[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px))']"));
	    List<WebElement> lst=w.findElements(By.xpath("li/a/b"));
	    
	    for(int i=1;i<arr.length;i++)
	    {
	    	if(arr[i].matches(lst.get(i).getText()))
			{
				ATUReports.add("Link is matching",LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			else
			{
				ATUReports.add("Link is not matching",LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
	              
	    }
	    
	} 
	  public void login() throws Exception
	  {    open();
	  
		  driver.findElement(By.name("username")).sendKeys("minniepandu");
		  driver.findElement(By.name("passwd")).sendKeys("m5p16@t");
		  driver.findElement(By.name("signin")).click();
		  Thread.sleep(5000);
		  
	  }
	  public void createacc() throws Exception
	  {
		  open();
		  Thread.sleep(5000);
		  driver.findElement(By.id("login-signup")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.name("firstname")).sendKeys("abcd");
		  driver.findElement(By.name("secondname")).sendKeys("12345?");
		  driver.findElement(By.xpath("//span[@class='country-code-arrow']")).click();
		  driver.findElement(By.xpath("//a[@data-code='44']")).click();
		  new Select(driver.findElement(By.id("month"))).selectByVisibleText("February");
		  new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
		  new Select(driver.findElement(By.id("year"))).selectByVisibleText("1983");
		  new Actions(driver).moveToElement(driver.findElement(By.id("female"))).click().perform();
		  
		  
	  }
	  
	    
	
	
	}	


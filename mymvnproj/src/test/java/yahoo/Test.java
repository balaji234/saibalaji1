package yahoo;

import org.openqa.selenium.WebDriver;

public class Test {
	
	
	WebDriver driver;
	public Test(WebDriver driver)
	{
		this.driver=driver;
		
		
	}

	public void open()
	{
		driver.manage().window().maximize();
		driver.get("http://www.mail.yahoo.com");
		
	}
	
	
}

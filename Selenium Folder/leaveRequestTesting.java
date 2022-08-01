import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class leaveRequestTesting {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Login
		driver.get("http://34.211.139.60:8081/FYP-HR/login.jsp");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("20011105@myrp.edu.sg");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("signin")).click();
		driver.get("http://34.211.139.60:8081/FYP-HR/leave.jsp");

		// Submitting Leave Request
		Select dropdown = new Select(driver.findElement(By.id("leavetype")));
		dropdown.selectByVisibleText("Casual leave");
		driver.findElement(By.xpath("//*[contains(@id,'startdate')]")).sendKeys("01112022");
		driver.findElement(By.xpath("//*[contains(@id,'enddate')]")).sendKeys("29112022");
		driver.findElement(By.xpath("//*[contains(@id,'signup')]")).click();
		driver.get("http://34.211.139.60:8081/FYP-HR/Approval");
		if (driver.findElement(By.xpath("//td[contains(text(),\"2022-11-01\")]")).getText().equalsIgnoreCase("2022-11-01") && driver.findElement(By.xpath("//td[contains(text(),\"2022-11-29\")]")).getText().equalsIgnoreCase("2022-11-29"))
			System.out.println("Leave Request has been made");
		else
			System.out.println("Leave Request Error");
			
		
		
		
	}

}

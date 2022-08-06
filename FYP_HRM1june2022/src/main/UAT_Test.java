import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UAT_Test {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://34.211.139.60:8081/FYP-HR/login.jsp");
		driver.manage().window().maximize();
		/* User acceptance tests*/
		// Check 1
		driver.findElement(By.id("username")).sendKeys("20011105@myrp.edu.sg");
		driver.findElement(By.id("password")).sendKeys("12");
		driver.findElement(By.id("signin")).click();
		driver.get("http://34.211.139.60:8081/FYP-HR/MyLeaveRequests");
		if (driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")) 
			System.out.println("Invalid User has been detected (Check 1 (Success))");
		else
			System.out.println("Valid user has been detected. (Check 1 (Failed))");
		// Check 2
		driver.get("http://34.211.139.60:8081/FYP-HR/login.jsp");
		driver.findElement(By.id("username")).sendKeys("20011105");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("signin")).click();
		driver.get("http://34.211.139.60:8081/FYP-HR/MyLeaveRequests");
		if (driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")) 
			System.out.println("Invalid User has been detected (Check 2 (Success))");
		else
			System.out.println("Valid user has been detected. (Check 2 (Failed))");
		//Check 3
		driver.get("http://34.211.139.60:8081/FYP-HR/login.jsp");
		driver.findElement(By.id("username")).sendKeys("20011105@myrp.edu.sg");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("signin")).click();
		driver.get("http://34.211.139.60:8081/FYP-HR/MyLeaveRequests");
		if (driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")) 
			System.out.println("Invalid User has been detected (Check 3 (Failed))");
		else
			System.out.println("Valid user has been detected. (Check 3 (Success))");
		driver.close();
		
	}
}

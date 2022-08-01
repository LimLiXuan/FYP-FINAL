import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ViewPageTesting {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Login
		driver.get("http://34.211.139.60:8081/FYP-HR/login.jsp");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("20011105@myrp.edu.sg");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("signin")).click();
		/*Home page testing*/
		// Testing Leave Request List Web page
		driver.get("http://34.211.139.60:8081/FYP-HR/index.jsp");
		driver.findElement(By.xpath("//*[contains(@href,'MyLeaveRequests')]")).click();
		if ((driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/MyLeaveRequests")) && (!driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")))
			System.out.println("Leave request list webpage is working");
		else
			System.out.println("Leave request list webpage is not working");
		// Testing Leave Approval Web page
		driver.get("http://34.211.139.60:8081/FYP-HR/index.jsp");
		driver.findElement(By.xpath("//*[contains(@href,'Approval')]")).click();
		if ((driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/Approval")) && (!driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")))
			System.out.println("Approval webpage is working");
		else
			System.out.println("Approval webpage is not working");
		// Testing Logout Button
		driver.get("http://34.211.139.60:8081/FYP-HR/index.jsp");
		driver.findElement(By.xpath("//*[contains(@href,'Logout')]")).click();
		if ((driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/logout")) && (!driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")))
			System.out.println("Logout button works.");
		else
			System.out.println("Logout button does not work");
		// Testing whether Request Leave Page is accessible.
		//via direct link
		driver.get("http://34.211.139.60:8081/FYP-HR/leave.jsp");
		if (!driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error"))
			System.out.println("Request Leave Page is accessible via direct link");
		else
			System.out.println("Request Leave Page is inaccessible via direct link");
		//via Leave Request List Page
		driver.get("http://34.211.139.60:8081/FYP-HR/MyLeaveRequests");
		driver.findElement(By.xpath("//*[contains(@href,'leave.jsp')]")).click();
		if ((driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/leave.jsp")) && (!driver.getTitle().equalsIgnoreCase("HTTP Status 500 – Internal Server Error")))
			System.out.println("Request Leave Page is accessible via Leave Request List Page");
		else
			System.out.println("Request Leave Page is inaccessible via Leave Request List Page");
		driver.close();
		
	}
}

package User_Acceptance_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homePageTesting {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\OneDrive\\Desktop\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://34.211.139.60:8081/FYP-HR/login.jsp");
		driver.manage().window().maximize();
		/* User acceptance tests*/
		driver.findElement(By.id("username")).sendKeys("20011105@myrp.edu.sg");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("signin")).click();
		/*Home page testing*/
		driver.findElement(By.xpath("//*[contains(@href,'MyLeaveRequests')]")).click();
		if (driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/MyLeaveRequests"))
			System.out.println("Leave request list webpage is working");
		else
			System.out.println("Leave request list webpage is not working");
		
		driver.get("http://34.211.139.60:8081/FYP-HR/index.jsp");
		driver.findElement(By.xpath("//*[contains(@href,'Approval')]")).click();
		if (driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/Approval"))
			System.out.println("Approval webpage is working");
		else
			System.out.println("Approval webpage is not working");
		
		driver.get("http://34.211.139.60:8081/FYP-HR/index.jsp");
		driver.findElement(By.xpath("//*[contains(@href,'Logout')]")).click();
		if (driver.getCurrentUrl().equalsIgnoreCase("http://34.211.139.60:8081/FYP-HR/logout"))
			System.out.println("Logout button works.");
		else
			System.out.println("Logout button does not work");

		Thread.sleep(100000);
		driver.close();
		
	}
}

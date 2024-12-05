package test.java.demo;
//import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		
		//windows - window handles names
		//parentId , childId - tabs names
		//





		System.setProperty("webdriver.chrome.driver", "/Users/peterklejment/Documents/Dev_Stuff/chromedriver/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");

		driver.findElement(By.xpath("//*[@id=\"post-2632\"]/div[2]/div/div/div[1]/a")).click();

		
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Window Handles: " + windows);//[parentid,childid,subchildId]

		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		System.out.println("Parent Window Handle: " + parentId);
		String childId = it.next();
		System.out.println("Parent Window Handle: " + childId);

		driver.switchTo().window(childId);
		

		
		//System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		driver.findElement(By.xpath("//*[@id=\"iFrame\"]")).click();
		
		Set<String> windows1 = driver.getWindowHandles();
		System.out.println("Window Handles: " + windows1);//[parentid,childid,subchildId]
		
		Iterator<String>it1 = windows1.iterator();
		String parentId1 = it1.next();
		System.out.println("Parent Window Handle: " + parentId1);
		String childId1 = it1.next();
		System.out.println("Parent Window Handle: " + childId1);
		
		driver.switchTo().window(childId1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement iframeElement = driver.findElement(By.cssSelector("iframe.lazyloaded"));
		driver.switchTo().frame(iframeElement);
		
		driver.findElement(By.xpath("//*[@id=\"s\"]")).sendKeys("paczek");
		
		

		
		
		
//		String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
//
//		driver.switchTo().window(parentId);
//
//		driver.findElement(By.id("username")).sendKeys(emailId);






	}

}

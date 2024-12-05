package test.java.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PrintAllLinks {
    public static void main(String[] args) {
       
        System.setProperty("webdriver.chrome.driver", "/Users/peterklejment/Documents/Dev_Stuff/chromedriver/chromedriver");

      
        WebDriver driver = new ChromeDriver();

        try {
            
            driver.get("https://opensource-demo.orangehrmlive.com/"); 
            Thread.sleep(10000);

            // find all elements with <a> on site
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));

            // print all links
            System.out.println("Lista wszystkich linków na stronie:");
            for (WebElement link : allLinks) {
                System.out.println(link.getText() + " -> " + link.getAttribute("href"));
            }
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            
            driver.quit();
        }
    }
}

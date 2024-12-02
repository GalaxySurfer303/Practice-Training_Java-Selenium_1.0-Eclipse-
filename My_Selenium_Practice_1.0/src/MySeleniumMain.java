import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySeleniumMain {

    public static void main(String[] args) {
    	
	// TODO Auto-generated method stub
		
		
		//Invoking Browser
		//Chrome - ChromeDrivber -> Methods
		//Safari
		//Firefox
		//WebDriver close get
		
		//WebDriver
		//Chromedriver.exe - macOS chromedrive ->chromebrowser
    	
        // Ustawienie ścieżki do WebDrivera
        System.setProperty("webdriver.chrome.driver", "/Users/peterklejment/Documents/Dev_Stuff/chromedriver/chromedriver");
        
        // Inicjalizacja WebDrivera
        WebDriver driver = new ChromeDriver();
        
        try {
            // Otwieranie strony
            driver.get("https://www.saucedemo.com");
            Thread.sleep(2000);
            
            // user_name - "standard_user"
    		// password  - "secret_sauce"
            
            
            
            String mainPageTitle = driver.getTitle();
            System.out.println("Main Page Title is: " + mainPageTitle);
            System.out.println("Actual URL is: " + driver.getCurrentUrl());
            Thread.sleep(2000);

            // Logowanie przez klasę wewnętrzną
            MySeleniumMain mainClass = new MySeleniumMain();
            UserLogin login = mainClass.new UserLogin(driver);
            login.performLogin("standard_user", "secret_sauce");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Zamknięcie przeglądarki
            driver.quit();
        }
    }

    // Klasa wewnętrzna do obsługi logowania
    private class UserLogin {
        private WebDriver driver;

        public UserLogin(WebDriver driver) {
            this.driver = driver;
        }

        public void performLogin(String username, String password) {
            try {
                // Logowanie użytkownika
                driver.findElement(By.id("user-name")).sendKeys(username);
                Thread.sleep(2000);
                driver.findElement(By.id("password")).sendKeys(password);
                Thread.sleep(2000);
                driver.findElement(By.id("login-button")).click();
                Thread.sleep(2000);
                System.out.println("Logged in as: " + username);
                Thread.sleep(5000);
            } catch (Exception e) {
                System.err.println("Error during login: " + e.getMessage());
            }
        }
    }
}
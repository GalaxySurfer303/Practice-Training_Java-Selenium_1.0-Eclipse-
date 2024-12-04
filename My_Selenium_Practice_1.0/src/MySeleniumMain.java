import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class MySeleniumMain {

    public static void main(String[] args) {
        // Ustawienie ścieżki do WebDrivera
        System.setProperty("webdriver.chrome.driver", "/Users/peterklejment/Documents/Dev_Stuff/chromedriver/chromedriver");

        // Inicjalizacja WebDrivera
        WebDriver driver = new ChromeDriver();

        try {
            // Otwieranie strony
            driver.get("https://www.saucedemo.com");
            Thread.sleep(2000);

            String mainPageTitle = driver.getTitle();
            System.out.println("Main Page Title is: " + mainPageTitle);
            System.out.println("Actual URL is: " + driver.getCurrentUrl());
            Thread.sleep(2000);

            // Logowanie przez klasę wewnętrzną
            MySeleniumMain mainClass = new MySeleniumMain();
            UserLogin login = mainClass.new UserLogin(driver);
            login.performLogin("standard_user", "secret_sauce");

            UserMenu user_menu = mainClass.new UserMenu(driver);
            user_menu.menuOperations();
            user_menu.backToShop();
            user_menu.addSomeStuff();

            UserBasket user_basket = mainClass.new UserBasket(driver);
            user_basket.basketOperations();

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

    private class UserMenu {
        private WebDriver driver;

        public UserMenu(WebDriver driver) {
            this.driver = driver;
        }

        public void menuOperations() {
            try {
                driver.findElement(By.id("react-burger-menu-btn")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("about_sidebar_link")).click();
            } catch (Exception e1) {
                System.err.println("Error during navigating main menu " + e1.getMessage());
            }
        }

        public void backToShop() {
            try {
                driver.navigate().back();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));

                System.out.println("Strona inventory.html została załadowana!");
            } catch (Exception e2) {
                System.err.println("Error during back to shop page from 'About' page " + e2.getMessage());
            }
        }

        public void addSomeStuff() {
            try {
                WebElement filterNamePrice = driver.findElement(By.className("product_sort_container"));
                Select filter_dropdown = new Select(filterNamePrice);
                filter_dropdown.selectByValue("hilo");

                driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
                Thread.sleep(5000);
            } catch (Exception e2) {
                System.err.println("Error during filtering Name/Price " + e2.getMessage());
            }
        }
    }

    private class UserBasket {
        private WebDriver driver;

        public UserBasket(WebDriver driver) {
            this.driver = driver;
        }

        public void basketOperations() {
            try {
                driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/a[1]")).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
                
                Thread.sleep(10000);
                

                System.out.println("Strona cart.html została załadowana!");
            } catch (Exception e3) {
                System.err.println("Error during navigating to user 'cart' page " + e3.getMessage());
            }
        }
    }
}
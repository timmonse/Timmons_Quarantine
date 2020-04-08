package DinosuarGame;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

public class ChromeBrowser {

    public static void main(String args[]) throws InterruptedException {
        GoogleSearch();
    }

    public static void GoogleSearch() throws InterruptedException {

        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "src/DinosuarGame/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        //Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        driver.get("https://chromedino.com/");
//        searchBox.submit();
//        Thread.sleep(5000);  // Let the user actually see something!
        WebElement mainContent = driver.findElement(By.tagName("body"));

        while(true){
            mainContent.sendKeys(Keys.SPACE);
            Thread.sleep(100);
        }

        //driver.quit();
    }
}

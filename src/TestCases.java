package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("calculator");
		Thread.sleep(2000);
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='wM6W7d']"));
		for(WebElement ls:searchResult) {
			String text = ls.getText();
			if(text.equals("calculator")) {
				ls.click();
			}
			break;
		}
        String cUrl = driver.getCurrentUrl();
        if(cUrl.contains("calculator")){
            System.out.println("correct url");
        }else{
            System.out.println("incoorect url");
        }

        String intiaload = driver.findElement(By.id("cwos")).getText();
        if (intiaload.contains("0")) {
            System.out.println("correct intial load");
        } else {
            System.out.println("incorrect intial load");
        }

        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        
        driver.findElement(By.xpath("//div[text()='5']")).click();
        driver.findElement(By.xpath("//div[text()='+']")).click();
        driver.findElement(By.xpath("//div[text()='7']")).click();
        driver.findElement(By.xpath("//div[text()='=']")).click();
        Thread.sleep(3000);
        String addition= driver.findElement(By.id("cwos")).getText();
        if (addition.contains("12")) {
            System.out.println("correct answer");
        } else {
            System.out.println("incorrect answer");
        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[text()='1']")).click();
        driver.findElement(By.xpath("//div[text()='5']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@aria-label='minus']")).click();
        driver.findElement(By.xpath("//div[text()='8']")).click();
        driver.findElement(By.xpath("//div[text()='=']")).click();
        Thread.sleep(3000);
        String substraction = driver.findElement(By.id("cwos")).getText();
        if (substraction.contains("7")) {
            System.out.println("correct answer");
        } else {
            System.out.println("incorrect answer");
        }

        System.out.println("end Test case: testCase02");
    }

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        
        driver.findElement(By.xpath("//div[text()='1']")).click();
        driver.findElement(By.xpath("//div[text()='0']")).click();
        driver.findElement(By.xpath("//div[@aria-label='multiply']")).click();
        driver.findElement(By.xpath("//div[text()='3']")).click();
        driver.findElement(By.xpath("//div[text()='=']")).click();
        Thread.sleep(3000);
        String addition= driver.findElement(By.id("cwos")).getText();
        if (addition.contains("30")) {
            System.out.println("correct answer");
        } else {
            System.out.println("incorrect answer");
        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[text()='AC']")).click();
        
        Thread.sleep(3000);
        String substraction = driver.findElement(By.id("cwos")).getText();
        if (substraction.contains("0")) {
            System.out.println("All Clear");
        } else {
            System.out.println("NOT All Clear");
        }

        System.out.println("end Test case: testCase03");
    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        
        driver.findElement(By.xpath("//div[text()='2']")).click();
        driver.findElement(By.xpath("//div[text()='0']")).click();
        driver.findElement(By.xpath("//div[@aria-label='divide']")).click();
        driver.findElement(By.xpath("//div[text()='4']")).click();
        driver.findElement(By.xpath("//div[text()='=']")).click();
        Thread.sleep(3000);
        String addition= driver.findElement(By.id("cwos")).getText();
        if (addition.contains("5")) {
            System.out.println("correct answer");
        } else {
            System.out.println("incorrect answer");
        }
        

        System.out.println("end Test case: testCase04");
    }

}

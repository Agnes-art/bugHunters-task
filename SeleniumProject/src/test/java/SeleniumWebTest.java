import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebTest {
    private WebDriver driver;
@BeforeTest
    public void setUp() throws InterruptedException {
    //locate where the chrome driver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    //1. open your chrome driver
    driver = new ChromeDriver();
    //2. Input your webpage url
    driver.get("https://selenium-blog.herokuapp.com/");
    // Test1. verify user is on the right page
    if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
        //pass
        System.out.println("Correct webpage");
    else
        //Fail
            System.out.println("wrong webpage");
    //wait for full page loading
    Thread.sleep(5000);
    //3.Maximise the window
    driver.manage().window().maximize();
    Thread.sleep(5000);
}
@Test (priority = 0)
        public void positiveSignUp() throws InterruptedException {
    //Test2. Verify when user clicks on signup, user is directed to signup page
    //4.Click on signup button to open the page
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    Thread.sleep(5000);
    String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrl))
        //pass
        System.out.println("Pass");
    else
        //Fail
        System.out.println("Fail");
}


    @Test (priority = 1)
    public void positiveScenarioForUsername() throws InterruptedException {
        //5.Input username
        //Test 3 verify user cannot signup with invalid email
        driver.findElement(By.id("user_username")).sendKeys("azzio0043");
        //6. Input email
        driver.findElement(By.id("user_email")).sendKeys("onyejegodwin+88@gmail.com");
//7. Input password
        driver.findElement(By.id("user_password")).sendKeys("Password@443");
        //8. Click on signup
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }
@Test (priority = 2)
        public void clickUser1Item() {
    //9.click the first element
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
}
@Test (priority = 3)
        public void verifyItem() throws InterruptedException {
//10.search for an item on the list
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
    String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
    String actualPageUrl = driver.getTitle();
    if (actualPageUrl.contains(expectedPageUrl))
        //pass
        System.out.println("Correct user1 page ");
    else
        //Fail
        System.out.println("wrong user1 page");
    Thread.sleep(5000);
}
    @Test (priority = 4)
            public void logOut() {
    //11.click on logout
    driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //pass
            System.out.println("Correct page ");
        else
            //Fail
            System.out.println("wrong page");
}
@Test (priority = 5)
public void negativeScenarioForUsername() throws InterruptedException {
    //5.Input username
    //Test 3 verify user cannot signup with invalid email
    driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("user_username")).sendKeys("ag");
    //6. Input email
    driver.findElement(By.id("user_email")).sendKeys("onyejegodwin+77@gmail.com");
//7. Input password
    driver.findElement(By.id("user_password")).sendKeys("Password@423");
    //8. Click on signup
    driver.findElement(By.id("submit")).click();
    Thread.sleep(5000);

}
    @AfterTest
        public void closeBrowser() {
    //12.Quit the browser
    driver.quit();
}
}








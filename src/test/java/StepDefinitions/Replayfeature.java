package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Replayfeature {
    WebDriver driver = null;

    @Given("Open the website")
    public void open_the_website() {
        String projectPath= System.getProperty("user.dir");
        System.out.println("Project path is:" +projectPath);
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - browser is open");
        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://adoring-pasteur-3ae17d.netlify.app/index.html");
    }

    @When("Scroll down till new arrival section")
    public void scroll_down_till_new_arrival_section() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement Element = driver.findElement(By.cssSelector("body > div.new_arrivals_agile_w3ls_info > div"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

    }

    @When("Click on the button quick review")
    public void click_on_the_button_quick_review() throws InterruptedException {
        driver.findElement(By.cssSelector("#horizontalTab > div > div.tab1.resp-tab-content.resp-tab-content-active > div:nth-child(2) > div > div.men-thumb-item > img.pro-image-front")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#horizontalTab > div > div.tab1.resp-tab-content.resp-tab-content-active > div:nth-child(2) > div > div.men-thumb-item > div > div > a")).click();
    }

    @When("Scroll down till the description section")
    public void scroll_down_till_the_description_section() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement Element1 = driver.findElement(By.cssSelector("#horizontalTab > ul > li.resp-tab-item.resp-tab-active"));
        jse.executeScript("arguments[0].scrollIntoView();", Element1);
    }

    @When("Click on review")
    public void click_on_review() throws InterruptedException {
       driver.findElement(By.cssSelector("#horizontalTab > ul > li:nth-child(2)")).click();
       Thread.sleep(2000);
    }

    @Then("Click on button replay")
    public void click_on_button_replay() throws InterruptedException {

        driver.findElement(By.cssSelector("#horizontalTab > div > div.tab2.resp-tab-content.resp-tab-content-active > div > div > div.bootstrap-tab-text-grid > div.bootstrap-tab-text-grid-right > ul > li:nth-child(2) > a")).click();
        Thread.sleep(1500);

    }
}

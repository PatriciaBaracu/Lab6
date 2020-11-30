package StepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FlicrPostsfeature {
    WebDriver driver = null;
    @Given("Open website")
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

    @When("scroll down till the footer")
    public void scroll_down_till_the_footer() {
        // Write code here that turns the phrase above into concrete actions

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("click on flicr post")
    public void click_on_flicr_post() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("body > div.footer > div > div.col-md-9.footer-right > div > div.col-md-3.sign-gd.flickr-post > ul > li:nth-child(1) > a > img")).click();
        Thread.sleep(2000);
        driver.close();
    }


}
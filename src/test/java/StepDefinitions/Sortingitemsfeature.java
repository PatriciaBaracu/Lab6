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

public class Sortingitemsfeature {
    WebDriver driver = null;
    @Given("Open web page")
    public void open_web_page() {
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

    @When("Click on the button men's wear")
    public void click_on_the_button_men_s_wear() {
        driver.findElement(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li:nth-child(4) > a")).click();
    }

    @When("Click on the button clothes")
    public void click_on_the_button_clothes() {
        driver.findElement(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li.dropdown.menu__item.open > ul > div > div:nth-child(1) > ul > li > a")).click();

    }

    @Then("Click on sort criterias and check if its fits")
    public void click_on_sort_criterias_and_check_if_its_fits() throws InterruptedException {

        driver.findElement(By.cssSelector("#country1")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#country1 > option:nth-child(2)")).click();
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement Element = driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.single-pro"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(1500);
        WebElement Element1 = driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.col-md-8.products-right > div > div.sorting > div"));
        js.executeScript("arguments[0].scrollIntoView();", Element1);
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#country1 > option:nth-child(3)")).click();
        Thread.sleep(1500);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(1500);
        js.executeScript("arguments[0].scrollIntoView();", Element1);
        driver.findElement(By.cssSelector("#country1 > option:nth-child(4)")).click();
        Thread.sleep(1500);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(1500);
        js.executeScript("arguments[0].scrollIntoView();", Element1);
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#country1 > option:nth-child(5)")).click();
        Thread.sleep(1500);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(1500);
        driver.close();








    }

}

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

public class Cartitemsfeature {
    WebDriver driver = null;
    @Given("Open the web page")
    public void open_the_web_page() {
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

    @When("Click on the men's wear")
    public void click_on_the_men_s_wear() {
        driver.findElement(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li:nth-child(3) > a")).click();
    }

    @When("Click on clothes")
    public void click_on_clothes() {
   driver.findElement(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li.dropdown.menu__item.open > ul > div > div:nth-child(2) > ul > li > a")).click();
    }

    @When("Click on add items in the cart")
    public void click_on_add_items_in_the_cart() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.single-pro > div:nth-child(1) > div > div.men-thumb-item > img.pro-image-front"));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
        driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.single-pro > div:nth-child(1) > div > div.item-info-product > div.snipcart-details.top_brand_home_details.item_add.single-item.hvr-outline-out.button2 > form > fieldset > input.button")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.single-pro > div:nth-child(2) > div > div.item-info-product > div.snipcart-details.top_brand_home_details.item_add.single-item.hvr-outline-out.button2 > form > fieldset > input.button")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.single-pro > div:nth-child(3) > div > div.item-info-product > div.snipcart-details.top_brand_home_details.item_add.single-item.hvr-outline-out.button2 > form > fieldset > input.button")).click();
         Thread.sleep(1000);
         driver.findElement(By.cssSelector("body > div.banner-bootom-w3-agileits > div > div.single-pro > div:nth-child(4) > div > div.item-info-product > div.snipcart-details.top_brand_home_details.item_add.single-item.hvr-outline-out.button2 > form > fieldset > input.button")).click();
    }

    @Then("Delete last items")
    public void delete_last_items() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#PPMiniCart > form > ul > li:nth-child(3) > div.minicart-details-remove > button")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#PPMiniCart > form > ul > li:nth-child(2) > div.minicart-details-remove > button")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#PPMiniCart > form > ul > li:nth-child(2) > div.minicart-details-remove > button")).click();
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("#PPMiniCart > form > ul > li:nth-child(3) > div.minicart-details-remove > button")).click();
        Thread.sleep(2000);
        driver.close();

    }
}

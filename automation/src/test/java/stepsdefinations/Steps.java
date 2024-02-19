
package stepsdefinations;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;


public class Steps {

	WebDriver driver;

    @Given("I am on the eshop.vodafone.com.eg homepage")
    public void i_am_on_the_eshop_vodafone_homepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KareemMohamed\\eclipse-workspace\\automation\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://web.vodafone.com.eg/auth/realms/vf-realm/protocol/openid-connect/auth?client_id=eshop&redirect_uri=https%3A%2F%2Feshop.vodafone.com.eg%2Fen%2F&state=b905857e-64ad-4aa5-a0df-658d4728d690&response_mode=query&response_type=code&scope=openid&nonce=7e191f25-3fa1-4f71-85a6-c0c37aad8172&ui_locales=en");
    
    }

    @When("I login {string} and password {string}")
    public void i_login_and_password(String username,String password) 
    {
      // Find the username and password fields and enter the login credentials
    	try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submitBtn"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement reusernameField = driver.findElement(By.id("username"));
        WebElement repasswordField = driver.findElement(By.id("password"));
        WebElement reloginButton = driver.findElement(By.id("submitBtn"));
        reusernameField.sendKeys(username);
        repasswordField.sendKeys(password);
        reloginButton.click();
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement acceptcookies = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        acceptcookies.click();
//        throw new io.cucumber.java.PendingException();
    }

    @When("I select two items and add them to the cart")
    public void i_select_items_and_add_to_cart() 
    {
       // select the first item
        try {
            Thread.sleep(10000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     // Scroll down the page
        //JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement firstitem = driver.findElement(By.cssSelector("vf-product-box-featured:nth-child(1)"));
        firstitem.click();
        WebElement Addfirstitemtocart = driver.findElement(By.cssSelector("div.cart-btns > button.add-to-cart"));
        Addfirstitemtocart.click();
        
        // go to home screen again to select the second item
      
        WebElement homepage = driver.findElement(By.cssSelector("body > vf-root > main > section:nth-child(2) > vf-nav-bar > nav > div > div.logo"));
        homepage.click();
        WebElement seconditem = driver.findElement(By.cssSelector("#\\30 1HJ6A5VWGMP4S0EMDJ9VT10QJ > vf-product-box-featured:nth-child(2) > div > div.img-container > img"));
        seconditem.click();
        WebElement Addseconditemtocart = driver.findElement(By.cssSelector("body > vf-root > main > section.vf-modules-container-fluid > vf-middleware > vf-product-details-page > div.vf-grid-wrap.vf-grid-wrap-fluid.vf-grid-wrap-max > div > div > div.product-details-show-box > div.productDetails-box > div.cart-btns > button.add-to-cart"));
        Addseconditemtocart.click();
    }
    
    @When("I search for an item and add it to the cart")
    public void i_search_for_item_and_add_to_cart() 
    {
       // assumption that the item is iphone
    	WebElement searchbar = driver.findElement(By.id("searchInput"));
    	searchbar.sendKeys("i phone");
    	WebElement selectfromsearchbar = driver.findElement(By.cssSelector("body > vf-root > main > section:nth-child(2) > vf-nav-bar > nav > div > div.search-container > vf-search-engine > div.main-search-bar > div.search-results.desktop-search-results > div:nth-child(2) > div > div.category-location"));
    	selectfromsearchbar.click(); // to view all search result
    	WebElement thirditem = driver.findElement(By.cssSelector("body > vf-root > main > section.vf-modules-container-fluid > vf-product-list-page > div > div.productList-main-page.vf-grid-9 > div.product-cards.vf-grid-wrap.vf-grid-wrap-start > vf-product-box-featured:nth-child(1) > div > div.text-container > div > div.product-display-name"));
    	thirditem.click();
    	WebElement Addthirditemtocart = driver.findElement(By.cssSelector("body > vf-root > main > section.vf-modules-container-fluid > vf-middleware > vf-product-details-page > div.vf-grid-wrap.vf-grid-wrap-fluid.vf-grid-wrap-max > div > div > div.product-details-show-box > div.productDetails-box > div.cart-btns > button.add-to-cart"));
    	Addthirditemtocart.click();
    }
    

    @Then("I should see three items in the cart")
    public void i_should_see_items_in_cart() 
    {
       // verify number of items in cart
    	WebElement cartbutton = driver.findElement(By.cssSelector("body > vf-root > main > section:nth-child(2) > vf-nav-bar > nav > div > div.showCart > vf-cart > div > button"));
    	cartbutton.click();
    	// Get the count of items in the cart
        int actualItemCount = driver.findElements(By.cssSelector("body > vf-root > main > section.vf-modules-container-fluid > vf-my-cart > div > div > div > div.cart.cart-summary > vf-cart-order-summary > div > div > div.order-cost > div.subtotal")).size();

        // Assert that the count of items in the cart is as expected
        assertEquals(3, actualItemCount);
    }
   @After
    public void closeBrowser() 
       {
    	try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
       }
        if (driver != null) {
            driver.quit();
        }
    }
    
    }

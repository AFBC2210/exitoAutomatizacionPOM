package StepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import exitoPage.ExitoPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class exitoStepByStep {
	
	WebDriver driver;	
	ExitoPageObject exitoPageObject;

	@Given("exito web page is open")
	public void exito_web_page_is_open() throws Exception {
		
		 
        ChromeOptions options = new ChromeOptions();
		
		HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		
		conentSettings.put("notifications",2);
		profile.put("managed_default_content_settings", conentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		//driver = new ChromeDriver ();
		driver = new ChromeDriver(options);
		exitoPageObject = new ExitoPageObject(driver);
		driver.manage().window().maximize();
        driver.get("https://www.exito.com/");
        
	    }

	@When("user clicks on the main menu")
	public void user_clicks_on_the_main_menu() throws InterruptedException {
		
        exitoPageObject.clickOnMainMenu();
        System.out.println("paso por el menu");
	    
	}

	@When("user select the category")
	public void user_select_the_category() throws InterruptedException {
		System.out.println("paso a seleccionar categoria");
		exitoPageObject.selectCategory();
		
	    
	}

	@When("user select the subcategory")
	public void user_select_the_subcategory() throws InterruptedException {
	    
		exitoPageObject.selectSubCategory();
		System.out.println("paso a seleccionar subcategoria");		
	    
	}

	@When("user add different products to shopping cart")
	public void user_add_different_products_to_shopping_cart() {
		
		System.out.println("paso a seleccionar productos");
		exitoPageObject.addProducts();		
	    
	}

	@When("user selects a quantity per product")
	public void user_selects_a_quantity_per_product() {
	    
		exitoPageObject.selectQuantity();
		System.out.println("paso a seleccionar cantidad");
	    
	}

	@When("user look at quantity on shopping car")
	public void user_look_at_quantity_on_shopping_car(String validateQuantity) {
	    
		exitoPageObject.validateQuantityProductsOnShoppingCar(validateQuantity);
		System.out.println("paso a validar cantidades en carrito");
	    
	}

	@When("user goes on shopping cart to check")
	public void user_goes_on_shopping_cart_to_check() {
	    
		exitoPageObject.checkShoppingCar();
		System.out.println("paso a carrito interfaz");
	    
	}

	@Then("user validate that products name selected to be the same on shopping cart")
	public void user_validate_that_products_name_selected_to_be_the_same_on_shopping_cart(String productName) {
	    
		
		System.out.println("paso a validar nombre de productos en carrito de compras");
	    
	}

	@Then("user validate that products total price selected to be the same on shopping cart")
	public void user_validate_that_products_total_price_selected_to_be_the_same_on_shopping_cart(String productsTotalValue) {
	    
		
		System.out.println("paso a validar valores de productos en carrito de compras");
	    
	}

	@Then("user validate that  products quantites selected to be the same on shopping cart")
	public void user_validate_that_products_quantites_selected_to_be_the_same_on_shopping_cart(String productsQuantity) {
	    
		
		System.out.println("paso a validar cantidades de productos en carrito de compras");
	   
	}

	@Then("user validate that  products number selected to be the same on shopping cart")
	public void user_validate_that_products_number_selected_to_be_the_same_on_shopping_cart(String numberSelectProducts) {
	    
		
		System.out.println("paso a validar numero de productos en carrito de compras");
	   
	}

}

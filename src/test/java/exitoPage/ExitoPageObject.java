package exitoPage;

import static org.mockito.ArgumentMatchers.doubleThat;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.lang3.ArrayUtils;
import org.htmlunit.corejs.javascript.regexp.SubString;
import org.htmlunit.javascript.host.dom.Document;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.CharMatcher;

public class ExitoPageObject {

	private WebDriver driver;
	
	
	/*Expected result: validate number products add to shopping car on interface phone */
	String 	currentQuantityProductOnShoppingCar,
			expectedQuantityProductOnShoppingCar;
	
	
	/*Description about product selected on interface phone*/
	String 	varNameProductInterfaceIphones,
			varTotalValueProductInterfaceIphone,
			varQuantityProductInterfaceIpho,
			varNumberProductInterfaceIphone;
	
	Double  varValuePerProductInterfaceIphone;
	Double	varTotalValuePerProductInterfaceIphone;
			
	
	/*Description about price product add on interface phone*/
	String 	varUnitProductAdd,varLetterUnitProductAdd,
			varConcatUnitLetterUnitOnInterfacePhone;
	
	
	/*Description about product selected on interface shopping car*/
	String 	varNameProductInterfaceShoppingCar,
			varTotalValueProductInterfaceShoppingCar,
			varQuantityProductInterfaceShoppingCar,
			varNumberProductInterfaceShoppingCar,
			varStringTotalValueProductInterfaceIphone;
	
	Double     varDoubleQuantityProductInterfaceShoppingCar;
	
	/*Description about price product add on shopping car*/
	String 	varHundred,varThousandDot,varHundredThousand,
			varMillionDot,varMillion,varCharacterSpace,varSimbolPrice,
			varConcatPriceOnInterfaceShoppingCar;
	
	
	
	/*Web Locators Interface phone on file menu->category->subCategory->buttonAdd Product */
	private By optionMenu = By
			.id("category-menu");
	
	private By mainMenu = By
			.cssSelector("div[class='exito-category-menu-3-x-containerDrawer']");
	
	private By category = By
			.xpath("//p[contains(text(),'Celulares y accesorios')]");
	
	private By subcategory = By
			.xpath("(((((//section[@class='exito-category-menu-3-x-contentSideMenu']//div//div)[3])//div)[2])//a)[5]");

	private By buttonAdd = By.xpath("((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[53])");

	private By quantitySum1 = By
			.xpath("(((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[54])/button)");

	private By quantitySum2 = By
			.xpath("((((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[54])/button)[2])");

	private By quantityTotalSelected = By
			.xpath("(((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[53])/div/div)");
	
	private By quantityProdShoppingCar = By
			.cssSelector("div[class='exito-header-3-x-minicartQuantity']");
	
	private By shoppingCart = By
			.cssSelector("a[class='exito-header-3-x-minicartLink']");
	
	
	/*Web Locators Interface Iphone on file Product add */
	private By localNameProductInterfaceIphone = By
			.xpath("(((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[17])//span)");
	
	private By localTotalValueProductInterfaceIphone = By
			.xpath("(((((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[20])/div)[2])/div/span)");
	
	private By localQuantityProductInterfaceIphone = By
			.xpath("(((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[53])/div/div)");
	
	private By localNumberProductInterfaceIphone = By
			.cssSelector("div[class='exito-header-3-x-minicartQuantity']");
	
	
	
	/*Web Locators Interface Shopping car on file unities Product add */	
	private By localQuantityUnitProductInterfaceShoppingCar = By
			.xpath("(((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[12])/span)[1])");
	private By localQuantityUnitLettersProductInterfaceShoppingCar = By
			.xpath("(((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[12])/span)[2])");
	
	
	/*Web Locators Interface shopping car on file name Product add */
	private By localNameProductInterfaceShoppingCar = By
			.xpath("((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[4])/span)");
	
	
	/*Web Locators Interface shopping car on file price Product add */
	private By localSimbolValueProductInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[2])");
	private By localSpaceCharacterProductInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[3])");
	private By localMillionProductInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[4])");
	private By localMillionDotProductInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[5])");
	private By localHundredThousandInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[6])");
	private By localThousandDotProductInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[7])");
	private By localHundredProductInterfaceShoppingCar = By
			.xpath("(((((((//div[@class='exito-checkout-io-0-x-itemCartContent'])//div/div)[5])//div)[2])//span//span)[8])");
	
	
	
	
		
	

	public ExitoPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickOnMainMenu() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Thread.sleep(5000);

		driver.findElement(optionMenu).isDisplayed();

		driver.findElement(optionMenu).click();

	}

	public void selectCategory() throws InterruptedException {

		Wait<WebDriver> waitMainMenu = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		@SuppressWarnings("unused")
		WebElement menu = waitMainMenu.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(mainMenu);
			}

		});

		Wait<WebDriver> waitCategory = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		@SuppressWarnings("unused")
		WebElement categ = waitCategory.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(category);
			}
		});

		/*
		 * espera explicita con expected conditions WebDriverWait ewait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10));
		 * ewait.until(ExpectedConditions.elementToBeSelected(category));
		 */

		// Thread.sleep(10000);

		if (driver.findElement(mainMenu).isDisplayed()) {

			driver.findElement(category).click();
		}

	}

	public void selectSubCategory() throws InterruptedException {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement subCategory =
		 * (WebElement)js.
		 * executeScript("return document.getElementById('Categorías-nivel3-Iphone')[1]"
		 * );
		 */

		driver.findElement(category).isDisplayed();

		Wait<WebDriver> waitSubCategory = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		@SuppressWarnings("unused")
		WebElement subCateg = waitSubCategory.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(subcategory);
			}
		});

		// Thread.sleep(5000);

		if (driver.findElement(subcategory).isDisplayed()){

			driver.findElement(subcategory).click();
		}

	}

	public void addProducts() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		varNameProductInterfaceIphones = driver.findElement(localNameProductInterfaceIphone).getText();
		varTotalValueProductInterfaceIphone = driver.findElement(localTotalValueProductInterfaceIphone).getText();
		
		driver.findElement(buttonAdd).click();	
			
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectQuantity() {

		driver.findElement(quantitySum1).isDisplayed();
		driver.findElement(quantitySum1).click();
		
		for (int i = 0; i < 2; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(quantitySum2).click();		
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		
			
	}

	public void validateQuantityProductsOnShoppingCar() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		
		System.out.println("validando cantidad de unidades agregados al carrito...");
		expectedQuantityProductOnShoppingCar=driver.findElement(quantityTotalSelected).getText();
		
		/*
		Wait<WebDriver> waitUnitQuantityCar = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		@SuppressWarnings("unused")
		WebElement menu = waitUnitQuantityCar.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(quantityProdShoppingCar);
			}

		});
		*/
		Thread.sleep(10000);
		
		 if (driver.findElement(quantityProdShoppingCar).isDisplayed()) {
			currentQuantityProductOnShoppingCar = driver.findElement(quantityProdShoppingCar).getText();
		}		
		
		
		Assert.assertEquals("OJo !!! comparando resultados", expectedQuantityProductOnShoppingCar,
				currentQuantityProductOnShoppingCar+".00 un");
		
		System.out.println("la prueba paso 12345 yuuupiiiii, cuando empezamos :D !!!!!!!");
		
	}

	public void checkShoppingCar() {
		System.out.println("nos vamos a la interfaz del carrito  de compras");
		driver.findElement(shoppingCart).click();
	}
	
	public void validateNameProductAddToCar() {
		
		System.out.println("validando nombre de productos add "
				+ "en interfaz iphones, en interfaz carrito de compras");
		
		varNameProductInterfaceShoppingCar=driver.findElement(localNameProductInterfaceShoppingCar).getText();
		
		Assert.assertEquals("VALIDATE PRODUCT NAME ON SHOPPING CAR INTERFACE", 
				varNameProductInterfaceIphones,varNameProductInterfaceShoppingCar);
	}
	
	public void validateTotalValueProductAddToCar() {
		System.out.println("validando el valor total de los productos add "
				+ "en interfaz iphones, en interfaz carrito de compras");
		
		varSimbolPrice 		= driver.findElement(localSimbolValueProductInterfaceShoppingCar).getText();
		varCharacterSpace 	= driver.findElement(localSpaceCharacterProductInterfaceShoppingCar).getText();
		varMillion 			= driver.findElement(localMillionProductInterfaceShoppingCar).getText();
		varMillionDot 		= driver.findElement(localMillionDotProductInterfaceShoppingCar).getText();
		varHundredThousand 	= driver.findElement(localHundredThousandInterfaceShoppingCar).getText();
		varThousandDot 		= driver.findElement(localThousandDotProductInterfaceShoppingCar).getText();
		varHundred 			= driver.findElement(localHundredProductInterfaceShoppingCar).getText();
		
		
		varConcatPriceOnInterfaceShoppingCar = varSimbolPrice+varCharacterSpace+varMillion+varMillionDot
												+varHundredThousand+varThousandDot+varHundred;
		
		varQuantityProductInterfaceShoppingCar=driver.findElement(localQuantityUnitProductInterfaceShoppingCar).getText();
		
		
				
		varDoubleQuantityProductInterfaceShoppingCar = Double.parseDouble(varQuantityProductInterfaceShoppingCar);
		
		
			
		
		char [] cadena_NumberValue = varTotalValueProductInterfaceIphone.toCharArray();
		
		String n="";
		
		for (int i = 0; i < cadena_NumberValue.length; i++) {
			if (Character.isDigit(cadena_NumberValue[i])) {
				n+=cadena_NumberValue[i];
			}
		}
		
		
		varValuePerProductInterfaceIphone = Double.parseDouble(n);
		
		varTotalValuePerProductInterfaceIphone= varValuePerProductInterfaceIphone*varDoubleQuantityProductInterfaceShoppingCar;
		
		varStringTotalValueProductInterfaceIphone = String.valueOf(varTotalValuePerProductInterfaceIphone);
		
		char [] cadena_NumberValue2 = varConcatPriceOnInterfaceShoppingCar.toCharArray();
		
		String m="";
		Double doble=1.00;
		Double strinToDouble;
		Double dobleTotal;
		
		for (int j = 0; j < cadena_NumberValue2.length; j++) {
			if (Character.isDigit(cadena_NumberValue2[j])) {
				m+=cadena_NumberValue2[j];
			}
		}
		strinToDouble = Double.parseDouble(m);
		dobleTotal = strinToDouble*doble;
		
		varConcatPriceOnInterfaceShoppingCar=String.valueOf(dobleTotal);
		
		Assert.assertEquals("VALIDATE TOTAL VALUE PRODUCT ON SHOPPING CAR INTERFACE",
				varStringTotalValueProductInterfaceIphone, varConcatPriceOnInterfaceShoppingCar);
		
		
	}
	
	public void validateQuantityProductAddToCar() {
		System.out.println("validando la cantidad de unidades de los productos add "
				+ "en interfaz iphones, en interfaz carrito de compras");
		
		varQuantityProductInterfaceShoppingCar = driver.findElement(localQuantityUnitProductInterfaceShoppingCar).getText()+
				driver.findElement(localQuantityUnitLettersProductInterfaceShoppingCar).getText();
				
				
			
		String  delete_units = "d.";
		
		varQuantityProductInterfaceShoppingCar = 
				CharMatcher.anyOf(delete_units).removeFrom(varQuantityProductInterfaceShoppingCar);
		
		String  delete_Decimals = " .00";
		
		expectedQuantityProductOnShoppingCar = 
				CharMatcher.anyOf(delete_Decimals).removeFrom(expectedQuantityProductOnShoppingCar);
				
				
		Assert.assertEquals("VALIDATE UNITS PRODUCT ADD ON SHOPPING CAR INTERFACE", 
				expectedQuantityProductOnShoppingCar, varQuantityProductInterfaceShoppingCar);
		
		System.out.println("validando la cantidad de unidades de los productos add "
				+ "en interfaz iphones, en interfaz carrito de compras.............");
	}
	
	public void validateNumberProductsAddToCarOnInterfacePhone() {
		System.out.println("**********validando numero de productos add "
				+ "en interfaz iphones, en interfaz carrito de compras***********");
		
		Assert.assertEquals("VALIDATE PRODUCT NAME ON SHOPPING CAR INTERFACE", 
				varNameProductInterfaceIphones,varNameProductInterfaceShoppingCar);
		
	}
		
}

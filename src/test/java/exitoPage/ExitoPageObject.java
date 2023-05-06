package exitoPage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.htmlunit.javascript.host.dom.Document;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ExitoPageObject {

	private WebDriver driver;

	private By optionMenu = By.id("category-menu");
	private By mainMenu = By.cssSelector("div[class='exito-category-menu-3-x-containerDrawer']");
	private By category = By.xpath("//p[contains(text(),'Celulares y accesorios')]");

	private By subcategory = By
			.xpath("(((((//section[@class='exito-category-menu-3-x-contentSideMenu']//div//div)[3])//div)[2])//a)[5]");

	private By buttonAdd = By.xpath("((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[53])");

	private By quantitySum1 = By
			.xpath("(((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[54])/button)");

	private By quantitySum2 = By
			.xpath("((((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[54])/button)[2])");

	private By quantityRes = By
			.xpath("((((((((//div[@id='gallery-layout-container']/div)[3])//div)[10])//div)[54])/button)[1])");

	
	private By quantityProdShoppingCar = By.cssSelector("div [ class=\"exito-header-3-x-minicartQuantity\"]");
	private By shoppingCart = By.cssSelector("use[ href=\"#hpa-cart\"]");
	
	

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
		 * estera explicita con expected conditions WebDriverWait ewait = new
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

		if (driver.findElement(subcategory).isDisplayed()) {

			driver.findElement(subcategory).click();
		}

	}

	public void addProducts() {
		System.out.println("el error ahora es al agregar producto");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(buttonAdd).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectQuantity() {

		driver.findElement(quantitySum1).isDisplayed();
		driver.findElement(quantitySum1).click();
		for (int i = 0; i < 4; i++) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(quantitySum2).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		}
	}

	public void validateQuantityProductsOnShoppingCar(String expectedQuantityProductOnShoppingCar) {

		String currentQuantityProductOnShoppingCar = driver.findElement(quantityProdShoppingCar).getText();

		Assert.assertEquals("OJo !!! comparando resultados", expectedQuantityProductOnShoppingCar,
				currentQuantityProductOnShoppingCar);
		System.out.println("la prueba paso 12345 yuuupiiiii, cuando empezamos :D !!!!!!!");
		driver.quit();
	}

	public void checkShoppingCar() {

		driver.findElement(shoppingCart).click();
	}
}

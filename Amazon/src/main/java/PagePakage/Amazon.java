package PagePakage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	WebElement searchbutton;
	
	@FindBy(xpath = "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[3]")
	WebElement title1;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[34]/div/div/span/div/div/div[2]/span/a/div/img")
	WebElement product;
	
	@FindBy(xpath = "//*[@id=\"variation_size_name\"]/div/span")
	WebElement  size;
	
	@FindBy (xpath = "//*[@id=\"add-to-cart-button\"]")
	WebElement Addtocart;
	
	@FindBy (xpath = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/h1")
	WebElement verifyproduct;
	
	@FindBy (xpath = "//*[@id=\"ewc-compact-actions-container\"]/div/div[2]/span/span/a")
	WebElement gototcart;
	
	@FindBy (xpath = "//*[@id=\"sc-subtotal-label-activecart\"]")
	WebElement subtotal;
	public Amazon(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void Test1(String value1)
	{
		search.sendKeys(value1);
		searchbutton.click();
		
		System.out.println(title1.getText());
		
		Assert.assertTrue(title1.isDisplayed());
		
		product.click();
		
		String Expectedsize = "Gallon (90 Count)";
		Assert.assertEquals(Expectedsize, size.getText());
		
		Addtocart.click();
		
		
		if(verifyproduct.isDisplayed())
		{
			System.out.println("The product is successfully addded to cart");
		}
		else
		{
			System.out.println("Product is not added.");
		}
		
		gototcart.click();
		
		String Expectedtitle ="Subtotal (1 item):";
		String Actualtitle = subtotal.getText();
		
		Assert.assertEquals(Expectedtitle, Actualtitle);
			
	}

}

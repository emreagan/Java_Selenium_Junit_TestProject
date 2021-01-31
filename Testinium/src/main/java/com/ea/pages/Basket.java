package com.ea.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Basket extends BasePage {

	public Basket(WebDriver webDriver) {
		super(webDriver);
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(_webDriver, this);	
	}
	
	@FindBy(xpath = "//*[@id=\"empty-cart-container\"]/div[1]/div[1]/div/div[2]/h2")
    private WebElement basketTxt;
	
	@FindBy(xpath = "//*[@id=\"header_wrapper\"]/div[4]/div[3]/a")
    private WebElement myBasket;
	
	@FindBy(xpath = "//*[@id=\"cart-item-455244527\"]/div[2]/div[4]/div/input")
    private WebElement addProduct;
	
	public void myBasketPage(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        myBasket.click();  
		}
	
	
	public void delete() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String deleteJS = 
				  "document.querySelector(\".btn-delete\")" +
				  ".click()";
		((JavascriptExecutor) _webDriver).executeScript(deleteJS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean basketDeleted(){
        return  basketTxt. getText().contains("Sepetinizde ürün bulunmamaktadýr.") ? true : false; 
    }
	
}

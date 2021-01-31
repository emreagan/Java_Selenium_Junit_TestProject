package com.ea.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage{

	public Home(WebDriver webDriver) {
		super(webDriver);
		_webDriver.get("https://www.gittigidiyor.com");
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(_webDriver, this);
	}
	
    @FindBy(className = "GG_hero-slider-pagination swiper-pagination-clickable swiper-pagination-bullets")
    private WebElement slide;
	
	@FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button")
	private WebElement searchBtn;
	
	@FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input")
	private WebElement searchTxt;

	@FindBy(xpath = "//*[@id=\"best-match-right\"]/div[4]/ul/li[2]/a")
	private WebElement secPage;
	
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[3]/div[2]/ul/li[1]/a")
	private WebElement productLink;
	
    @FindBy(id = "add-to-basket")
    private WebElement addToBasketBtn;
   
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a")
    private WebElement logInBtn;
    
    @FindBy(xpath = "//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]")
    private WebElement logInHover;
    
    
    
    public void loginPage(){
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Actions builder = new Actions(_webDriver);
        builder.moveToElement(logInHover).build().perform();
        logInBtn.click();
        
	}
    
	public void search(String text){
		String js = "arguments[0].setAttribute('value','"+text+"')";
		((JavascriptExecutor) _webDriver).executeScript(js, searchTxt);
		searchBtn.submit();
	}
	
	public void secondPage() {
		((JavascriptExecutor) _webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String secondJS = 
				  "document.querySelector(\"#best-match-right > div.pager.pt30.hidden-m.gg-d-24 > ul > li:nth-child(2) > a\")" +
				  ".click()";
		((JavascriptExecutor) _webDriver).executeScript(secondJS);
	}
	
	public void productPage() {
		String secondJS = 
				  "document.querySelector(\"#best-match-right > div.blueWrapper.clearfix > div.clearfix > ul > li:first-child > a\")" +
				  ".click()";
		((JavascriptExecutor) _webDriver).executeScript(secondJS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

	public void addToMyBasket() {
		String addJS = 
				  "document.querySelector(\"#add-to-basket\")" +
				  ".click()";
		((JavascriptExecutor) _webDriver).executeScript(addJS);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public boolean homePageOpened(){
        return slide != null ? true : false;
    }
    
    public boolean secondPageOpened(){
        return _webDriver.getCurrentUrl().contains("sf=2") ? true : false;
    }
    
   
}

package com.ea.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BasePage {
	

    @FindBy(className = "gekhq4-4 hwMdSM")
    private WebElement hesabim;
    
	@FindBy(name = "kullanici")
	private WebElement userNameTxt;
	
	@FindBy(name = "sifre")
	private WebElement passwordTxt;
	
	@FindBy(id = "gg-login-enter")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]")
    private WebElement myAccount;
	
	public Login(WebDriver webDriver) {
		super(webDriver);
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(_webDriver, this);	
	}

	public void login(String userName, String password){
		userNameTxt.sendKeys(userName);
		passwordTxt.sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signInBtn.submit();
	}
	
    public boolean loggedIn(){
        return  myAccount. getText().contains("Hesabým") ? true : false; 
    }
}

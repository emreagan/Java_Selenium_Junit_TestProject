package com.ea.pages;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GittiGidiyorTest{
	static WebDriver webDriver;
	Home home;
	static Logger log = Logger.getLogger(GittiGidiyorTest.class.getName()); 
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emrea\\OneDrive\\Masaüstü\\driver\\chromedriver.exe");
		webDriver = new ChromeDriver();
	}
	
    @Test
    public void test1_Home() {
       log.info("Home Page Test start");	
       home = new Home(webDriver);
       log.assertLog(home.homePageOpened(), "Home Page Test Error");
       Assert.assertTrue(home.homePageOpened());
       home.loginPage();
       log.info("Home Page Test end");
       
    }
    
    @Test
    public void test2_Login() {
       log.info("Login Page Test start");
       Login login = new Login(webDriver);
       login.login("emreagan1100", "emreagan1");
       log.assertLog(login.loggedIn(), "Login Page Test Error");
       Assert.assertTrue(login.loggedIn());
       log.info("Login Page Test end");
    }
    
    @Test
    public void test3_Search() {
    	log.info("Search Page Test start");
       home = new Home(webDriver);
       home.search("bilgisayar");
       home.secondPage();
       log.assertLog(home.secondPageOpened(), "Search Page Test Error");
       Assert.assertTrue(home.secondPageOpened());
       home.productPage();
       home.addToMyBasket();
       log.info("Search Page Test end");
    }
    
    @Test
    public void test4_Basket() {
    	log.info("Basket Page Test start");
       Basket basket = new Basket(webDriver);
       basket.myBasketPage();
       basket.delete();
       log.assertLog(basket.basketDeleted(), "Search Page Test Error");
       Assert.assertTrue(basket.basketDeleted());
       log.info("Basket Page Test end");
       
    }
    
    @AfterClass
    public static void close(){
    	webDriver.close();
    }
}

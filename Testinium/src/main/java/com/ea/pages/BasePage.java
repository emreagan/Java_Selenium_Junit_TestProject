package com.ea.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
	
	protected WebDriver _webDriver;
	
	public BasePage(WebDriver webDriver) {
		_webDriver = webDriver;
	}
}

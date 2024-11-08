package com.webElements.packg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DropdownList_Page extends Base{


	By dropdownList_Passengers = By.name("passCount");
	By dropdownList_DepartingFrom = By.name("fromPort");
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");
	 
	By dropdownListBtn = By.id("dropdown-basic");
	By option2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href = '#/action-2']");
	
	
	public DropdownList_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void signIn() {
		if(isDisplayed(userLocator)) {
			type("qualityadmin", userLocator);
			type("pass1", passLocator);
			click(signInBtnLocator);
			
		}
		else {
			System.out.println("Username textbox was not present");
		}
	}

	public String selectDropdownList_Passengers() throws InterruptedException {
	    
	    if (isDisplayed(dropdownList_Passengers)) {
	    	
	        Select selectList = new Select(findElement(dropdownList_Passengers));

	        selectList.selectByVisibleText("4");

	        return getText(selectList.getFirstSelectedOption());
	    }

	    return "Page or dropdown not found";
	}

	
	public String selectDropdownList_DepartingFrom() {
		
		if (isDisplayed(dropdownList_DepartingFrom)) {
	    	
			Select selectList = new Select(findElement(dropdownList_DepartingFrom));
			selectList.selectByVisibleText("Paris");
			return getText(selectList.getFirstSelectedOption());
	    }

	    return "Page or dropdown not found";
	}
	
	
	
	public void selectReactDropdownList() throws InterruptedException {
		waitForElementVisible(dropdownListBtn, 10);
		scrollToElement(dropdownListBtn); 
	    Thread.sleep(2000);
		click(dropdownListBtn);
		Thread.sleep(3000);
		click(option2);
	}

}
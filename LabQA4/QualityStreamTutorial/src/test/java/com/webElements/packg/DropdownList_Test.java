package com.webElements.packg;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DropdownList_Test {
	
	private WebDriver driver;
	DropdownList_Page ddLPage;
	

	@Before
	public void setUp() throws Exception {
		ddLPage = new DropdownList_Page(driver);
		driver = ddLPage.chromeDriverConnection();
		driver.manage().window().maximize();
	}
	

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	
	@Test
	public void testing_classic_DDL() throws InterruptedException {
		ddLPage.visit("https://demo.guru99.com/test/newtours/");
		ddLPage.signIn();
		assertEquals(ddLPage.selectDropdownList_Passengers(), "4");
		assertEquals(ddLPage.selectDropdownList_DepartingFrom(), "Paris");
		
	}
	
	
	
	@Test
	public void testing_React_DDL() throws InterruptedException {
		ddLPage.visit("https://react-bootstrap.github.io/docs/components/dropdowns/");
		ddLPage.selectReactDropdownList();

	}

}
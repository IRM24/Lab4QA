package com.tests.independiente;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pom.Base;

public class TestIndependiente {
    private WebDriver driver;
    private Base base;

    @Before
    public void setUp() throws Exception {
        base = new Base(driver);
        driver = base.chromeDriverConnection();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHomePageTitle() {
        base.visit("https://phptravels.com/demo/");
        String expectedTitle = "PHPTRAVELS";
        String actualTitle = driver.getTitle();
        assertEquals("El título de la página no coincide", expectedTitle, actualTitle);
    }

    @Test
    public void testLoginButtonVisibility() {
        base.visit("https://phptravels.com/demo/");
        WebElement loginButton = base.findElement(By.linkText("Login"));
        assertTrue("El botón de login no es visible", loginButton.isDisplayed());
    }

    @Test
    public void testSearchFunctionality() {
        base.visit("https://phptravels.com/demo/");
        base.type("Hotel", By.name("q"));
        base.click(By.cssSelector("button[type='submit']"));
        WebElement result = base.waitForElementVisible(By.cssSelector(".search-results"), 10);
        assertTrue("Los resultados de búsqueda no son visibles", result.isDisplayed());
    }

    @Test
    public void testAdminPanelNavigation() {
        base.visit("https://phptravels.com/demo/");
        base.click(By.linkText("Admin"));
        String expectedUrl = "https://phptravels.org/admin";
        assertEquals("La URL del panel de administración no coincide", expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testScrollToFeatures() {
        base.visit("https://phptravels.com/demo/");
        base.scrollToElement(By.linkText("Features"));
        WebElement features = base.findElement(By.linkText("Features"));
        assertTrue("La sección de características no es visible", features.isDisplayed());
    }

    @Test
    public void testHeroTitleText() {
        base.visit("https://phptravels.com/demo/");
        WebElement heroTitle = base.findElement(By.cssSelector(".hero-title"));
        String expectedText = "PHPTRAVELS";
        assertEquals("El texto del título principal no coincide", expectedText, base.getText(heroTitle));
    }

    @Test
    public void testFeatureBoxesCount() {
        base.visit("https://phptravels.com/demo/");
        List<WebElement> featureBoxes = base.findElements(By.cssSelector(".feature-box"));
        assertTrue("No se encontraron cajas de características", featureBoxes.size() > 0);
    }

    @Test
    public void testInvalidLogin() {
        base.visit("https://phptravels.com/demo/");
        base.click(By.linkText("Login"));
        base.type("invalid_user", By.name("username"));
        base.type("invalid_password", By.name("password"));
        base.click(By.cssSelector("button[type='submit']"));
        WebElement errorMessage = base.waitForElementVisible(By.cssSelector(".alert-danger"), 10);
        assertTrue("El mensaje de error no es visible", errorMessage.isDisplayed());
    }
}

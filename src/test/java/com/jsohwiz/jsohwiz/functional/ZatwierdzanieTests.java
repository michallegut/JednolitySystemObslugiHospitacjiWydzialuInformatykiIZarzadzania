package com.jsohwiz.jsohwiz.functional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static org.junit.Assert.*;

public class ZatwierdzanieTests {
    WebDriver webDriver;
    private String url;

    @Before
    public void setUp() {
        WebDriverManager.getInstance(FIREFOX).setup();
        webDriver = new FirefoxDriver();
        url = "http://127.0.0.1:8080/";
    }

    @Test
    public void confirm() {
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[1]")).click();
        String kierunek = webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]")).getText();
        String semestr = webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[2]")).getText() + " "
                + webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[3]")).getText();
        webDriver.findElement(By.xpath("//*[@id=\"zatwierdzanieWyjdzButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        boolean found = false;
        for (int i = 1; !found; i++) {
            try {
                if (kierunek.equals(webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[" + i + "]/form/input")).getAttribute("value"))) {
                    webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[" + i + "]/form/input")).click();
                    for (int j = 1; !found; j++) {
                        if (semestr.equals(webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[" + j + "]/form/input")).getAttribute("value"))) {
                            found = true;
                        }
                    }
                }
            } catch (NoSuchElementException e) {
            }
        }
        assertTrue(found);
        webDriver.findElement(By.xpath("//*[@id=\"opracowywanieWyjdzButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/form/input[1]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[5]/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"szczegolyZatwierdzButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div/h1")).getText(), "Plan hospitacji został zatwierdzony.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form/div/input")).click();
        assertNotEquals(kierunek + semestr,
                webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]")).getText() +
                        webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[2]")).getText() + " "
                        + webDriver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[3]")).getText()
        );
        webDriver.findElement(By.xpath("//*[@id=\"zatwierdzanieWyjdzButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        found = false;
        for (int i = 1; !found; i++) {
            try {
                if (kierunek.equals(webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[" + i + "]/form/input")).getAttribute("value"))) {
                    webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[" + i + "]/form/input")).click();
                    for (int j = 1; !found; j++) {
                        if (semestr.equals(webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[" + j + "]/form/input")).getAttribute("value"))) {
                            found = true;
                        }
                    }
                }
                assertTrue(!found);
                found = true;
            } catch (NoSuchElementException e) {
            }
        }
    }

    @After
    public void setDown() {
        webDriver.quit();
    }
}
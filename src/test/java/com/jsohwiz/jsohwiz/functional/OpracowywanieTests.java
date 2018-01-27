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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpracowywanieTests {
    WebDriver webDriver;
    private String url;

    @Before
    public void setUp() {
        WebDriverManager.getInstance(FIREFOX).setup();
        webDriver = new FirefoxDriver();
        url = "http://127.0.0.1:8080/";
    }

    @Test
    public void messages() {
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        webDriver.findElement(By.xpath("//*[@id=\"szczegolyZatwierdzButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/h1")).getText(), "Plan został zapisany.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/h1")).getText(), "Plan hospitacji został usunięty.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[1]/h1")).getText(), "Plan hospitacji nie został jeszcze zapisany.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form/div[1]/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyDodajHospitacjeButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"5\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"12\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"komisjaDodajHospitacjeButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/h1")).getText(), "Komisja musi mieć przynajmniej dwóch członków.");
        webDriver.findElement(By.xpath("//*[@id=\"error1button\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div/div[1]/label[1]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"komisjaDodajHospitacjeButton\"]")).click();
        if (webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/h1")) != null) {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/h1")).getText(), "Ktoś musi specjalizować się w dziedzinie kursu.");
            webDriver.findElement(By.xpath("//*[@id=\"errorbutton\"]")).click();
        }
        boolean go = true;
        for (int i = 2; go; i++) {
            try {
                webDriver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div/div[" + i + "]/label[1]")).click();
            } catch (NoSuchElementException e) {
                go = false;
            }
        }
        webDriver.findElement(By.xpath("//*[@id=\"komisjaDodajHospitacjeButton\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/h1")).getText(), "Hospitacja została dodana.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
    }

    @Test
    public void addHospitation() {
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyDodajHospitacjeButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"5\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"12\"]")).click();
        boolean go = true;
        for (int i = 1; go; i++) {
            try {
                webDriver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div/div[" + i + "]/label[1]")).click();
            } catch (NoSuchElementException e) {
                go = false;
            }
        }
        webDriver.findElement(By.xpath("//*[@id=\"komisjaDodajHospitacjeButton\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/h1")).getText(), "Hospitacja została dodana.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/input")).click();
        assertEquals(webDriver.findElement(By.xpath("//*[@id=\"szczegolyHospitacjaRow\"]")).getText(), "Hospitacja");
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
    }

    @Test
    public void removeHospitation() {
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyDodajHospitacjeButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"5\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"12\"]")).click();
        boolean go = true;
        for (int i = 1; go; i++) {
            try {
                webDriver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div/div[" + i + "]/label[1]")).click();
            } catch (NoSuchElementException e) {
                go = false;
            }
        }
        webDriver.findElement(By.xpath("//*[@id=\"komisjaDodajHospitacjeButton\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/h1")).getText(), "Hospitacja została dodana.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/input")).click();
        assertEquals(webDriver.findElement(By.xpath("//*[@id=\"szczegolyHospitacjaRow\"]")).getText(), "Hospitacja");
        webDriver.findElement(By.xpath("/html/body/div[2]/table[2]/tbody/tr[1]/th[2]/form/input")).click();
        boolean thrown = false;
        try {
            assertEquals(webDriver.findElement(By.xpath("//*[@id=\"szczegolyHospitacjaRow\"]")).getText(), "Hospitacja");
        } catch (NoSuchElementException e) {
            thrown = true;
        }
        assertTrue(thrown);
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
    }

    @Test
    public void save() {
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyDodajHospitacjeButton\"]")).click();
        webDriver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"5\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"12\"]")).click();
        boolean go = true;
        for (int i = 1; go; i++) {
            try {
                webDriver.findElement(By.xpath("/html/body/div[2]/form[2]/div/div/div[" + i + "]/label[1]")).click();
            } catch (NoSuchElementException e) {
                go = false;
            }
        }
        webDriver.findElement(By.xpath("//*[@id=\"komisjaDodajHospitacjeButton\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/h1")).getText(), "Hospitacja została dodana.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/input")).click();
        assertEquals(webDriver.findElement(By.xpath("//*[@id=\"szczegolyHospitacjaRow\"]")).getText(), "Hospitacja");
        webDriver.findElement(By.xpath("//*[@id=\"szczegolyZatwierdzButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/h1")).getText(), "Plan został zapisany.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"szczegolyPowrotButton\"]")).click();
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        assertEquals(webDriver.findElement(By.xpath("//*[@id=\"szczegolyHospitacjaRow\"]")).getText(), "Hospitacja");
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
    }

    @Test
    public void removeHospitationPlan() {
        webDriver.get(url);
        webDriver.findElement(By.xpath("/html/body/div/form/input[2]")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]/form/input")).click();
        webDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/form/input")).click();
        try {
            assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/h1")).getText(), "UWAGA: Nie wszyscy nauczyciele spoza uczelni i doktoranci zostali uwzględnieni w planach hospitacji na ten semestr.");
            webDriver.findElement(By.xpath("/html/body/div[2]/form/div[3]/input")).click();
        } catch (NoSuchElementException e) {
        }
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[1]/h1")).getText(), "Plan hospitacji nie został jeszcze zapisany.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form/div[1]/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"szczegolyZatwierdzButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/h1")).getText(), "Plan został zapisany.");
        webDriver.findElement(By.xpath("/html/body/div[2]/form/div[2]/input")).click();
        webDriver.findElement(By.xpath("//*[@id=\"aktualnyUsunPlanHospitacjiButton\"]")).click();
        assertEquals(webDriver.findElement(By.xpath("/html/body/div[2]/form[1]/div/h1")).getText(), "Plan hospitacji został usunięty.");
    }

    @After
    public void setDown() {
        webDriver.quit();
    }
}
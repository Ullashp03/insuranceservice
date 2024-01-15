package com.example.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InsuranceSerivice2ApplicationTests {

	 SoftAssert soft = new SoftAssert();
	    WebDriver driver;
	    @Test
	    public void Launch() {
	        System.setProperty("webdriver.chrome.driver", "D:/chromedriver-win64/chromedriver-win64/chromedriver.exe/");
	        driver = new ChromeDriver();
	        try {
	            Thread.sleep(1000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test(groups = "Chrome", dependsOnMethods = "Launch")
	    public void f() {
	        try {
	            WebDriver driver = new ChromeDriver();
	            driver.manage().window().maximize();
	            driver.get("https://www.flipkart.com/");

	            // To find the load time and print on console
	            Long loadtime = (Long) ((JavascriptExecutor) driver)
	                    .executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
	            System.out.println("Load time of the website is :- " + loadtime);

	            // To search the given text in the search bar
	            driver.findElement(By.className("Pke_EE")).sendKeys("iphone 13");
	            driver.findElement(By.className("_2iLD__")).click();

	            WebElement i = driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
	            Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
	                    + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

	            if (p) {
	                System.out.println("Image is loaded");
	            } else {
	                System.out.println("Image not loaded");
	            }

	            try {
	                long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

	                while (true) {
	                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	                    Thread.sleep(2000);

	                    long newHeight = (long) ((JavascriptExecutor) driver)
	                            .executeScript("return document.body.scrollHeight");
	                    if (newHeight == lastHeight) {
	                        break;
	                    }
	                    lastHeight = newHeight;
	                }
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } finally {
	                // Close the browser
	                driver.quit();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test(groups="Firefox")
	    public void LaunchFirefox() {
	        System.setProperty("webdriver.gecko.driver", "D:/geckodriver-v0.34.0-win32/geckodriver.exe/");
	        driver = new FirefoxDriver();
	        driver.get("https://www.facebook.com");
	        try {
	            Thread.sleep(4000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    }
	    
	    @Test(groups="Firefox", dependsOnMethods="LaunchFirefox")
	    public void TryFacebook2() {
	        System.out.println(Thread.currentThread().getId());
	        driver.findElement(By.id("email")).sendKeys("ullas@gmail.com");
	        driver.findElement(By.id("pass")).sendKeys("12345");
	        driver.findElement(By.name("login")).click();
	        System.out.println(Thread.currentThread().getId());
	    }
	}

package com.example.selenium;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	static WebDriver driver ;
    public static void main( String[] args ) throws InterruptedException{
    	
    	LecturaArchivoExcel lectura = new LecturaArchivoExcel();
    	ResourceBundle rb = ResourceBundle.getBundle("com/example/selenium/configuracion");

    	driver = new ChromeDriver();
    	System.setProperty("Webdriver", "chromedriver.exe");
        System.out.println( "INICIO" );
    	
    	driver.manage().window().maximize();
    	driver.get("https://www.google.com/");
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	
    	WebElement click1;
    	WebElement click2;
    	WebElement click3;
    	WebElement click4;
    	WebElement click5;
    	WebElement click6;
    	WebElement click7;
    	WebElement click8;
    	WebElement click9;
    	WebElement click10;
    	
    	click1 = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
    	click1.sendKeys("gmail \n");
    
    	
    	click2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a"));
    	click2.click();
    	
    	click3 = driver.findElement(By.xpath("/html/body/nav/div/a[2]"));
    	click3.click();
    	//login
    	click4 = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
    	click4.sendKeys(rb.getString("user").concat("\n") );
    	
    	click5 = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
    	click5.sendKeys(rb.getString("password").concat("\n"));
    	
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	Thread.sleep(1000);
    	for (Dato informacion : lectura.leer()) {
    	//redactar
    	click6 = driver.findElement( By.xpath("//*[@id=\":hu\"]/div/div")); //*[@id=":hu"]/div/div
    	click6.click();
    	//input para
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   
    	click7 = driver.findElement(By.name("to")); //*[@id=\":mq\"] 
    	click7.sendKeys(informacion.getCorreo());
    
    	
    	//input asunto
    	click8 = driver.findElement(By.name("subjectbox")); //*[@id=\":m8\"]
    	click8.sendKeys(informacion.getAsunto());
    	//Thread.sleep(1000);
    	//input descripcion
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	click9 = driver.findElement(By.xpath("//*[@class='Am Al editable LW-avf']")); //*[@id=\":nd\"]
    	click9.sendKeys(informacion.getDescripcion());
    	
    	//boton enviar
    	click10 = driver.findElement(By.xpath("//*[text()='Enviar']")); //*[@id=\":ly\"] 
    	click10.click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	Thread.sleep(1200);
    	}
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	
    	
    	driver.close();
    	
    	 System.out.println( "FIN" );
    	
    	 
    	 
    }
}


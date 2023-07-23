package com.flipkart.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static void impliciteWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void expliciteWait(WebDriver driver, int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void takeScreenshot(WebDriver driver, String FileName) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\EclipseProject\\flipkart\\TakeScreenshot\\FileName+");
		FileHandler.copy(source, dest);
	}
	public static String  readConfigProp(String propName) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("E:\\EclipseProject\\flipkart\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		prop.load(file);
		return prop.getProperty(propName);
	}
	

}

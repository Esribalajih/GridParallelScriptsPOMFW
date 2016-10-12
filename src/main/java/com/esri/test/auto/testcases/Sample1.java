package com.esri.test.auto.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Sample1{
	

	public static void main (String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.esri.com/training/events/search/");
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//div[@class='dropdown-check ng-isolate-scope filter-active']/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='dropdown-check ng-isolate-scope filter-active']/div[2]/div[2]")).click();
		driver.findElement(By.className("btn btn-large ng-scope")).click();
		driver.findElement(By.xpath("//div[@class='ngdialog ngdialog-theme-default custom-width-800 ng-scope']/div[2]/div[2]")).click();
	
	}
}

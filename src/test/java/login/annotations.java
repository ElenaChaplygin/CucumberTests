package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class annotations {
	WebDriver driver = null;
	
	@Given ("^User clicks \"Login\" link$")
	public void openSiteAndClickLogin(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Elena Chaplygina\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("https://www.routeperfect.com/");
		  driver.findElement(By.xpath("//div[@class='login login__underline'][contains(text(),'Login')]")).click();
		  driver.findElement(By.xpath("//button[@class='link-primary'][contains(text(),'Log in')]")).click();
	}
	
	@When ("^User enters correct login and password$")
	public void logIn(){
		driver.findElement(By.cssSelector("form#login-form > div:first-child > input-text > div.input-text > input")).sendKeys("www@www.com");
		driver.findElement(By.cssSelector("form#login-form > div:nth-child(3) > input-text > div.input-text > input")).sendKeys("www111www");
		driver.findElement(By.cssSelector("div.authentication-submit > app-button > button")).click();	
		
	}
	
	@Then ("^He sees \"Hi, user name\" greatin$")
	public void validateGreating(){
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='site-menu__user__menu__name'][contains(text(),'Hi www')]")).isEnabled());
		driver.close();
	}

}

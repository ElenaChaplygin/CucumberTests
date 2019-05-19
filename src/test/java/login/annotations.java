package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class annotations {
	WebDriver driver = null;
	
	@Given ("^User navigates to url (.*)$")
	public void navigateToSite(String url){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Elena Chaplygina\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get(url);
	}
	
	@When ("^User clicks Login link$")
	public void clickLoginLink() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='login login__underline'][contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//button[@class='link-primary'][contains(text(),'Log in')]")).click();
	}
	
	@And ("^User enters (?:.*) login (.*) and password (.*)$")
	public void logIn(String login, String password){
		driver.findElement(By.cssSelector("form#login-form > div:first-child > input-text > div.input-text > input")).sendKeys(login);
		driver.findElement(By.cssSelector("form#login-form > div:nth-child(3) > input-text > div.input-text > input")).sendKeys(password);
		driver.findElement(By.cssSelector("div.authentication-submit > app-button > button")).click();	
		
	}
	
	@Then ("^He sees \"Hi, user name\" greating$")
	public void validateGreating() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='site-menu__user__menu__name'][contains(text(),'Hi www')]")).isEnabled());
		driver.close();
	}
	
	@Then("^Then He sees ERROR notification$")
	public void validateError() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-horizontal__error password--backend'][contains(text(),'Invalid email')]")).isEnabled());
		driver.close();
	}
	
	@Then("^He sees EMPTY notification$")
	public void validateEmpty() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'This field is required')]")).isEnabled());
		driver.close();
	}
	

}

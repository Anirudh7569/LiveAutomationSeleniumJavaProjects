package tutorialsninja.register;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

// verify registering an account by providing only mandatory fields.

public class TC_RF_001 {
	
	@Test  
	public void VerifyRegisterWithMandatoryFields() throws InterruptedException  {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");		
		Thread.sleep(2000);
		WebElement My = driver.findElement(By.xpath("//span[text()='My Account']"));
		My.click();
		WebElement Register = driver.findElement(By.xpath("//a[text()='Register']"));
		Register.click();		
		if(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/register")) {
			System.out.println("register page");
		}else {
			System.out.println("register fail");
		}
		WebElement First = driver.findElement(By.id("input-firstname"));
		First.sendKeys("Anirudh");
		WebElement Last = driver.findElement(By.id("input-lastname"));
		Last.sendKeys("Kandakatla");
		WebElement Email = driver.findElement(By.id("input-email"));
		Email.sendKeys(GenerateNewEmail());
		WebElement Tele = driver.findElement(By.id("input-telephone"));
		Tele.sendKeys("123456789");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("K.Ani");
		WebElement con = driver.findElement(By.id("input-confirm"));
		con.sendKeys("K.Ani");
		WebElement po = driver.findElement(By.name("agree"));
		po.click();
		WebElement Co = driver.findElement(By.xpath("//input[@value='Continue']"));
		Co.click();
		if(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success")) {
			System.out.println("register complet");
		}else {
			System.out.println("register not complet");
		}
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		String actualProperDetails1 = "Congratulations! Your new account has been successfully created!";
		String actualProperDetails2 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualProperDetails3 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualProperDetails4 = "contact us.";
		Thread.sleep(2000);
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		Thread.sleep(2000);
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails1));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails2));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails3));
		Assert.assertTrue(expectedProperDetails.contains(actualProperDetails4));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()= 'Continue']")).click();
		Thread.sleep(2000);
	    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		Thread.sleep(2000);
	    driver.close();	
	}
	
	// to get different mail id in each times.
	    public static String GenerateNewEmail() {
			return new Date().toString().replaceAll(" ", "").replaceAll("\\:", "")+"@gamil.com";
		}
}
/*  
public static String GenerateNewEmail() {
Date d = new Date();
String dateString = d.toString();
String noSpaceDateString = dateString.replaceAll(" ", "");
String noSpaceAndNoColonesDateString = noSpaceDateString.replaceAll("\\:", "");
String emailwithTimeStamp = noSpaceAndNoColonesDateString + "@gamil.com";
return emailwithTimeStamp;
*/

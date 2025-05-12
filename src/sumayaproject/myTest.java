package sumayaproject;

import org.testng.annotations.Test;



import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


//this is my firstproject in github

public class myTest {
	WebDriver driver = new ChromeDriver();
	String THEWEBSITE = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(THEWEBSITE);
	}

	@Test(priority = 1)
	public void addOneRandomItem() throws InterruptedException {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LoginIButton = driver.findElement(By.id("login-button"));
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginIButton.click();

	}

	@Test(priority = 2)
	public void addAllItems() throws InterruptedException {
		List<WebElement> AddToTheCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToTheCartButtons.size(); i++) {

			AddToTheCartButtons.get(i).click();
			Thread.sleep(2000);
		}
	}

	@Test(priority = 3)
	public void RemoveAllItems() throws InterruptedException {
		Thread.sleep(2000);

		List<WebElement> RemoveButtons = driver.findElements(By.className("btn_secondary"));
		for (int i = 0; i < RemoveButtons.size(); i++) {

			RemoveButtons.get(i).click();

		}

	}

	@Test(priority = 4)
	public void Task() {
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		for(int i=0;i<ItemsNames.size();i++) {
			if(ItemsNames.get(i).getText().equals("Sauce Labs Fleece Jacket")){
			
			break;
			 } System.out.println(ItemsNames.get(i).getText());
			
			
			}
		
		
		}
	
//		for (int i = 1; i < ItemsNames.size(); i=i+2) {
//			System.out.println(ItemsNames.get(i).getText());طبع الي على جهة اليمين
			
//			String itemName = ItemsNames.get(i).getText();
////			System.out.println(ItemName.charAt(0));__ اذا بدي اطبع اول حرف من كل اسم 1
//			-------------------------
//			if(itemName.startsWith("S"))  2 sبدي اطبع الي ما ببلشو بحرف
//			{continue;
//			
//				
//				
//			} else {
//				System.out.println(itemName);
//				
//			}
//
//		}
		
	
	@Test(priority = 3, enabled = false)
	public void removeItemFromTheCart() {
		WebElement BackPackRemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
		BackPackRemoveButton.click();
	}

	@Test(priority = 4, enabled = false)
	public void LogOut() throws InterruptedException {
		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenu.click();
		Thread.sleep(1000);
		WebElement LogOutButton = driver.findElement(By.id("logout_sidebar_link"));
		LogOutButton.click();
		WebElement MainLogo = driver.findElement(By.className("login_logo"));
		System.out.println(MainLogo.getText());
		WebElement UserNames = driver.findElement(By.id("login_credentials"));
		System.out.println(UserNames.getText());

	}

	@AfterTest
	public void myAfterTest() {

		driver.quit();
	}

}

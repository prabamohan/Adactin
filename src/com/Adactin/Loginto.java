package com.Adactin;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Loginto {

	static WebDriver driver;

	public static void BrowserLaunch() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\praba\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/index.php");

	}

	// //input[@id='username']

	public static void LoginDetails() {

		WebElement Login = driver.findElement(By.xpath("//input[@id='username']"));
		Login.sendKeys("Prabagaran");
		WebElement Pass = driver.findElement(By.xpath("//input[@id='password']"));
		Pass.sendKeys("9245761196");
		WebElement Button = driver.findElement(By.xpath("//input[@id='login']"));
		Button.click();

	}

	public static void LocationHandle() {

		Select Loc = new Select(driver.findElement(By.xpath("//select[@name='location']")));

		Loc.selectByValue("London");

		Select Hot = new Select(driver.findElement(By.xpath("//select[@name='hotels']")));

		Hot.selectByValue("Hotel Sunshine");

		Select Room = new Select(driver.findElement(By.xpath("//select[@name='room_type']")));

		Room.selectByValue("Super Deluxe");

		Select Qnt = new Select(driver.findElement(By.xpath("//select[@name='room_nos']")));

		Qnt.selectByValue("1");

		// input[@id='datepick_in']

		WebElement Datein = driver.findElement(By.xpath("//input[@id='datepick_in']"));
		Datein.clear();
		Datein.sendKeys("28/09/2022");

		WebElement Dateout = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		Dateout.clear();
		Dateout.sendKeys("30/09/2022");

		Select Nof = new Select(driver.findElement(By.xpath("//select[@id='adult_room']")));

		Nof.selectByValue("2");
		

		Select Child = new Select(driver.findElement(By.xpath("// select[@id='child_room']")));

		Child.selectByValue("4");

		WebElement search = driver.findElement(By.xpath("//input[@id='Submit']"));
		search.click();

		WebElement HotelSelect = driver.findElement(By.xpath("//input[@id='radiobutton_0']"));

		boolean Check = HotelSelect.isSelected();
		if (!Check) {
			HotelSelect.click();

			WebElement Continue = driver.findElement(By.xpath("//input[@id='continue']"));
			Continue.click();

		}

	}

	@SuppressWarnings("deprecation")
	public static void BookHotel() {
		String FirstName = "Prabagaran";
		String LastName = "Elangovan";
		String Add = "Tiruvannamalai";

		String CC = "1234567898765432";

		WebElement FName = driver.findElement(By.xpath("//input[@id='first_name']"));
		FName.sendKeys(FirstName);

		WebElement LName = driver.findElement(By.xpath("//input[@id='last_name']"));
		LName.sendKeys(LastName);

		WebElement AName = driver.findElement(By.xpath("//textarea[@id='address']"));
		AName.sendKeys(Add);

		WebElement Cc = driver.findElement(By.xpath("//input[@id='cc_num']"));
		Cc.sendKeys(CC);

		Select ccType = new Select(driver.findElement(By.xpath("//select[@id='cc_type']")));

		ccType.selectByValue("AMEX");

		Select Vmont = new Select(driver.findElement(By.xpath("//select[@id='cc_exp_month']")));

		Vmont.selectByValue("12");

		Select Vyr = new Select(driver.findElement(By.xpath("//select[@id='cc_exp_year']")));

		Vyr.selectByValue("2022");

		WebElement cvv = driver.findElement(By.xpath("//input[@id='cc_cvv']"));

		cvv.sendKeys("123");

		WebElement now = driver.findElement(By.xpath("//input[@id='book_now']"));

		now.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void TakeSnap() throws IOException, InterruptedException {

		Thread.sleep(10000);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File file = new File("C:\\Users\\praba\\Pictures\\Hotel.png");

		FileHandler.copy(SrcFile, file);

	}

	public static void Logout() {

		// *[@id='logout']

		WebElement logout = driver.findElement(By.xpath("//*[@id='logout']"));

		logout.click();

	}

	public static void main(String[] args) throws InterruptedException, IOException {

		BrowserLaunch();

		LoginDetails();

		Thread.sleep(3000);

		LocationHandle();

		BookHotel();

		TakeSnap();
		
		Logout();

		driver.quit();
	}

}

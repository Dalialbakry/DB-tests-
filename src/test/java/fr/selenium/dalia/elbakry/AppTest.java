package fr.selenium.dalia.elbakry;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static final String URL = "http://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER = "C:\\Users\\formation\\Documents\\chromedriver.exe";
	public static WebDriver driver;

	public static void firstTest() {

		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER); // System.setProperty(key, value)
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// pausa(3);

		// driver.findElement(By.linkText("/world/common_rn/img/btn_continue_en.gif"));
		// driver.findElement(By.partilaLinkText("javascript:void(0);"));
		driver.findElements(By.cssSelector("#JS_ciBox_contents img")).get(1).click();
		// driver.findElement(By.className("mdl_icon mdl_icon_close")).click();

		Select s = new Select(driver.findElement(By.id("mdlDepLocation1")));
		s.selectByValue("NCE");
		// departure

		driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")).click();
		/*
		 * Select s1 = new Select (driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		 * s1.selectByValue("6");
		 */
		Select s1 = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		s1.selectByValue("12");
		driver.findElement(By.id("DEPARTURE_DATE_1_DAY")).click();
		// return
		driver.findElement(By.id("DEPARTURE_DATE_2_MONTH")).click();
		driver.findElement(By.id("DEPARTURE_DATE_2_DAY")).click();

		// search
		driver.findElement(By.id("mdlFormSubmit")).click();

		System.out.println("***********FLIGHT SELECTION***************");
		// get departure city, arrival city, flight number, flight time and price
		// departutre city
		String departureCity1 = "";
		departureCity1 = driver.findElement(By.id("bound-departure-0")).getText();
		System.out.println(departureCity1);

		// arrival city
		String arrivalCity1 = "";
		arrivalCity1 = driver.findElement(By.id("bound-arrival-0")).getText();
		System.out.println(arrivalCity1);

		// departure date
		String departureDate1 = "";
		departureDate1 = driver.findElement(By.id("segmentOriginDate-0-0")).getText();
		System.out.println(departureDate1);

		// arrival date
		String arrivalDate1 = "";
		arrivalDate1 = driver.findElement(By.id("segmentDestinationDate-0-1")).getText();
		System.out.println(arrivalDate1);

		// flight price
		String departureFlightPrice1 = "";
		departureFlightPrice1 = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		
		//explicit waiting time for time
		
	    try 
	    	{
	    		System.out.println(LocalDateTime.now());
	    		WebDriverWait wait = new WebDriverWait(driver, 15);
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flightNumber-0-0 .flight-identifier")));
	    		System.out.println("On a  trouvé  : " + LocalDateTime.now());
	    	} 
	    catch (TimeoutException e) 
	    	{
	    		System.out.println("On n'a pas trouvé l element : " + LocalDateTime.now());
	    	}
	       
	      

		if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) 
		{
			System.out.println("Le flight number s'affiche");
		} else 
		{
			System.out.println("Le flight number ne s'affiche pas. Il faut cliquer pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();
		}
		
		
		WebElement e0 = driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"));
		String departureFlightNumber1a = e0.getText();
		System.out.println(departureFlightNumber1a);
		
		//explicit waiting time to click - waitting time to click
		/*WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".medium-pattern.mb1.p5")).LAST_PANEL_TO_LOAD)));*/
		
		//explicit waiting time for time
		
	    try 
	    	{
	    		System.out.println(LocalDateTime.now());
	    		WebDriverWait wait = new WebDriverWait(driver, 15);
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flightNumber-0-0 .flight-identifier")));
	    		System.out.println("On a  trouvé  : " + LocalDateTime.now());
	    	} 
	    catch (TimeoutException e) 
	    	{
	    		System.out.println("On n'a pas trouvé l element : " + LocalDateTime.now());
	    	}
		


		// departure flight number1b
		String departureFlightNumber1b = "";
		departureFlightNumber1b = driver.findElement(By.cssSelector("#flightNumber-0-1 .flight-identifier")).getText();
		System.out.println(departureFlightNumber1b);

		// return flight details
		// return departutre city
		String returnDepartureCity2 = "";
		returnDepartureCity2 = driver.findElement(By.id("bound-departure-1")).getText();
		System.out.println(returnDepartureCity2);

		// return arrival city
		String returnArrivalCity2 = "";
		returnArrivalCity2 = driver.findElement(By.id("bound-arrival-1")).getText();
		System.out.println(returnArrivalCity2);

		// return date
		String returnDepartureDate2 = "";
		returnDepartureDate2 = driver.findElement(By.id("segmentOriginDate-1-0")).getText();
		System.out.println(returnDepartureDate2);

		// return arrival date
		String returnArrivalDate2 = "";
		returnArrivalDate2 = driver.findElement(By.id("segmentDestinationDate-1-1")).getText();
		System.out.println(returnArrivalDate2);

		// return flight price
		/*
		 * String returnDepartureFlightPrice2 =""; returnDepartureFlightPrice2 =
		 * driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		 * System.out.println(returnDepartureFlightPrice2);
		 */
		
		

		if (driver.findElement(By.cssSelector("#flightNumber-1-0 .flight-identifier")).isDisplayed()) 
		{
			System.out.println("Le flight number s'affiche");
		} 
		else 
		{
			System.out.println("Le flight number ne s'affiche pas. Il faut cliquer pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(1).click();
		}

		// show details
		//driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(1).click();

		// return flight number2
		String returnDepartureFlightNumber2a = "";
		WebElement e3 = driver.findElement(By.cssSelector("#flightNumber-1-0 .flight-identifier"));
		returnDepartureFlightNumber2a = e3.getText();
		System.out.println(returnDepartureFlightNumber2a);

		// return flight number2b
		String returnDepartureFlightNumber2b = "";
		returnDepartureFlightNumber2b = driver.findElement(By.cssSelector("#flightNumber-1-1 .flight-identifier"))
				.getText();
		System.out.println(returnDepartureFlightNumber2b);

		// continue
		driver.findElement(By.id("continueButton")).click();

		// scroll and select title
		Select s2 = new Select(driver.findElement(By.id("0-title")));
		s2.selectByValue("MRS");

		// input last name
		driver.findElement(By.id("0-last-name")).sendKeys("ELBAKRY");

		// input first name
		driver.findElement(By.id("0-first-name")).sendKeys("Dalia");

		// scroll and select gender
		Select s3 = new Select(driver.findElement(By.id("0-gender")));
		s3.selectByValue("string:FEMALE");

		// scroll and select date of birth
		Select s4 = new Select(driver.findElement(By.id("0-birth-date-day")));
		s4.selectByValue("string:17");

		Select s5 = new Select(driver.findElement(By.id("0-birth-date-month")));
		s5.selectByValue("string:04");

		Select s6 = new Select(driver.findElement(By.id("0-birth-date-year")));
		s6.selectByValue("string:1974");

		// select nationality
		Select s7 = new Select(driver.findElement(By.id("0-nationality")));
		s7.selectByValue("string:EG");

		// phone number
		// select country
		Select s8 = new Select(driver.findElement(By.id("phone1-phone-country-0")));
		s8.selectByValue("FRA");

		// enter phone number
		driver.findElement(By.id("phone1-phone-number-0")).sendKeys("0611551470");

		// enter email
		driver.findElement(By.id("email-guest-address")).sendKeys("dalia.elbakry@gmail.com");

		// confirm email
		driver.findElement(By.id("email-confirm-new")).sendKeys("dalia.elbakry@gmail.com");

		// skip seat selection
		WebElement element = driver.findElement(By.id("skip-seat"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

		// choose your seat
		// driver.findElement(By.id("")).click();

		// click continue
		driver.findElement(By.id("continueButton")).click();

		// pop up confirm
		driver.findElement(By.id("continueButton-PCOF")).click();

		System.out.println("***********FLIGHT CONFIRMATION****************");

		// get departure city, arrival city, flight number, flight time and price
		// departutre city
		String confirmedDepartureCity1 = "";
		confirmedDepartureCity1 = driver.findElement(By.id("originLocation-0")).getText();
		System.out.println(confirmedDepartureCity1);

		// arrival city
		String confirmedArrivalCity1 = "";
		confirmedArrivalCity1 = driver.findElement(By.id("destinationLocation-0")).getText();
		System.out.println(confirmedArrivalCity1);

		// departure date
		String confirmedDepartureDate1 = "";
		confirmedDepartureDate1 = driver.findElement(By.id("originDate-0")).getText();
		System.out.println(confirmedDepartureDate1);

		// arrival date
		String confirmedArrivalDate1 = "";
		confirmedArrivalDate1 = driver.findElement(By.id("originDate-1")).getText();
		System.out.println(confirmedArrivalDate1);

		// flight price
		String confirmedDepartureFlightPrice1 = "";
		confirmedDepartureFlightPrice1 = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println(confirmedDepartureFlightPrice1);

		// confirmed departure flight number
		String confirmedDepartureFlightNumber1a = "";
		confirmedDepartureFlightNumber1a = driver.findElement(By.id("flightNumber-0-0")).getText();
		System.out.println(confirmedDepartureFlightNumber1a);

		String confirmedDepartureFlightNumber1b = "";
		confirmedDepartureFlightNumber1b = driver.findElement(By.id("flightNumber-0-1")).getText();
		System.out.println(confirmedDepartureFlightNumber1b);

		// confirmed return flight number
		String confirmedReturnDepartureFlightNumber2a = "";
		confirmedReturnDepartureFlightNumber2a = driver.findElement(By.id("flightNumber-0-0")).getText();
		System.out.println(confirmedReturnDepartureFlightNumber2a);

		String confirmedReturneFlightNumber2b = "";
		confirmedReturneFlightNumber2b = driver.findElement(By.id("flightNumber-1-0")).getText();
		System.out.println(confirmedReturneFlightNumber2b);

		//assertEquals = comparison between collected values
		System.out.println("departure city");
		assertEquals(departureCity1, confirmedDepartureCity1);
		
		System.out.println("arrival city");
		assertEquals(arrivalCity1, confirmedArrivalCity1);
		
		System.out.println("1st departure date");
		assertEquals(departureDate1, confirmedDepartureDate1);
		
		
//		System.out.println("flight price");
//		assertEquals(departureFlightPrice1, confirmedDepartureFlightPrice1);
		
		System.out.println("1st return flight number");
		assertTrue(confirmedDepartureFlightNumber1a.contains(departureFlightNumber1a));
		
		
		System.out.println("confirmedReturneFlightNumber2b : " +confirmedReturneFlightNumber2b);
		System.out.println("returnDepartureFlightNumber2a : " + returnDepartureFlightNumber2a);
		System.out.println("2nd return flight number");
		assertTrue(confirmedReturneFlightNumber2b.contains(returnDepartureFlightNumber2a));
		
		
		
		
		/*--------------------------------------PAYMENT--------------------------------------*/
		// click go to payment
		driver.findElement(By.id("purchaseButton")).click();

		// credit card number
		driver.findElement(By.id("CCnb")).sendKeys("4012888888881881");

		// expirary date
		driver.findElement(By.id("expiration-month-id")).sendKeys("12");
		driver.findElement(By.id("expiration-year-id")).sendKeys("2019");

		// security code
		driver.findElement(By.id("sec-code")).sendKeys("123");

		// continue
		WebElement element1 = driver.findElement(By.id("continueButton"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(element1).click().build().perform();
		
		
		

	}


	private static void pausa(int seconds) 
	{
		try 
		{
			Thread.sleep(seconds * 1000);
		} 
		catch (InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
	
	
	
}

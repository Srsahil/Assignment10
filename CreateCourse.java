package Assignment10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import dev.failsafe.internal.util.Assert;

public class CreateCourse {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("ineuron@ineuron.ai");// entering the credential email 
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("ineuron"); //entering the credential password 
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();// click on signup button 
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//*[text()='Manage']"));// locating manage from navigation 
		Actions act=new Actions(driver);// using Action class to move to the cursor to manage course 
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//span[text()='Manage Courses']")).click();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Add New Course ']")).click();
		
		
		
		Thread.sleep(2000);
		// Entering the details of form for the enrollment of course 
		driver.findElement(By.xpath("//input[@id='thumbnail']")).sendKeys("C:\\Users\\SrSahil\\Desktop\\842-8426297_2-kb-v-desenho-flores-amarelas-png.png");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Selenium with Java");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("this course is about Selenium");
		driver.findElement(By.xpath("//input[@id='instructorNameId']")).sendKeys("Mukesh Otwani");
		WebElement price = driver.findElement(By.xpath("//input[@id='price']"));
		price.clear();
		price.sendKeys("2000");
		driver.findElement(By.xpath("//div[text()=\"Select Category\"]")).click();
		driver.findElement(By.xpath("//button[text()='Selenium']")).click();
		
	driver.findElement(By.cssSelector("button[class='action-btn']")).click();
	Thread.sleep(2000);// providing sleep so that it can wait to reflect the course addition 
	WebElement coursename=	driver.findElement(By.xpath("//table[1]//td[1]//following::td[text()='Selenium with Java']"));// locating course webelement 
	WebElement instructor =driver.findElement(By.xpath("//table[1]//td[2]//following::td[text()='Selenium with Java']//following::td[2]"));// finding the webelement of the Instructor name 
	String instructor1=instructor.getText();
	String Text=coursename.getText();
	if(Text.contains("Selenium with Java")&& instructor1.equals("Mukesh Otwani"))// checking if course present with given name and instructor 
	{
		System.out.println("yes ,Selenium with java course is present ");// print yes if found the match 
	}
	else
	{
		System.out.println("false,Selenium with java course is not Present ");
	}
	
	driver.findElement(By.xpath("//table[1]//td[1]//following::td[text()='Selenium with Java']//following::td[9]//button[1]")).click();
	Thread.sleep(2000);
	
	
	//identifying table 
	WebElement table1=driver.findElement(By.xpath("//div//table[1]"));
	List < WebElement > rows_table = table1.findElements(By.tagName("tr"));
	//To calculate no of rows In table.
	int rows_count = rows_table.size();
boolean present=true;
	//Loop will execute till the last row of table.
	for (int row = 1; row < rows_count; row++) {
	    //To locate columns(cells) of that specific row.
	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    //To calculate no of columns (cells). In that specific row.
	    int columns_count = Columns_row.size();
	    //Loop will execute only execute to that Course  specific row.
	    for (int column = 1; column <=1; column++) {
	        // To retrieve text from that specific cell.
	        String courseName = Columns_row.get(column).getText();
	      if (courseName.equals("Selenium with Java"))
	      {
	    	  present=false;
	    	
	      }
	       
	    }
	   
	}
	System.out.println("is course deleted "+present);
	// signout from application
	driver.findElement(By.xpath("//button[text()='Sign out']")).click();
	Thread.sleep(1000);
	driver.quit();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    }





import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// 1. Find total number of rows
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); //preferable
		//driver.findElement(By.tagName("tr")).size();  //if you have one single table
		System.out.println("number of rows:"+rows);
		
		
		// 2. Find total number of columns
		int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("number of columns:"+cols);
		
		
		
		// 3. Read specific row and column data
		
		//String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
	//	System.out.println(value);
		
		
		// 4. Read data from all the rows & columns
		
		/*
		System.out.println("Book Name"+"   "+"Author"+"    "+"Subject"+"   "+"Price");  //for table header
	
		for(int r=2;r<=rows;r++)
		{
			
		
			for(int c=1;c<=cols;c++)
			{
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"  \t");
					
			}
			System.out.println();
		}
		*/
		
		// 5. print book names whose author is amit 
		
		/*for(int r=2;r<=rows;r++)
		{
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			
			if(author.equals("Mukesh"))
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println(author+"   "+bookname);
			}
		}*/
		
		// 6. Find sum of prices all the books
		
		int sum=0;
		for(int r=2;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
			sum=sum+Integer.parseInt(price);
		}
		System.out.println("total price of book:"+sum);
		
	}

}

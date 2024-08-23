package MainTest;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class mainTest {
	WebDriver driver;
	ExtentReports extent;
	
	@BeforeSuite
	public void ExtentSetUp() {
		extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("MyTestReport.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Web Testing Automation Assessment");
		spark.config().setReportName("Nasif Sadiq");
		extent.attachReporter(spark);
		
		
	   
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		  System.setProperty("C:\\eclipse\\chrome-win64\\chrome.exe\"", "C:\\eclipse");
		     driver= new ChromeDriver();
		//System.setProperty("driver.firfox.mariontee", "C:\\eclipse");
		//  driver= new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		  driver.get("http://localhost:3000/teebay-buggy");
		  driver.manage().window().maximize();
		  //Thread.sleep(2000);
		  
		  
	}
	
 	@Test(priority=1)
	public void LogInTest() throws InterruptedException {
		ExtentTest test=extent.createTest("Log In","Teebay Buggy").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		//Thread.sleep(2000);
		pomClass pm= new pomClass(driver);
		
		//giving email
		pm.setEmail("testuser@teebay.com");
		test.info("Email:testuser@teebay.com");
		
		//Thread.sleep(1000);
		
		pm.setPassword("123456");
		test.info("Password:123456");
		
		//Thread.sleep(1000);
		pm.clickLogInBtn();
		
		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else 
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		

		
		    
		
		
	}
	
	@Test(priority=2)
	public void BrowseProductsTest() throws InterruptedException {
		
ExtentTest test=extent.createTest("Browse Products","Teebay Buggy").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		//Thread.sleep(2000);
		pomClass pm= new pomClass(driver);
		
		//giving email
		pm.setEmail("testuser@teebay.com");
		test.info("Email:testuser@teebay.com");
		
		//Thread.sleep(1000);
		
		pm.setPassword("123456");
		test.info("Password:123456");
		
		//Thread.sleep(1000);
		pm.clickLogInBtn();
		
		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else 
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		

		//Thread.sleep(3000);
		pm.ClickBrowseProducts();
		test.info("visiting Browse Products page");
		
		//Thread.sleep(2000);
		
		String dview = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/div/div[2]/div[2]")).getText();
		String numberPart = dview.split(" ")[0]; // Extract "23"
		test.info(numberPart);
		int viewCount = Integer.parseInt(numberPart); // Convert to integer
		test.info("First view Count: "+viewCount);

		
		//Thread.sleep(2000);
		//click products
		pm.ClickBlender();
		test.info("clicked product");
		
		
    
		String view=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]")).getText();
		test.info(view);
		
		 
        Thread.sleep(2000);
        // Navigate back to "Browse Products" page
        driver.navigate().back();
        test.info("Back to List Page");
        
 
        
     // Locate the product again and get the updated view count
         dview = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/div/div[2]/div[2]")).getText();
         numberPart = dview.split(" ")[0]; // Extract "23"
         test.info(numberPart);
        

        numberPart = dview.split(" ")[0]; // Method 1: Extract "24"
        int updatedViewCount = Integer.parseInt(numberPart);
        
        test.info("Updated View Count: "+ updatedViewCount);

        // Validate if the view count has increased by 1
        if (updatedViewCount == viewCount + 1) {
            test.pass("Passed");
        } else {
            test.fail("failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        }
	
		
	} 
	
	@Test(priority=3)
	public void DeleteProductsTest() throws InterruptedException {
		
		ExtentTest test=extent.createTest("Delete Products","Teebay Buggy").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		//Thread.sleep(2000);
		pomClass pm= new pomClass(driver);
		
		//giving email
		pm.setEmail("testuser@teebay.com");
		test.info("Email:testuser@teebay.com");
		
		Thread.sleep(1000);
		
		pm.setPassword("123456");
		test.info("Password:123456");
		
		Thread.sleep(1000);
		pm.clickLogInBtn();
		
		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else 
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		

		//Thread.sleep(3000);
		
		 if(pm.FirstProductDelete.isDisplayed()&& pm.FirstProductDelete.isEnabled()) {
		 pm.clcikFirstProductDelete();
		 test.info("Clcik on delete button for first product");
		 }
		 Thread.sleep(3000);
		 
		 if(pm.ConfirmFirstProductDelete.isDisplayed() && pm.ConfirmFirstProductDelete.isEnabled()) {
		 pm.clickConfirmFirstProductDelete();
		 test.info("Clcik on confirm delete  for first product");
		 
		 test.pass("Deleted");
		 }
		 
		 else {
			 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 }
		 Thread.sleep(3000);
			
		 if(pm.SecondProductDelete.isEnabled() && pm.SecondProductDelete.isDisplayed()) {	
		 pm.clickSecondProductDelete();
		 test.info("Clcik on delete button for Second product");
		 
		 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 
		 }
		 else {
		 test.fail("Test failed"+"unable to click, internal surver error occured",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 }
		 //Thread.sleep(3000);
		 
		/* if(pm.confirmSecondProductDelete.isDisplayed() && pm.SecondProductDelete.isEnabled()) {
		 pm.confirmSecondProductDelete();
		 test.info("Clcik on confirm delete for second product");
		 
		 test.pass("Deleted");
		 }
		 else{
			 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 } */
			 

		
	} 
	@Test(priority=4)
	public void AddProductsTest() throws InterruptedException {
		
		ExtentTest test=extent.createTest("Add Products","Teebay Buggy").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		//Thread.sleep(2000);
		pomClass pm= new pomClass(driver);
		
		//giving email
		pm.setEmail("testuser@teebay.com");
		test.info("Email:testuser@teebay.com");
		
		//Thread.sleep(1000);
		
		pm.setPassword("123456");
		test.info("Password:123456");
		
		//Thread.sleep(1000);
		pm.clickLogInBtn();
		
		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else 
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		

		//Thread.sleep(3000);
		
		if(pm.AddProduct.isEnabled() && pm.AddProduct.isDisplayed()) {
			pm.ClickAddProduct();
			test.info("click add product");
		}
		else {
			test.fail("Button is not clickable");
		}
		
		//Thread.sleep(3000);
		pm.GetTitleValue("Test Data 1");
		test.info("Title Given for products 1");
		
		
		//Thread.sleep(2000);
		pm.clickCategories();
		test.info("Selected Catagories");
		
		//Thread.sleep(2000);
		pm.clickSelectCategories();
		test.info("Selected dropdown Catagories");
		
		//Thread.sleep(2000);
		pm.clickClickUn();
		
		//Thread.sleep(1000);
		pm.setDescription("Test Data 1");
		test.info("Description Given for products 1");
		
		//Thread.sleep(1000);
		pm.setPrice("40");
		test.info("Price given: $40");
		
		//Thread.sleep(1000);
		pm.setRentPrice("20");
		test.info("Price Rent given: $20");
		
		
		//Thread.sleep(1000);
		pm.setRentDuration();
		test.info("click RentDuration");
		
		//Thread.sleep(1000);
		pm.setHrRentDuration();
		test.info("click RentDuration Hourly");
		
		//Thread.sleep(1000);
		pm.clickAddProductbtn();
		test.info("click Add Product Button");
		//Thread.sleep(1000);
		
		if(driver.getTitle().contains("React App")) {
			test.pass("product created",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		 else{
			 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 }
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
        Thread.sleep(3000);
		
		if(pm.AddProduct.isEnabled() && pm.AddProduct.isDisplayed()) {
			pm.ClickAddProduct();
			test.info("click add product");
		}
		else {
			test.fail("Button is not clickable");
		}
		
		//Thread.sleep(3000);
		pm.GetTitleValue("Test Data 2");
		test.info("Title Given for products 2");
		
		
		//Thread.sleep(2000);
		pm.clickCategories();
		test.info("Selected Catagories");
		
		//Thread.sleep(2000);
		pm.clickSelectCategories();
		test.info("Selected dropdown Catagories");
		
		//Thread.sleep(2000);
		pm.clickClickUn();
		
		//Thread.sleep(1000);
		pm.setDescription("Test Data 2");
		test.info("Description Given for products 2");
		
		//Thread.sleep(1000);
		pm.setPrice("40");
		test.info("Price given: $40");
		
		//Thread.sleep(1000);
		pm.setRentPrice("20");
		test.info("Price Rent given: $20");
		
		
		//Thread.sleep(1000);
		pm.setRentDuration();
		test.info("click RentDuration");
		
		//Thread.sleep(1000);
		pm.setHrRentDuration();
		test.info("click RentDuration Hourly");
		
		//Thread.sleep(1000);
		pm.clickAddProductbtn();
		test.info("click Add Product Button");
	//	Thread.sleep(1000);
		
		if(driver.getTitle().contains("React App")) {
			test.pass("product created",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		 else{
			 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 }
		Thread.sleep(3000);
		
		driver.navigate().refresh();
        Thread.sleep(3000);
		
		if(pm.AddProduct.isEnabled() && pm.AddProduct.isDisplayed()) {
			pm.ClickAddProduct();
			test.info("click add product");
		}
		else {
			test.fail("Button is not clickable");
		}
		
	//	Thread.sleep(3000);
		pm.GetTitleValue("Test Data 3");
		test.info("Title Given for products 3");
		
		
		//Thread.sleep(2000);
		pm.clickCategories();
		test.info("Selected Catagories");
		
		//Thread.sleep(2000);
		pm.clickSelectCategories();
		test.info("Selected dropdown Catagories");
		
		//Thread.sleep(2000);
		pm.clickClickUn();
		
		//Thread.sleep(1000);
		pm.setDescription("Test Data 3");
		test.info("Description Given for products 3");
		
		//Thread.sleep(1000);
		pm.setPrice("400");
		test.info("Price given: $400");
		
		//Thread.sleep(1000);
		pm.setRentPrice("20");
		test.info("Price Rent given: $20");
		
		
		//Thread.sleep(1000);
		pm.setRentDuration();
		test.info("click RentDuration");
		
		//Thread.sleep(1000);
		pm.setHrRentDuration();
		test.info("click RentDuration Hourly");
		
		//Thread.sleep(1000);
		pm.clickAddProductbtn();
		test.info("click Add Product Button");
		//Thread.sleep(1000);
		
		if(driver.getTitle().contains("React App")) {
			test.pass("product created",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		 else{
			 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 }
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
        Thread.sleep(3000);
		
		if(pm.AddProduct.isEnabled() && pm.AddProduct.isDisplayed()) {
			pm.ClickAddProduct();
			test.info("click add product");
		}
		else {
			test.fail("Button is not clickable");
		}
		
	//	Thread.sleep(3000);
		pm.GetTitleValue("Test Data 4");
		test.info("Title Given for products 4");
		
		
		//Thread.sleep(2000);
		pm.clickCategories();
		test.info("Selected Catagories");
		
		//Thread.sleep(2000);
		pm.clickSelectCategories();
		test.info("Selected dropdown Catagories");
		
		//Thread.sleep(2000);
		pm.clickClickUn();
		
		//Thread.sleep(1000);
		pm.setDescription("Test Data 4");
		test.info("Description Given for products 4");
		
		//Thread.sleep(1000);
		pm.setPrice("200");
		test.info("Price given: $200");
		
		//Thread.sleep(1000);
		pm.setRentPrice("20");
		test.info("Price Rent given: $20");
		
		
		//Thread.sleep(1000);
		pm.setRentDuration();
		test.info("click RentDuration");
		
		//Thread.sleep(1000);
		pm.setHrRentDuration();
		test.info("click RentDuration Hourly");
		
		//Thread.sleep(1000);
		pm.clickAddProductbtn();
		test.info("click Add Product Button");
		//Thread.sleep(1000);
		
		if(driver.getTitle().contains("React App")) {
			test.pass("product created",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		 else{
			 test.fail("failed to delete",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		 }
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
        Thread.sleep(3000);
		
		if(pm.AddProduct.isEnabled() && pm.AddProduct.isDisplayed()) {
			pm.ClickAddProduct();
			test.info("click add product");
		}
		else {
			test.fail("Button is not clickable");
		}
		
	//	Thread.sleep(3000);
		pm.GetTitleValue("Test Data 5");
		test.info("Title Given for products 5");
		
		
	//	Thread.sleep(2000);
		pm.clickCategories();
		test.info("Selected Catagories");
		
	//	Thread.sleep(2000);
		pm.clickSelectCategories();
		test.info("Selected dropdown Catagories");
		
//		Thread.sleep(2000);
		pm.clickClickUn();
		
	//	Thread.sleep(1000);
		pm.setDescription("Test Data 5");
		test.info("Description Given for products 5");
		
		//Thread.sleep(1000);
		pm.setPrice("44");
		test.info("Price given: $44");
		
	//	Thread.sleep(1000);
		pm.setRentPrice("20");
		test.info("Price Rent given: $20");
		
		
//		Thread.sleep(1000);
		pm.setRentDuration();
		test.info("click RentDuration");
		
	//	Thread.sleep(1000);
		pm.setHrRentDuration();
		test.info("click RentDuration Hourly");
		
	//	Thread.sleep(1000);
		pm.clickAddProductbtn();
		test.info("click Add Product Button");
		 test.fail("failed to Add Product",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
	//	Thread.sleep(1000);
		
		
	} 
	
	@Test(priority=5)
	public void SearchProductsTest() throws InterruptedException {
		
		ExtentTest test=extent.createTest("Search Products","Teebay Buggy").assignAuthor("Nasif").assignDevice("Windows 11: Chrome Browser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
		//Thread.sleep(2000);
		pomClass pm= new pomClass(driver);
		
		//giving email
		pm.setEmail("testuser@teebay.com");
		test.info("Email:testuser@teebay.com");
		
		//Thread.sleep(1000);
		
		pm.setPassword("123456");
		test.info("Password:123456");
		
	//	Thread.sleep(1000);
		pm.clickLogInBtn();
		
		String expectedTitle="React App";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			test.pass("Log in Successful");
		}
		else 
			test.fail("Log In Failed" ,MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		

	//	Thread.sleep(3000);
		if(pm.BrowseProducts.isDisplayed() && pm.BrowseProducts.isEnabled()) {
			pm.ClickBrowseProducts();
			test.info("Clicked Browse Products Page");
		}
		
	//	Thread.sleep(2000);
		pm.setSearchTitle("Funshine bear");
		test.info("Tile:Funshine bear ");
		
	//	Thread.sleep(2000);
		pm.clickSearchCategory();
		
//		Thread.sleep(2000);
		pm.cickSearchCategoryToys();
		test.info("Search Category:Toy ");
		
	//	Thread.sleep(2000);
		pm.clickBuy();
		
	//	Thread.sleep(2000);
		pm.setPriceMin("10");
		
		test.info("Min price: $10");
		
	//	Thread.sleep(2000);
		pm.setPriceMax("100");
		
		test.info("Min price: $100");
		
	//	Thread.sleep(2000);
		pm.clickFilter();
		
		String Exp_Title="Funshine bear";
		String Act_Title= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div")).getText();
		if(Exp_Title.contains(Act_Title)) {
			test.pass("All filters Funtional");
		}
		else {
			
			test.fail("Title filter are not Funtional",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		
	//	Thread.sleep(2000);
		pm.clickClear();
		//Category and Buy Filters
		
	//	Thread.sleep(2000);
		pm.clickSearchCategory();
		
	//	Thread.sleep(2000);
		pm.cickSearchCategoryToys();
		test.info("Search Category:Toy ");
		
		Thread.sleep(2000);
		pm.clickBuy();
		
		Thread.sleep(2000);
		pm.setPriceMin("10");
		
		test.info("Min price: $10");
		
		Thread.sleep(2000);
		pm.setPriceMax("100");
		
		test.info("Min price: $100");
		
		Thread.sleep(2000);
		pm.clickFilter();
		
		String Exp_categary="Categories: Toys";
		String Act_categary= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]")).getText();
		if(Exp_categary.contains(Act_categary)) {
			test.pass("Categary and Buy filters are Funtional");
		}
		else {
			
			test.fail("Categary and Buy filters are Funtional",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
		Thread.sleep(2000);
		pm.clickClear();
		//Category and Buy Filters
		
		Thread.sleep(2000);
		pm.clickSearchCategory();
		
		Thread.sleep(2000);
		pm.cickSearchCategoryToys();
		test.info("Search Category:Toy ");
		
		Thread.sleep(2000);
		pm.clickRentFilter();
		
		Thread.sleep(2000);
		pm.setRentMin("1");
		
		test.info("Min price: $1");
		
		Thread.sleep(2000);
		pm.setRenteMax("20");
		
		test.info("Min price: $20");
		
		Thread.sleep(2000);
		pm.clickSeaarchRentDuration();
		
		Thread.sleep(2000);
		pm.clickSeaarchRentDurationDaily();
		test.info("Rent Duration is Daily");
		
		Thread.sleep(2000);
		pm.clickFilter();
		
		String Exp_categary1="Categories: Toys";
		String Act_categary1= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]")).getText();
		if(Exp_categary1.contains(Act_categary1)) {
			test.pass("Categary and Rent filters are Funtional");
		}
		else {
			
			test.fail("Categary and Rent filters are Funtional",MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		}
	}
	
	
	@AfterMethod
	public void tearDown1() {
		
		driver.close();
		
	}
	@AfterSuite
	public void tearDwon() {
		extent.flush();
		
	}
	public String getBase64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

}

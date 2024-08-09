package MainTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pomClass {
	
	WebDriver driver;
	 public pomClass(WebDriver d) {
		 driver=d;
			PageFactory.initElements(d, this);
	}
	 
	 // log in page
	 
	 //Email
	 @FindBy(name="email")
	 WebElement Email;
	 
	 public void setEmail(String email) {
		 Email.sendKeys(email);
	 }
	 
	 //Password
	 @FindBy (name="password")
	 WebElement Password;
	 
	 public void setPassword(String password) {
		 Password.sendKeys(password);
	 }
	 //click
	 @FindBy(xpath="//*[@id=\"root\"]/div[1]/div/div/div/form/div[4]/button")
	 WebElement LogIn;
	 public void clickLogInBtn() {
		 LogIn.click();
	 }
	 
	 //Browse Products
	 
	 //visiting Browse Products page
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[1]/a[2]")
	 WebElement BrowseProducts;
	
	 public void ClickBrowseProducts() {
		 BrowseProducts.click();
	 }
	 
	 
	 
	 //4.Blender
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/div")
	 
	 WebElement Blender;
	 
	 public void ClickBlender() {
		 Blender.click();
	 }
	 
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	/* @FindBy(xpath="(//div[normalize-space()='Views: 28'])[1]")
	 WebElement BlenderViewCount;
	 
	 public int getBlenderViewCount() {
		 
		return Integer.parseInt(BlenderViewCount.getText());
	 }*/
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div")
	 WebElement product4Title;
	 
	 public boolean isProduct4TitleDisplayed() {
			return product4Title.isDisplayed();
		}
	 
	 @FindBy(xpath="(//div[normalize-space()='Views: 28'])[1]")
	 WebElement BlenderViewCount;
	 
	 public int getBlenderViewCount() {
		 
		return Integer.parseInt(BlenderViewCount.getText());
	 }
	 
	 
	 //Delete Products
	 
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div/div[1]/div[1]/button")
	
	
	 WebElement FirstProductDelete;
	 
	 public void clcikFirstProductDelete() {
		 FirstProductDelete.click(); 
	 }
      
	 @FindBy(xpath="/html/body/div[2]/div/div[2]/button[2]")
	 WebElement ConfirmFirstProductDelete;
	 
	 public void clickConfirmFirstProductDelete() {
		 ConfirmFirstProductDelete.click();
	 }
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/button")
	 WebElement SecondProductDelete;
	 
	 public void clickSecondProductDelete() {
		 SecondProductDelete.click();
	 }
	 @FindBy(xpath="") //didn't able go that page
	 WebElement confirmSecondProductDelete;
	 
	 public void confirmSecondProductDelete() {
		 confirmSecondProductDelete.click();
	 }
	 
	// Add Products
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/button")
	 WebElement AddProduct;
	 
	 public void ClickAddProduct() {
		 AddProduct.click();
	 }
	 
	 //Sending values to Title
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[1]/input")
	 WebElement Title;
	 
	 public void GetTitleValue(String title) {
		 Title.sendKeys(title);
	 }
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[2]/div")
	 WebElement Categories;
	 
	 public void clickCategories() {
		 Categories.click();
	 }
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[2]/div/div/div[1]")
	 WebElement SelectCategories;
	 public void clickSelectCategories() {
		 SelectCategories.click();
		 
	 }
	 
	 @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[2]/label")
	 WebElement ClickUn;
	 
	 public void clickClickUn() {
		 ClickUn.click();
	 }
	 
	  @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[3]/textarea")
	  WebElement Description;
	  public void setDescription(String description) {
		  Description.sendKeys(description);
	  }
	 @FindBy(name="purchase_price")
	 WebElement Price;
	 
	 public void setPrice(String price) {
		 Price.sendKeys(price);
	 }
	 
	  @FindBy(name="rent_price")
	  WebElement RentPrice;
	  
	  public void setRentPrice(String rent) {
		  RentPrice.sendKeys(rent);
	  }
	  
	  @FindBy(name="rent_duration_type")
	  WebElement RentDuration;
	  
	  public void setRentDuration() {
		  RentDuration.click();
	  }
	  
	  @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[4]/div[2]/div[2]/div/div[2]/div[1]")
	  WebElement HrRentDuration;
	  public void setHrRentDuration() {
		  HrRentDuration.click();
	  }
	  
	  @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/div/form/div[5]/button")
	  WebElement AddProductbtn;
	  
	  public void clickAddProductbtn() {
		  AddProductbtn.click();
	  }
	  
	  //Search Products
	  
	  // Search_title
	  
	  @FindBy(name="title")
	  WebElement SearchTitle;
	  public void setSearchTitle(String searchTitle) {
		  SearchTitle.sendKeys(searchTitle);
	  }
	  @FindBy(name="category")
	  WebElement SearchCategory;
	  
	  public void clickSearchCategory() {
		  SearchCategory.click();
	  }
	  
      @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/div/form/div[2]/div/div[2]/div[6]")
      WebElement SearchCategoryToys;
      public void cickSearchCategoryToys() {
    	  SearchCategory.click();
      }
      
      @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/div/form/div[3]/div/div/label")
      WebElement Buy;
      public void clickBuy() {
    	  Buy.click();
      }
      
      @FindBy(name="min_buy_range")
      WebElement PriceMin;
      public void setPriceMin(String pricemin) {
    	  PriceMin.sendKeys(pricemin);
      }
      @FindBy(name="max_buy_range")
      WebElement PriceMax;
      public void setPriceMax(String pricemax) {
    	  PriceMax.sendKeys(pricemax);
      }
      
      //rent
      @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/div/form/div[4]/div/div/label")
      WebElement RentFilter;
      public void clickRentFilter() {
    	  RentFilter.click();
      }
      
      
      @FindBy(name="min_rent_range")
      WebElement RenteMin;
      public void setRentMin(String rentmin) {
    	  RenteMin.sendKeys(rentmin);
      }
      @FindBy(name="max_rent_range")
      WebElement RenteMax;
      public void setRenteMax(String rentmax) {
    	  RenteMax.sendKeys(rentmax);
      }
      
      @FindBy(name="rent_duration_type")
      WebElement SeaarchRentDuration;
      public void clickSeaarchRentDuration() {
    	  SeaarchRentDuration.click();
      }
      
      
      @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/div/form/div[6]/div/div[2]/div[1]")
      WebElement SeaarchRentDurationDaily;
      public void clickSeaarchRentDurationDaily() {
    	  SeaarchRentDurationDaily.click();
      }
      
      @FindBy(xpath="//button[normalize-space()='Filter']")
      WebElement Filter;
      public void clickFilter() {
    	  Filter.click();
      }
      
      @FindBy(xpath="//button[normalize-space()='Clear']")
      WebElement Clear;
      
      public void clickClear() {
    	  Clear.click();
      }
      
      
      
}

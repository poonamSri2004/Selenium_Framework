package com.training.pom;
	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


	public class ProductAddPOM {

			private WebDriver driver;
			boolean bValue = false;
			String mesgretvalue =null;

			public ProductAddPOM(WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//a[contains(text(),'Data')]")
			private WebElement dataoption; 

			@FindBy(xpath="//input[@id='input-name1']")
			private WebElement prodname; 

			@FindBy(xpath="//input[@id='input-meta-title1']")
			private WebElement prodtitle; 

			@FindBy(xpath="//input[@id='input-model']")
			private WebElement prodmodel; 

			@FindBy(xpath="//input[@id='input-price']")
			private WebElement prodprice; 

			@FindBy(xpath="//input[@id='input-quantity']")
			private WebElement prodquantity; 

			@FindBy(xpath="//a[contains(text(),'Links')]")
			private WebElement linksoptions; 

			@FindBy(xpath="//input[@id='input-category']")
			private WebElement categorylist; 

			@FindBy(linkText="Earrings")
			private WebElement selectedcategory; 

			@FindBy(xpath="//a[contains(text(),'Discount')]")
			private WebElement discounttab; 

			@FindBy(xpath="//table[@id='discount']//button[@type='button']")
			private WebElement adddiscountbtn; 

			@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Quantity']")
			private WebElement discountquantity;

			@FindBy(xpath="//td[@class='text-right']//input[@placeholder='Price']")
			private WebElement discountprise;

			@FindBy(xpath="//tr[@id='discount-row0']//td[5]//div[1]//span[1]//button[1]//i[1]")
			private WebElement startdate;

			@FindBy(xpath="//tr[@id='discount-row0']//td[6]//div[1]//span[1]//button[1]//i[1]")
			private WebElement enddate;

			@FindBy(xpath="//a[@href='#tab-reward']")
			private WebElement rewardpointtab;

			@FindBy(xpath="//input[@id='input-points']")
			private WebElement points;

			@FindBy(xpath="//div[@class='alert alert-danger']")
			private WebElement errormsg; 

			@FindBy(xpath="//a[@class='btn btn-default']")
			private WebElement canclebtn; 

			@FindBy(xpath="//i[@class='fa fa-save']")
			private WebElement savebtn; 

			public void selectdataoption() throws InterruptedException
			{
			this.dataoption.click();
			}

			public void selectlinksoption() throws InterruptedException
			{
			this.linksoptions.click();
			}

			public void sendprodname(String prodname) 
			{
				System.out.println("within sendprodname ");
				this.prodname.clear();
				this.prodname.sendKeys(prodname);
			}

			public void sendprodTitle(String prodtitle) throws InterruptedException 
			{  System.out.println("within sendprodTitle ");
				this.prodtitle.clear();
				this.prodtitle.sendKeys(prodtitle);
				Thread.sleep(3000);
			}

			public void sendprodmodel(String prodmodel) throws InterruptedException 
			{
				this.prodmodel.clear();
				this.prodmodel.sendKeys(prodmodel);
				Thread.sleep(3000);
			}

			public void sendprodprice(String prodprice) throws InterruptedException 
			{
				this.prodprice.clear();
				this.prodprice.sendKeys(prodprice);
				Thread.sleep(3000);
			}

			public void sendprodquantity(String prodquantity) throws InterruptedException 
			{
				this.prodquantity.clear();
				this.prodquantity.sendKeys(prodquantity);
				Thread.sleep(3000);
			}

			public void selecetcategory() throws InterruptedException 
			{

					this.categorylist.click(); 
					Thread.sleep(2000);
					Actions actions = new Actions(driver);
					actions.moveToElement(this.selectedcategory).click().perform();


			}

			public void selectdiscountoption() 
			{
				this.discounttab.click();
				this.adddiscountbtn.click();

			}

			public void senddiscquantity(String discquantity)
			{
				this.discountquantity.clear();
				this.discountquantity.sendKeys(discquantity);
			}

			public void senddiscprise(String discprise)
			{
				this.discountprise.clear();
				this.discountprise.sendKeys(discprise);
			}

			public void selectstartdate()
			{
				this.startdate.click();

			}

			public void selectenddate()
			{
				this.enddate.click();

			}

			public void selectrewardpointtab()
			{
				this.rewardpointtab.click();

			}

			public void sendrewardPoints(String rewardpoints)
			{
				this.points.clear();
				this.points.sendKeys(rewardpoints);
			}

			public String chkerrmsg()
			{
				String errmsgvalue= this.errormsg.getText();
				return errmsgvalue;
			}
			public void canclebtnclick()
			{
				this.canclebtn.click();
			}

			public void savedetails() 
			{
				this.savebtn.click();

			}
			public String getnamevalue()
			{
				return this.prodname.getAttribute("value");
			}

	        public String gettitlevalue()
	        {	
			return this.prodtitle.getAttribute("value");
			}

	        public String getmodelvalue()
	        {	
			return this.prodmodel.getAttribute("value");
			}

	        public int getpricevalue()
	        {	
	        	String Stringprice = this.prodprice.getAttribute("value");

	        	int intprice = Integer.parseInt(Stringprice);
	        	return intprice;

			}

	        public int getquantityvalue()
	        {	
			String Stringquan= this.prodquantity.getAttribute("value");
			int intquan = Integer.parseInt(Stringquan);
	    	return intquan;
			}

	        public String getcategoryvalue()
	        {	
			return this.selectedcategory.getAttribute("value");
			}

			}


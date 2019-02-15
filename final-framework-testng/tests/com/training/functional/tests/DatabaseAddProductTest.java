package com.training.functional.tests;

	import org.testng.annotations.Test;

	import com.training.dataproviders.DBAddproductDataprovider;
	import com.training.dataproviders.LoginDataProviders;
	//import com.training.bean.DBAddproductBean;
	//import com.training.dao.DBAddproductDAO;
	import com.training.generics.GenericMethods;
	import com.training.generics.ScreenShot;
	import com.training.pom.CatalogPOM;
	import com.training.pom.LoginPOM;
	import com.training.pom.ProductAddPOM;
	//import com.training.pom.ProductsPOM;
	//import com.training.pom.retailLoginpage;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	import org.testng.annotations.BeforeClass;

	import static org.testng.Assert.assertTrue;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;

	public class DatabaseAddProductTest {
		private WebDriver driver;
		private String baseUrl;
		private static Properties properties;
		//private retailLoginpage retailLoginpage;
		private CatalogPOM catalogpom;
		private LoginPOM loginPOM;
		//private ProductsPOM produtspom;
		private ProductAddPOM productaddpom;
		private String screenname= null;
		private String screetitle= null;
		private String screenmodel= null;
		private int screenprice= 0;
		private int screenquantity= 0;
		private String screencategory= null;

		@Test(priority =0)
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver);
			
			catalogpom = new CatalogPOM(driver);
			//produtspom = new ProductsPOM(driver);
			productaddpom = new ProductAddPOM(driver);
			baseUrl = properties.getProperty("baseURL");  // open the browser 
			driver.get(baseUrl);
		}

	  @BeforeClass

	  public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}

	 /* @AfterClass

	  public void tearDown() throws Exception{
			Thread.sleep(1000);
			driver.quit();

	}*/
	  @Test(priority =1)
		public void loginadmin() throws InterruptedException			//login to application
		{
		  loginPOM.sendUserName("admin");
		  loginPOM.sendPassword("admin@123");
		  loginPOM.clickLoginBtn(); 

		}
	  
	  /*
		@Test(priority =2)
		public void catalog() throws InterruptedException				//move to catalog-product-  click add option
		{

			catalogpom.movecatalog();

			catalogpom.clickproducts();
			produtspom.addnewprod();


		}
		
		*/

		@Test(priority =3)
		public void addGeneral() throws InterruptedException	//add information in general tab, data tab, links tab and save
		{
			productaddpom.sendprodname("testname");
			screenname= productaddpom.getnamevalue();
			System.out.println("nem value is " + screenname);
			productaddpom.sendprodTitle("testtitle");
			screetitle= productaddpom.gettitlevalue();
			productaddpom.selectdataoption();
			productaddpom.sendprodmodel("SKU-003");
			screenmodel= productaddpom.getmodelvalue();
			productaddpom.sendprodprice("500");
			screenprice= productaddpom.getpricevalue();
			productaddpom.sendprodquantity("10");
			screenquantity= productaddpom.getquantityvalue();
			productaddpom.selectlinksoption();
			productaddpom.selecetcategory();
			screencategory= productaddpom.getcategoryvalue();
			productaddpom.savedetails();



		}
		
		/*
		@Test(priority =4)                                                //assertion to check return message
		public void getmsg() throws InterruptedException 
		{
			String actualmsg= produtspom.returnaddproductmessage();
			String Expectedmsg = "Success: You have modified products!";	
			boolean st = actualmsg.contains(Expectedmsg);
	      assertTrue(st);
	      Thread.sleep(3000);
		}
		*/

		@Test(priority =5,dataProvider = "db-inputs", dataProviderClass = DBAddproductDataprovider.class)
		public void loginDBTest(String prodname, String prodtitle, String prodmodel,int prodprice, int prodquan,String prodcategory ) {


			System.out.println("product name is " + prodname);
			System.out.println("product prodtitle is " + prodtitle);
			System.out.println("product prodmodel is " + prodmodel);
			System.out.println("product prodprice is " + prodprice);
			System.out.println("product prodquan is " + prodquan);
			System.out.println("product prodcategory is " + prodcategory);
			
			/*

			boolean st1 = screenname.contains(prodname);
		    assertTrue(st1);
		    boolean st2 = screetitle.contains(prodtitle);
		    assertTrue(st2);
		    boolean st3 = screenmodel.contains(prodmodel);
		    assertTrue(st3);

		    boolean st6 = screencategory.contains(prodcategory);
		    assertTrue(st6);

		    if (screenprice==prodprice )
		    {
		    System.out.println("price is match");
		    }

		  //  Assert.assertEquals(screenprice, prodprice);

		    if (screenquantity==prodquan )
		    {
		    System.out.println("quantity is match");
		    }

		   // Assert.assertEquals(screenquantity, prodquan);

	*/

		}
	}


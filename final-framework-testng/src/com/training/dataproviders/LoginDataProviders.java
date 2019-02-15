package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.DBBean2;
import com.training.dao.ELearningDAO;
import com.training.dao.RetailDAO2;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<DBBean2> list = new RetailDAO2().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(DBBean2 temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getFName(); 
			obj[1] = temp.getLName(); 
			obj[2] = temp.getmail(); 
			obj[3] = temp.getPNumber(); 
			obj[4] = temp.getpwd(); 
			obj[5] = temp.getconfirmpwd(); 
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}

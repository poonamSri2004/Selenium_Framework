package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.DBBean2;
//import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RetailDAO2 {
	
	Properties properties; 
	
	public RetailDAO2() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DBBean2> getLogins(){
		String sql = properties.getProperty("get.custgroup"); 
		
		GetConnection gc  = new GetConnection(); 
		List<DBBean2> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<DBBean2>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				DBBean2 temp = new DBBean2(); 

				
				temp.setFName(gc.rs1.getString(1));
				temp.setLName(gc.rs1.getString(2));
				temp.setmail(gc.rs1.getString(3));
				temp.setPNumber(gc.rs1.getString(4));
				temp.setpwd(gc.rs1.getString(5));
				temp.setconfirmpwd(gc.rs1.getString(6));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO2().getLogins().forEach(System.out :: println);
	}
	
	
}

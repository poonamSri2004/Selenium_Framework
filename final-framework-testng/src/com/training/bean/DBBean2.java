package com.training.bean;

/**
 * 
 * @author Naveen
 * @see this class shall get the bean data 
 */
public class DBBean2 {
	private String url; 
	private String driver; 
	private String FName;
	private String LName;
	private String mail;
	private String PNumber;
	private String pwd;
	private String confirmpwd;
	
	public DBBean2(){}

	public DBBean2( String FName,String LName,String mail,String PNumber,String pwd,String confirmpwd) {
		super();
		this.FName = FName;
		this.LName = LName;
		this.mail = mail;
		this.PNumber = PNumber;
		this.pwd = pwd;
		this.confirmpwd = confirmpwd;
	}


	public String getFName() {
		return FName;
	}

	public void setFName(String FName){
		this.FName = FName;
	}
	public String getLName() {
		return LName;
	}

	public void setLName(String LName){
		this.LName = LName;
	}
	public String getmail() {
		return mail;
	}

	public void setmail(String mail){
		this.mail = mail;
	}
	public String getPNumber() {
		return PNumber;
	}

	public void setPNumber(String PNumber){
		this.PNumber = PNumber;
	}
	public String getpwd() {
		return pwd;
	}

	public void setpwd(String pwd){
		this.pwd = pwd;
	}
	public String getconfirmpwd() {
		return confirmpwd;
	}

	public void setconfirmpwd(String confirmpwd){
		this.confirmpwd = confirmpwd;
	}
	
	@Override
	public String toString() {
		
		return "DBBean2 [FName=" + FName + ", LName=" + LName + ", mail=" + mail + ",PNumber=" + PNumber + ", pwd=" + pwd + ", confirmpwd=" + confirmpwd + "]";
	}
	
}

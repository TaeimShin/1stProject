package project1.ver08;

import java.io.Serializable;


public class PhoneInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5261161644518495650L;
	String name; //이름
	String phoneNumber; //전화번호 
	
	//2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		//this.birthday = "입력되지않음";
	}
	public void showPhoneInfo()
	{
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		//System.out.println("생년월일:"+ birthday);
	}
	
	@Override
	public int hashCode() {
		
		int nameHashCode = name.hashCode();
		//System.out.println("nameHashCode = " +nameHashCode);
		return nameHashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo phoneinfo = (PhoneInfo)obj;
		//System.out.println("equals start");
		if(phoneinfo.name.equals(this.name)) {
			return true;
		}
		else
			return false;
	}
	
}

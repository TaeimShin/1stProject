package project1.ver08;

import java.io.Serializable;


public class PhoneCompanyInfo extends PhoneInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7052627809763401790L;
	String company;

	public PhoneCompanyInfo(String name, String phoneNumber, String company)
	{
		super(name, phoneNumber);
		this.company = company;
	}
	@override
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("회사:"+company);
	}
	
	@Override
	public int hashCode() {
		int nameHashCode = name.hashCode();
		//System.out.println("nameCHashCode = " +nameHashCode);
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

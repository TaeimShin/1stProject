package project1.ver08;

import java.io.Serializable;


public class PhoneSchoolInfo extends PhoneInfo implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8521236082401405622L;
	String major;
	int grade;
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade)
	{
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@override
	public void showPhoneInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
	}
	
	@Override
	public int hashCode() {
		int nameHashCode = name.hashCode();
		//System.out.println("nameSHashCode = " +nameHashCode);
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

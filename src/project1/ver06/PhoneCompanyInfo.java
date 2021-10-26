package project1.ver06;

public class PhoneCompanyInfo extends PhoneInfo
{
	String company;

	public PhoneCompanyInfo(String name, String phoneNumber, String company)
	{
		super(name, phoneNumber);
		this.company = company;
	}
	
	public void showPhoneCompanyInfo() {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		System.out.println("회사:"+company);
	}
	
}

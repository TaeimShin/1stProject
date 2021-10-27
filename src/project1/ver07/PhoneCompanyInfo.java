package project1.ver07;

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

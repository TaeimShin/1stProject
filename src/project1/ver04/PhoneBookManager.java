package project1.ver04;

import java.util.Scanner;
import project1.ver04.PhoneInfo;

public class PhoneBookManager
{
	PhoneInfo[] pi1 = new PhoneInfo[100];
	int inputVariable;

	public PhoneBookManager()
	{
	}

	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택:");
	}
	
	public void dataInput() {
		
		System.out.println("");
		
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택>>");
		int i = scan.nextInt();
		
		if(i == 1)
		{
			System.out.print("이름:");
			String name = scan1.nextLine();
			System.out.print("전화번호:");
			String phone = scan1.nextLine();
			
			PhoneInfo pi2 = new PhoneInfo(name,phone);
			pi1[inputVariable] = pi2;
			inputVariable++;
		}
		else if(i == 2)
		{
			System.out.print("이름:");
			String name = scan1.nextLine();
			System.out.print("전화번호:");
			String phone = scan1.nextLine();
			System.out.print("전공:");
			String major= scan1.nextLine();
			System.out.print("학년:");
			int grade = scan1.nextInt();
			
			PhoneSchoolInfo pi2 = new PhoneSchoolInfo(name,phone,major,grade);
			pi1[inputVariable] = pi2;
			inputVariable++;
		}
		else
		{
			System.out.print("이름:");
			String name = scan1.nextLine();
			System.out.print("전화번호:");
			String phone = scan1.nextLine();
			System.out.print("회사:");
			String company= scan1.nextLine();
			
			
			PhoneCompanyInfo pi2 = new PhoneCompanyInfo(name,phone,company);
			pi1[inputVariable] = pi2;
			inputVariable++;
		}
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	////////////데이터검색
	public void dataSearch() {
		System.out.println("");
		System.out.println("데이터 검색을 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		

		for(int i = 0 ; i < inputVariable ; i++)
		{
			if(pi1[i].name.equals(name))
			{
				System.out.println("name:"+pi1[i].name);
				System.out.println("phone:"+ pi1[i].phoneNumber);
				if(pi1[i] instanceof PhoneCompanyInfo)
				{
					System.out.println("company:"+((PhoneCompanyInfo)pi1[i]).company);
				}
				else if(pi1[i] instanceof PhoneSchoolInfo)
				{
					System.out.println("major:"+((PhoneSchoolInfo)pi1[i]).major);
					System.out.println("grade:"+((PhoneSchoolInfo)pi1[i]).grade);
					
				}
				break;
			}
		}
		System.out.println("");
	}
	
	////////////지우기
	public void dataDelete() {
		System.out.println("");
		System.out.println("데이터 삭제를 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		////////// 임시변수
		int flag =0;
		////////
		for(int i = 0 ; i < inputVariable ; i++)
		{
			if(pi1[i].name.equals(name))
			{
				System.out.println("데이터 삭제가 완료되었습니다.");
				flag = 1;
			}
			if(flag == 1 && i < (inputVariable -1)) //앞으로 당기기
			{
				if(pi1[i+1] instanceof PhoneCompanyInfo)
				{
					pi1[i] = (PhoneCompanyInfo)(pi1[i+1]);
				}
				else if(pi1[i+1] instanceof PhoneSchoolInfo)
				{					
					pi1[i] = (PhoneSchoolInfo)(pi1[i+1]);
				}
				else 
				{
					System.out.println("일반");
					pi1[i].name = pi1[i+1].name;
					pi1[i].phoneNumber = pi1[i+1].phoneNumber;
				}
				
			}
			else if(flag == 1 && i == (inputVariable -1))
			{				
				PhoneInfo pi2 = new PhoneInfo(null,null);
				pi1[i] = pi2;
				
			}
			
		}
		inputVariable--;
		System.out.println("");
	}
	////////////////////전체출력
	public void dataAllShow() {
		System.out.println("");
		for(int i = 0 ; i < inputVariable ; i++)
		{
			System.out.println("name:"+pi1[i].name);
			System.out.println("phone:"+ pi1[i].phoneNumber);
			
			if(pi1[i] instanceof PhoneCompanyInfo)
			{
				System.out.println("company:"+((PhoneCompanyInfo)pi1[i]).company);
			}
			else if(pi1[i] instanceof PhoneSchoolInfo)
			{
				System.out.println("major:"+((PhoneSchoolInfo)pi1[i]).major);
				System.out.println("grade:"+((PhoneSchoolInfo)pi1[i]).grade);
				
			}
			System.out.println("");
			System.out.println("");
				
		}
	}
}

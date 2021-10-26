package project1.ver06;

import java.util.Scanner;
import project1.ver06.PhoneInfo;
import project1.ver06.PhoneCompanyInfo;
import project1.ver06.PhoneSchoolInfo;

public class PhoneBookManager implements MenuItem, SubMenuItem
{
	PhoneInfo[] pi1 = new PhoneInfo[100];
	int inputVariable;

	public PhoneBookManager(){}

	public void printMenu() {
		System.out.println("");
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
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택>>");
		int i = scan1.nextInt();
		scan1.nextLine();
		
		try {
			System.out.print("이름:");
			String name = scan1.nextLine();
			System.out.print("전화번호:");
			String phone = scan1.nextLine();
			
			if(i == SubMenuItem.NORMAL_TYPE)
			{
				PhoneInfo pi2 = new PhoneInfo(name,phone);
				pi1[inputVariable] = pi2;
			}
			else if(i == SubMenuItem.SCHOOL_TYPE)
			{
				System.out.print("전공:");
				String major= scan1.nextLine();
				System.out.print("학년:");
				int grade = scan1.nextInt();
		
				PhoneSchoolInfo pi2 = new PhoneSchoolInfo(name,phone,major,grade);
				pi1[inputVariable] = pi2;
			}
			else if(i == SubMenuItem.COMPANY_TYPE)
			{
				System.out.print("회사:");
				String company= scan1.nextLine();
				PhoneCompanyInfo pi2 = new PhoneCompanyInfo(name,phone,company);
				pi1[inputVariable] = pi2;
			}
			else {
				throw new NullPointerException();
			}
		}
		catch(NullPointerException e) {
			System.out.println("결과를 찾을 수 없습니다.");
		}
		///////////////////입력 성공
		inputVariable++;
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	////////////데이터검색
	public void dataSearch() {
		System.out.println("");
		System.out.println("데이터 검색을 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		
		try {
			int i;
			for(i = 0 ; i < inputVariable ; i++)
			{
				if(pi1[i].name.equals(name))
				{
					if(pi1[i] instanceof PhoneCompanyInfo)
						((PhoneCompanyInfo)pi1[i]).showPhoneCompanyInfo();
					else if(pi1[i] instanceof PhoneSchoolInfo)
						((PhoneSchoolInfo)pi1[i]).showPhoneSchoolInfo();
					else
						pi1[i].showPhoneInfo();
				break;
				}	
				/////////////////
			}
			if(i == inputVariable)
				throw new NullPointerException();
		}
		catch(NullPointerException e)
		{
			System.out.println("검색결과 없음");			
		}
	}
	
	////////////지우기////////////////////////////////////////////
	public void dataDelete() {
		System.out.println("");
		System.out.println("데이터 삭제를 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		////////// 임시변수
		int flag =0;
		////////
		try {
			int i;
			for(i = 0 ; i < inputVariable ; i++)
			{
				if(pi1[i].name.equals(name))
				{
					System.out.println("데이터 삭제가 완료되었습니다.");
					flag = 1;
				}
				if(flag == 1 && i < (inputVariable -1)) //앞으로 당기기
				{
					if(pi1[i+1] instanceof PhoneCompanyInfo)
						pi1[i] = (PhoneCompanyInfo)(pi1[i+1]);
					else if(pi1[i+1] instanceof PhoneSchoolInfo)				
						pi1[i] = (PhoneSchoolInfo)(pi1[i+1]);
					else 
					{
						pi1[i].name = pi1[i+1].name;
						pi1[i].phoneNumber = pi1[i+1].phoneNumber;
					}
				}
				else if(flag == 1 && i == (inputVariable -1)) //맨 마지막꺼 없애기
				{				
					PhoneInfo pi2 = new PhoneInfo(null,null);
					pi1[i] = pi2;
					inputVariable--;
				}
			}
			if(i == inputVariable && flag == 0)
				throw new NullPointerException();
		}
		catch(NullPointerException e)
		{
			System.out.println("검색결과 없음");			
		}
		System.out.println("");
	}
	////////////////////전체출력/////////////////////////////////
	public void dataAllShow() {
		System.out.println("");
		for(int i = 0 ; i < inputVariable ; i++)
		{	
			if(pi1[i] instanceof PhoneCompanyInfo)
				((PhoneCompanyInfo)pi1[i]).showPhoneCompanyInfo();
			else if(pi1[i] instanceof PhoneSchoolInfo)
				((PhoneSchoolInfo)pi1[i]).showPhoneSchoolInfo();
			else
				pi1[i].showPhoneInfo();
			System.out.println("");
				
		}
	}
}

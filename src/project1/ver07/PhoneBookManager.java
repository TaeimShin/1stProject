package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver07.PhoneCompanyInfo;
import project1.ver07.PhoneSchoolInfo;

public class PhoneBookManager implements MenuItem, SubMenuItem
{

	HashSet<Object> pi1 = new HashSet<Object>(100);

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
		
		PhoneInfo pi2;
		try {
			System.out.print("이름:");
			String name = scan1.nextLine();
			System.out.print("전화번호:");
			String phone = scan1.nextLine();
			
			if(i == SubMenuItem.NORMAL_TYPE)
			{
				pi2 = new PhoneInfo(name,phone);
				//pi1[inputVariable] = pi2;
			}
			else if(i == SubMenuItem.SCHOOL_TYPE)
			{
				System.out.print("전공:");
				String major= scan1.nextLine();
				System.out.print("학년:");
				int grade = scan1.nextInt();
		
				PhoneSchoolInfo pi3 = new PhoneSchoolInfo(name,phone,major,grade);
				pi2 = pi3;
				//pi1[inputVariable] = pi2;
			}
			else if(i == SubMenuItem.COMPANY_TYPE)
			{
				System.out.print("회사:");
				String company= scan1.nextLine();
				PhoneCompanyInfo pi3 = new PhoneCompanyInfo(name,phone,company);
				pi2 = pi3;
				//pi1[inputVariable] = pi2;
			}
			else {
				throw new NullPointerException();
			}
///////////////////////////중복이 있는지 확인하기
			if(pi1.add(pi2) == false) // 만약 중복데이터라면
			{
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				char rewrite = scan1.next().charAt(0);

				if(rewrite == 'y' || rewrite == 'Y') // 덮어쓸거라면
				{
				/// 기존에 겹치는거 삭제하고 넣기	
					Iterator itr = pi1.iterator();
					while(itr.hasNext()) {
						PhoneInfo object = (PhoneInfo)itr.next();
						
						if(object.name.equals(pi2.name))
						{
							pi1.remove(object);
							pi1.add(pi2);
						}
					}
				}
			}	
		}
		catch(NullPointerException e) {
			System.out.println("결과를 찾을 수 없습니다.");
		}
		///////////////////입력 성공
	
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	////////////데이터검색
	public void dataSearch() {
		System.out.println("");
		System.out.println("데이터 검색을 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		int flag = 0;
		try {
			
			Iterator itr = pi1.iterator();
			while(itr.hasNext()) {
				PhoneInfo object = (PhoneInfo)itr.next();
				
				if(object.name.equals(name))
				{
					flag = 1;
					if(object instanceof PhoneCompanyInfo)
						((PhoneCompanyInfo)object).showPhoneCompanyInfo();
					else if(object instanceof PhoneSchoolInfo)
						((PhoneSchoolInfo)object).showPhoneSchoolInfo();
					else
						((PhoneInfo)object).showPhoneInfo();
				}
			}
			if(flag == 0)
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
			Iterator itr = pi1.iterator();
			while(itr.hasNext()) {
				PhoneInfo object = (PhoneInfo)itr.next();

				if(object.name.equals(name))
				{
					flag =1;
					itr.remove();
				}
			}

			if(flag == 0)
				throw new NullPointerException();
		}
		catch(NullPointerException e)
		{
			System.out.println("검색결과 없음");			
		}
		System.out.println("데이터 삭제 완료");

}
	////////////////////전체출력/////////////////////////////////
	public void dataAllShow() {
		System.out.println("");
		
		Iterator itr = pi1.iterator();
		while(itr.hasNext())
		{
			Object object = itr.next();
			if(object instanceof PhoneCompanyInfo)
				((PhoneCompanyInfo)object).showPhoneCompanyInfo();
			else if(object instanceof PhoneSchoolInfo)
				((PhoneSchoolInfo)object).showPhoneSchoolInfo();
			else
				((PhoneInfo)object).showPhoneInfo();
			
		}
	}
}

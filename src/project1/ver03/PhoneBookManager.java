package project1.ver03;

import java.util.Scanner;

import project1.ver03.PhoneInfo;

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
		
		System.out.println("데이터 입력을 시작합니다..");
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("전화번호:");
		String phone = scan1.nextLine();
		System.out.print("생년월일:");
		String birth = scan.nextLine();
		
		PhoneInfo pi2 = new PhoneInfo(name,phone,birth);
		pi1[inputVariable] = pi2;
		inputVariable++;
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	
	public void dataSearch() {
		
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
				System.out.println("birth:"+pi1[i].birthday);
				System.out.println("데이터 검색이 완료되었습니다.");
				break;
			}
		}
	}
	
	
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		
		int flag =0;
		for(int i = 0 ; i < inputVariable ; i++)
		{
			if(pi1[i].name.equals(name))
			{
				System.out.println("데이터 삭제가 완료되었습니다.");
				flag = 1;
			}
			if(flag == 1 && i < (inputVariable -1)) //앞으로 당기기
			{
				pi1[i].name = pi1[i+1].name;
				pi1[i].phoneNumber = pi1[i+1].phoneNumber;
				pi1[i].birthday = pi1[i+1].birthday;
				inputVariable--;
			}
			else if(flag == 1 && i == (inputVariable -1))
			{
				pi1[i].name = null;
				pi1[i].phoneNumber = null;
				pi1[i].birthday = null;
				inputVariable--;
			}
			
		}
	}
	public void dataAllShow() {
		for(int i = 0 ; i < inputVariable ; i++)
		{
			System.out.println("name:"+pi1[i].name);
			System.out.println("phone:"+ pi1[i].phoneNumber);
			System.out.println("birth:"+pi1[i].birthday);
				
		}
	}
}

package project1;
import java.util.Scanner;

//수정!
import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{

	public static void main(String[] args)
	{
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			Scanner scan1 = new Scanner(System.in);
			/////
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 프로그램 종료");
			System.out.print("선택:");
			int choice = scan.nextInt();
			scan.nextLine();
			
			
			if(choice == 1)
			{
				
				System.out.print("이름: ");
				String name = scan.nextLine();
				System.out.print("전화번호:");
				String phone = scan1.nextLine();
				System.out.print("생년월일:");
				String birth = scan.nextLine();
				
				PhoneInfo pi1 = new PhoneInfo(name,phone,birth);
				
				System.out.println("");
				System.out.println("입력된 정보 출력...");
				pi1.showPhoneInfo();
				
			}
			else
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		
		}
	}

}

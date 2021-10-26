package project1;
import java.util.Scanner;

//수정!

import project1.ver04.PhoneBookManager;

public class PhoneBookVer04
{

	public static void main(String[] args)
	{
		//PhoneInfo[] pi1 = new PhoneInfo[100];
		PhoneBookManager pbm = new PhoneBookManager();
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			
			pbm.printMenu();
			int choice = scan.nextInt();
			
			if(choice == 1) //데이터 입력
			{
				pbm.dataInput();
				
			}
			else if(choice == 2)
			{
				pbm.dataSearch();
			}
			else if(choice == 3)
			{
				pbm.dataDelete();
			}
			else if(choice == 4)
			{
				pbm.dataAllShow();
			}
			else
			{				
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		
		}
	}

}

package project1;
import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;
//수정!


public class PhoneBookVer05 implements MenuItem
{

	public static void main(String[] args)
	{
		PhoneBookManager pbm = new PhoneBookManager();
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			
			pbm.printMenu();
			int choice = scan.nextInt();
			
			if(choice == MenuItem.DATA_INPUT)
				pbm.dataInput();			
			else if(choice == MenuItem.DATA_SEARCH)
				pbm.dataSearch();
			else if(choice == MenuItem.DATA_DELETE)
				pbm.dataDelete();
			else if(choice == MenuItem.DATA_SHOW)
				pbm.dataAllShow();
			else if(choice == MenuItem.TERMINATE)	
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else
			{
				System.out.println("잘못입력했");
			}
		
		}
	}

}

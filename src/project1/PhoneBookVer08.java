package project1;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.MenuItem;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.MenuSelectException;
//수정!


public class PhoneBookVer08 implements MenuItem
{

	public static void main(String[] args)
	{
		
		PhoneBookManager pbm = new PhoneBookManager();
			
		while(true)
		{
			try {
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
				else if(choice == MenuItem.DATA_SAVE)	
				{
					pbm.autoSave();
				}
				else if(choice == MenuItem.TERMINATE)
				{
					pbm.saveData();
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				else
				{
					throw new MenuSelectException();
				}
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
				continue;
			}
			catch(InputMismatchException e) {
				System.out.println("정수 입력해주세요");
				continue;
			}
			
			
		}
		
	}

}

package project1;
import java.util.Scanner;

//수정!
import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookManager;

public class PhoneBookVer09
{

	public static void main(String[] args)
	{
		
		PhoneBookManager pbm = new PhoneBookManager();
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			
			pbm.printMenu();
			int choice = scan.nextInt();
			
			if(choice == 1) 
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
				pbm.terminate();
				break;
			}
		
		}
	}

}

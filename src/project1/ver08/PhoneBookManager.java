package project1.ver08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager implements MenuItem, SubMenuItem
{

	static HashSet<Object> pi1 = new HashSet<Object>(100);
	AutoSaverT dt;
	
	public PhoneBookManager(){
		readData();
	}

	public void printMenu() {
		System.out.println("");
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 저장옵션");
		System.out.println("6. 종료");
		System.out.print("선택:");
	}
	//////////////////데이터 입력///////////////////
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
			
			if(i == SubMenuItem.NORMAL_TYPE) ///////일반데이터
			{
				pi2 = new PhoneInfo(name,phone);
			}
			else if(i == SubMenuItem.SCHOOL_TYPE) ////////학교데이터
			{
				System.out.print("전공:");
				String major= scan1.nextLine();
				System.out.print("학년:");
				int grade = scan1.nextInt();
		
				PhoneSchoolInfo pi3 = new PhoneSchoolInfo(name,phone,major,grade);
				pi2 = pi3;
			}
			else if(i == SubMenuItem.COMPANY_TYPE)//////////회사데이터
			{
				System.out.print("회사:");
				String company= scan1.nextLine();
				PhoneCompanyInfo pi3 = new PhoneCompanyInfo(name,phone,company);
				pi2 = pi3;
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
					pi1.remove(pi2);
					pi1.add(pi2);
				}
			}	
		}
		catch(NullPointerException e) {
			System.out.println("결과를 찾을 수 없습니다.");
		}
		///////////////////입력 성공
	
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	////////////데이터검색/////////////////////////
	public void dataSearch() {
		System.out.println("");
		System.out.println("데이터 검색을 시작합니다..");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름:");
		String name = scan.nextLine();
		int flag = 0; // 찾고자 하는 정보가 있는지 없는지 오류 판별용 변수
		try {
			
			Iterator itr = pi1.iterator();
			while(itr.hasNext()) { /////////////데이터 하나씩 꺼내서
				PhoneInfo object = (PhoneInfo)itr.next();
				
				if(object.name.equals(name)) ///////name이 같은지 판별
				{
					flag = 1; // 일치하는 데이터가 있으니 변수값 변경
					/////////////찾은 데이터 출력부분////////
					if(object instanceof PhoneCompanyInfo)
						((PhoneCompanyInfo)object).showPhoneInfo();
					else if(object instanceof PhoneSchoolInfo)
						((PhoneSchoolInfo)object).showPhoneInfo();
					else
						((PhoneInfo)object).showPhoneInfo();
				}
			}
			if(flag == 0) // 일치하는 데이터가 없다면/ 잘못 입력했다면 예외처리로 throw
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
		////////// 오류 확인용 변수 flag
		int flag =0;
		////////
		try {
			Iterator itr = pi1.iterator();
			while(itr.hasNext()) { //객체에서 하나씩 object꺼내서 
				PhoneInfo object = (PhoneInfo)itr.next();

				if(object.name.equals(name)) // 찾고자하는 이름과 일치하는지 확인
				{
					flag =1;
					itr.remove();
				}
			}

			if(flag == 0) //일치하는게 없다면 오류발생 throw
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
				((PhoneCompanyInfo)object).showPhoneInfo();
			else if(object instanceof PhoneSchoolInfo)
				((PhoneSchoolInfo)object).showPhoneInfo();
			else
				((PhoneInfo)object).showPhoneInfo();
			System.out.println("");
			
		}
	}
	/////////////////////자동저장////////////////////
	
	public void autoSave() {
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1. 자동저장On, 2.자동저장Off");
		System.out.print("선택:");
		Scanner scan = new Scanner(System.in);
		int saveOption = scan.nextInt();	
		try {
			
			if(saveOption == 1) //자동 저장 on
			{
				if(Thread.activeCount() == 2) /* 실행중인 thread의 갯수가 2개라면 이미 실행중
					main으로 돌아가는 쓰레드, 1개만 돌아가야함*/
				{
					System.out.println("이미 자동저장이 실행중입니다.");
				}
				else{ // 자동저장 쓰레드 생성, 실행
					dt = new AutoSaverT();
					dt.setDaemon(true);
					System.out.println("자동저장을 시작합니다.");
					dt.start();
				}
			}
			else if(saveOption == 2)//자동저장 off
			{
				dt.interrupt(); 
			}
			else
				throw new NullPointerException();
			
		}
		catch(NullPointerException e)
		{
			System.out.println("1,2만 입력가능, 오류");
		}
	}
	/////////////////////프로그램 종료시 저장////////////////
	public void saveData() {
		try {
			ObjectOutputStream out =
					new ObjectOutputStream(
							new FileOutputStream("src/project1/ver08/PhoneBook.obj"));
			
			Iterator itr = pi1.iterator();
			while(itr.hasNext())
			{
				Object object = itr.next();
				//PhoneInfo object = (PhoneInfo)itr.next();
				out.writeObject(object);	
			}		
		}
		catch(Exception e) {
			System.out.println("데이터 직렬화시 예외발생");
			e.printStackTrace();
		}		
	}
	/////////////////프로그램 시작시 복원////////////////
	public void readData() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream("src/project1/ver08/PhoneBook.obj"));
							//new FileInputStream("src/project1/ver08/AutoSaveBook.txt"));
					
			while(true) {
				Object ob = in.readObject();
				pi1.add(ob);
				if(ob == null) break;
			}
		}
		catch(EOFException e)
		{
			System.out.println("복원완료");
		}
		catch(Exception e)
		{
			System.out.println("복원시 오류발생");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}

package project1.ver08;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class AutoSaverT extends Thread
{
	@Override
	public void run() {
		
		while(true)
		{
			try {
				ObjectOutputStream out=
						new ObjectOutputStream(
								new FileOutputStream("src/project1/ver08/AutoSaveBook.txt"));
				
				//phonebookmanager에서 사용중인 객체와 같은 타입의 새로운 객체 생성해서 받아오고?
				HashSet<Object> pi = new HashSet<Object>(100);
				pi = PhoneBookManager.pi1; 
				
				Iterator itr = pi.iterator();
				while(itr.hasNext()) 
				{
					Object object = itr.next();
					out.writeObject(object);	//파일에 저장
				}
				out.close();
				Thread.sleep(5000); //5초마다 자동ㅇ저장 그리고 인터럽트를 위한 일시정지?
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			}
			catch(InterruptedException e)
			{
				System.out.println("자동저장 off");
				break; //무한루프 탈출 쓰레드 종료
			}
			catch(Exception e) {
				System.out.println("자동저장 오류");
				e.printStackTrace();
			}
		}
		
	}
	
}

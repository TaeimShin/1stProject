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
				ObjectOutputStream out =
						new ObjectOutputStream(
								new FileOutputStream("src/project1/ver08/AutoSaveBook.txt"));
				
				HashSet<Object> pi = new HashSet<Object>(100);
				pi = PhoneBookManager.pi1;
				Iterator itr = pi.iterator();
				while(itr.hasNext())
				{
					Object object = itr.next();
					out.writeObject(object);	
				}
				Thread.sleep(5000);
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			}
			catch(InterruptedException e)
			{
				System.out.println("자동저장 off");
				break;
			}
			catch(Exception e) {
				System.out.println("자동저장 오류");
				e.printStackTrace();
			}
		}
		
	}
	
}

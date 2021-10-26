package project1.ver06;

public class MenuSelectException extends Exception
{
	//public MenuselectException() {}
	
	public MenuSelectException() {
		super("1~5사이의 정수를 입력해주세요");
	}
}

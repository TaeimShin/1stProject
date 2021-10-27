package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IConnectImpl implements IConnect{
	
	public Connection con;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	//기본생성자 default
	public IConnectImpl() {
		System.out.println("기본 생성자 호출");
	}
	
	//인자생성자1 : 아이디, 패스워드를 인자로 받음
	public IConnectImpl(String user, String pass) {
		System.out.println("IConnectImpl 인자생성자 호출");
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user,pass);
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//오라클에 연결
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL,user,pass);
			
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
		
	}
	//오버라이딩의 목적으로 정의한 메서드. 쿼리실행은 각 클래스에서 기술함
	@Override
	public void execute() {
	//실행부없음	
	}
	
	//자원반납
	@Override
	public void close() {
		try {
			if(psmt!= null) psmt.close();
			if(con!=null) con.close();
			if(rs!=null) rs.close();
			System.out.println("자원반납완료");
		}
		catch(Exception e) {
			System.out.println("자원반납시 오류가 발생하였습니다.");
		}
	}

	//사용자로부터 입력값을 받기 위한 메서드
	@Override
	public String scanValue(String title) {
		Scanner scan = new Scanner(System.in);
		System.out.print(title+"을 입력:");
		String inputStr = scan.nextLine();
		/*
		 equalsIgnoreCase()
		 	: equals()와 동일하게 문자열이 같은지를 비교하는 메소드
		 	대소문자를 구분없이 비교할 수 있다.
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0);// 프로그램 자체를 즉시 종료시킴.
		}
		return inputStr;
	}
	
}
